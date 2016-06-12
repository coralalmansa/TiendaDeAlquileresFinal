package tiendaDeAlquileresGUI;

import tiendaDeAlquileres.GestionAlquileres;
import tiendaDeAlquileres.Libro;
import tiendaDeAlquileres.Musica;
import tiendaDeAlquileres.Pelicula;
import tiendaDeAlquileres.Producto;
import tiendaDeAlquileres.TiendaDeAlquiler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Mostrar extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TiendaDeAlquiler tiendaDeAlquiler;
	/**
	 * Índice del producto
	 */
	private int index = -1;
	
	public Mostrar() {
		
		textFieldDescripcion.setEditable(false);
		textFieldIdentificador.setLocation(226, 14);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		setModal(true);	
		setTitle("Mostrar");
		
		this.tiendaDeAlquiler = GestionAlquileres.getTiendaDeAlquiler();
		
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
			
		btnEnviar.setVisible(false);
		btnDisponible.setVisible(false);
	
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
	 * Actualiza el contenido.
	 */
	private void actualizar(){
		if (tiendaDeAlquiler.size() == 0){
			return;
		}
		index = 0;
		mostrarProducto(tiendaDeAlquiler.get(index));
		comprobarBotones();
	}
	
	/**
	 * Muestra el producto anterior en la tienda.
	 */
	private void mostrarAnterior(){
		mostrarProducto(tiendaDeAlquiler.get(--index));
		comprobarBotones();
	}
	
	/**
	 * Muestra el producto siguiente en la tienda.
	 */
	private void mostrarSiguiente(){
		mostrarProducto(tiendaDeAlquiler.get(++index));
		comprobarBotones();
	}
	
	/**
	 * Comprueba si existe otro producto en la tienda
	 */
	private void comprobarBotones(){
		if(tiendaDeAlquiler.get(index + 1) == null)
			btnSiguiente.setEnabled(false);
		else
			btnSiguiente.setEnabled(true);
		
		if(tiendaDeAlquiler.get(index - 1) == null)
			btnAnterior.setEnabled(false);
		else
			btnAnterior.setEnabled(true);
	}
	
	/**
	 * Muestra las caracteristicas de un producto.
	 * @param producto
	 * 				Producto a mostrar
	 */
	private void mostrarProducto(Producto producto){
		if(producto instanceof Pelicula){
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
				
		}else if (producto instanceof Musica){
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
		
		}else{
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
	
	}

}