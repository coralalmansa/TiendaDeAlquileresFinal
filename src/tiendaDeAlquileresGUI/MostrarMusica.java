package tiendaDeAlquileresGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import tiendaDeAlquileres.AnioNoValidoException;
import tiendaDeAlquileres.DescripcionNoValidaException;
import tiendaDeAlquileres.GeneroNoValidoException;
import tiendaDeAlquileres.GestionAlquileres;
import tiendaDeAlquileres.IdNoValidoException;
import tiendaDeAlquileres.InterpreteNoValidoException;
import tiendaDeAlquileres.Musica;
import tiendaDeAlquileres.NumeroCancionesNoValidoException;
import tiendaDeAlquileres.Producto;
import tiendaDeAlquileres.ProductoYaExisteException;
import tiendaDeAlquileres.TiendaDeAlquiler;
import tiendaDeAlquileres.TipoProducto;
import tiendaDeAlquileres.TituloNoValidoException;


/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class MostrarMusica extends VentanaPadre {

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
	
	public MostrarMusica() {
		textFieldIdentificador.setLocation(226, 14);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		setModal(true);
		setTitle("Mostrar música");
		
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
	 * Genera una tienda con los productos de  musica.
	 * 
	 * @return Tienda con productos de musica
	 */
	private TiendaDeAlquiler generarTienda() {
		TiendaDeAlquiler tiendaMusica = new TiendaDeAlquiler();
		for (int i = 0; i<GestionAlquileres.getTiendaDeAlquiler().size(); i++){
			if (GestionAlquileres.getTiendaDeAlquiler().get(i).getTipo() == TipoProducto.MUSICA)
				try{
					tiendaMusica.aniadir(GestionAlquileres.getTiendaDeAlquiler().get(i).getId(), 
							GestionAlquileres.getTiendaDeAlquiler().get(i).getTitulo(),
							GestionAlquileres.getTiendaDeAlquiler().get(i).getAnio(),
							GestionAlquileres.getTiendaDeAlquiler().get(i).getDescripcion(),
							((Musica) GestionAlquileres.getTiendaDeAlquiler().get(i)).getInterprete(),
							((Musica) GestionAlquileres.getTiendaDeAlquiler().get(i)).getNumeroCanciones(),
							((Musica) GestionAlquileres.getTiendaDeAlquiler().get(i)).getGenero());
				}catch(ProductoYaExisteException | IdNoValidoException
						| TituloNoValidoException | AnioNoValidoException
						| InterpreteNoValidoException | NumeroCancionesNoValidoException
						| DescripcionNoValidaException | GeneroNoValidoException e ){					
				}
		}
		return tiendaMusica;	
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
	 * Muestra las caracteristicas de un producto música.
	 * @param producto
	 */
	private void mostrarProducto(Producto producto){
		Musica musica = (Musica) producto;
		textFieldIdentificador.setText(musica.getId());
		textFieldTitulo.setText(musica.getTitulo());
		textFieldAutorInterpreteDirector.setText(musica.getInterprete());
		textFieldDescripcion.setText(musica.getDescripcion());
		textFieldAnio.setText(String.valueOf(musica.getAnio()));
		textFieldDuracion.setText(String.valueOf(musica.getNumeroCanciones()));
		rdbtnMusica.setSelected(true);
		comboBoxGeneroMusical.addItem(musica.getGenero());
		comboBoxGeneroMusical.setSelectedItem(musica.getGenero());
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
