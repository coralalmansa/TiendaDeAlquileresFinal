package tiendaDeAlquileresGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tiendaDeAlquileres.AnioNoValidoException;
import tiendaDeAlquileres.DescripcionNoValidaException;
import tiendaDeAlquileres.DirectorNoValidoException;
import tiendaDeAlquileres.DuracionPeliculaNoValidaException;
import tiendaDeAlquileres.GeneroNoValidoException;
import tiendaDeAlquileres.GestionAlquileres;
import tiendaDeAlquileres.IdNoValidoException;

import tiendaDeAlquileres.Producto;
import tiendaDeAlquileres.ProductoYaExisteException;
import tiendaDeAlquileres.TiendaDeAlquiler;
import tiendaDeAlquileres.TipoProducto;
import tiendaDeAlquileres.TituloNoValidoException;
import tiendaDeAlquileres.Pelicula;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class MostrarPeliculas extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TiendaDeAlquiler tiendaDeAlquiler;
	
	/**
	 * Índice del producto.
	 */
	private int index = -1;
	
	private JButton btnAnterior;
	private JButton btnSiguiente;
	
	public MostrarPeliculas() {
		textFieldIdentificador.setLocation(226, 14);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		setModal(true);
		setTitle("Mostrar películas");
		
		this.tiendaDeAlquiler = generarTienda();
		
		rdbtnMusica.setEnabled(false);
		rdbtnPelicula.setEnabled(false);
		rdbtnLibro.setEnabled(false);
		comboBoxEditorial.setEnabled(false);
		comboBoxGeneroMusical.setEnabled(false);
		comboBoxGeneroCinematografico.setEnabled(false);
		comboBoxGeneroEditorial.setEnabled(false);
		textFieldAnio.setEditable(false);
		textFieldIdentificador.setEditable(false);
		textFieldDuracion.setEditable(false);
		textFieldAutorInterpreteDirector.setEditable(false);
		textFieldTitulo.setEditable(false);
		panel_1.setVisible(false);
		btnDisponible.setVisible(false);

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();		
	}

	/**
	 * Genera una tienda con las películas.
	 * 
	 * @return Tienda con las películas
	 */
	private TiendaDeAlquiler generarTienda() {
		TiendaDeAlquiler tiendaPeliculas = new TiendaDeAlquiler();
		for (int i = 0; i<GestionAlquileres.getTiendaDeAlquiler().size(); i++){
			if (GestionAlquileres.getTiendaDeAlquiler().get(i).getTipo() == TipoProducto.PELICULA)
				try{
					tiendaPeliculas.aniadir(GestionAlquileres.getTiendaDeAlquiler().get(i).getId(), 
							GestionAlquileres.getTiendaDeAlquiler().get(i).getTitulo(),
							GestionAlquileres.getTiendaDeAlquiler().get(i).getAnio(),
							GestionAlquileres.getTiendaDeAlquiler().get(i).getDescripcion(),
							((Pelicula) GestionAlquileres.getTiendaDeAlquiler().get(i)).getDirector(),
							((Pelicula) GestionAlquileres.getTiendaDeAlquiler().get(i)).getDuracion(),
							((Pelicula) GestionAlquileres.getTiendaDeAlquiler().get(i)).getGenero());
				}catch(ProductoYaExisteException | IdNoValidoException | DuracionPeliculaNoValidaException 
						| GeneroNoValidoException | DirectorNoValidoException | TituloNoValidoException 
						| AnioNoValidoException | DescripcionNoValidaException e ){					
				}
		}
		return tiendaPeliculas;	
	}
	
	/**
	 * Actualiza el contenido.
	 */
	private void actualizar(){
		if(tiendaDeAlquiler.size() == 0){
			return;
		}
		index = 0;
		mostrarProducto(tiendaDeAlquiler.get(index));
		comprobarBotones();
	}
	
	/**
	 * Muestra el siguiente producto de la tienda.
	 */
	private void mostrarSiguiente(){
		mostrarProducto(tiendaDeAlquiler.get(++index));
		comprobarBotones();
	}
	
	/**
	 * Muestra el anterior producto de la tienda.
	 */
	private void mostrarAnterior(){
		mostrarProducto(tiendaDeAlquiler.get(--index));
		comprobarBotones();
	}
	
	/**
	 * Comprueba si existe otro producto en la tienda.
	 */
	private void comprobarBotones() {
		if (tiendaDeAlquiler.get(index + 1) == null)
			btnSiguiente.setEnabled(false);
		else
			btnSiguiente.setEnabled(true);

		if (tiendaDeAlquiler.get(index - 1) == null)
			btnAnterior.setEnabled(false);
		else
			btnAnterior.setEnabled(true);
	}
	
	/**
	 * Muestra las caracteristicas de las peliculas-
	 * @param producto
	 */
	private void mostrarProducto(Producto producto){
		Pelicula pelicula = (Pelicula) producto;
		textFieldIdentificador.setText(pelicula.getId());
		textFieldTitulo.setText(pelicula.getTitulo());
		textFieldAutorInterpreteDirector.setText(pelicula.getDirector());
		textFieldDescripcion.setText(pelicula.getDescripcion());
		textFieldAnio.setText(String.valueOf(pelicula.getAnio()));
		textFieldDuracion.setText(String.valueOf(pelicula.getDuracion()));
		rdbtnPelicula.setSelected(true);
		comboBoxGeneroCinematografico.addItem(pelicula.getGenero());
		comboBoxGeneroCinematografico.setSelectedItem(pelicula.getGenero());
		isDisponible();
		
	}
	
	/**
	 * Devuelve la tienda
	 * @return
	 */
	TiendaDeAlquiler getTiendaDeAlquiler(){
		return tiendaDeAlquiler;
	}

}
