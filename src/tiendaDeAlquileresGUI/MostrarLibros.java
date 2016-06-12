package tiendaDeAlquileresGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tiendaDeAlquileres.AnioNoValidoException;
import tiendaDeAlquileres.AutorNoValidoException;
import tiendaDeAlquileres.DescripcionNoValidaException;
import tiendaDeAlquileres.EditorialNoValidaException;
import tiendaDeAlquileres.GeneroNoValidoException;
import tiendaDeAlquileres.GestionAlquileres;
import tiendaDeAlquileres.IdNoValidoException;

import tiendaDeAlquileres.Libro;

import tiendaDeAlquileres.NumeroPaginasNoValidoException;
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
public class MostrarLibros extends VentanaPadre {

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
	
	
	public MostrarLibros() {
		textFieldIdentificador.setLocation(226, 14);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		setModal(true);
		
		setTitle("Mostrar libros");
		
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
	 * Genera una tienda con los libros.
	 * 
	 * @return Tienda con los libros
	 */
	private TiendaDeAlquiler generarTienda() {
		TiendaDeAlquiler tiendaLibros = new TiendaDeAlquiler();
		for (int i = 0; i<GestionAlquileres.getTiendaDeAlquiler().size(); i++){
			if (GestionAlquileres.getTiendaDeAlquiler().get(i).getTipo() == TipoProducto.LIBRO)
				try{
					tiendaLibros.aniadir(GestionAlquileres.getTiendaDeAlquiler().get(i).getId(), 
							GestionAlquileres.getTiendaDeAlquiler().get(i).getTitulo(),
							GestionAlquileres.getTiendaDeAlquiler().get(i).getAnio(),
							GestionAlquileres.getTiendaDeAlquiler().get(i).getDescripcion(),
							((Libro) GestionAlquileres.getTiendaDeAlquiler().get(i)).getAutor(),
							((Libro) GestionAlquileres.getTiendaDeAlquiler().get(i)).getNumeroPaginas(),
							((Libro) GestionAlquileres.getTiendaDeAlquiler().get(i)).getGenero(),
							((Libro) GestionAlquileres.getTiendaDeAlquiler().get(i)).getEditorial());
				}catch(IdNoValidoException | NumeroPaginasNoValidoException 
						| GeneroNoValidoException |AutorNoValidoException | TituloNoValidoException
						| AnioNoValidoException | DescripcionNoValidaException | EditorialNoValidaException
						|ProductoYaExisteException e ){					
				}
		}
		return tiendaLibros;	
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
	
	private void mostrarProducto(Producto producto){
		Libro libro = (Libro) producto;
		textFieldIdentificador.setText(libro.getId());
		textFieldTitulo.setText(libro.getTitulo());
		textFieldAutorInterpreteDirector.setText(libro.getAutor());
		textFieldDescripcion.setText(libro.getDescripcion());
		textFieldAnio.setText(String.valueOf(libro.getAnio()));
		textFieldDuracion.setText(String.valueOf(libro.getNumeroPaginas()));
		comboBoxGeneroEditorial.addItem(libro.getGenero());
		comboBoxGeneroEditorial.setSelectedItem(libro.getGenero());
		comboBoxEditorial.addItem(libro.getEditorial());
		comboBoxEditorial.setSelectedItem(libro.getEditorial());
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
