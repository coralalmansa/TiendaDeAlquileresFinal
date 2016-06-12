package tiendaDeAlquileresGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tiendaDeAlquileres.GestionAlquileres;
import tiendaDeAlquileres.Libro;
import tiendaDeAlquileres.Musica;
import tiendaDeAlquileres.Pelicula;
import tiendaDeAlquileres.Producto;
import tiendaDeAlquileres.ProductoNoExisteException;
import javax.swing.JButton;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class MostrarPorTitulo extends VentanaPadre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MostrarPorTitulo() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		setModal(true);
		setTitle("Mostrar por titulo");
		btnEnviar.setText("Buscar");
		
		textFieldDescripcion.setEditable(false);
		comboBoxEditorial.setEnabled(false);
		comboBoxGeneroMusical.setEnabled(false);
		comboBoxGeneroCinematografico.setEnabled(false);
		comboBoxGeneroEditorial.setEnabled(false);
		textFieldDuracion.setEditable(false);
		textFieldAutorInterpreteDirector.setEditable(false);
		textFieldIdentificador.setEditable(false);
		textFieldAnio.setEditable(false);
		rdbtnMusica.setEnabled(false);
		rdbtnPelicula.setEnabled(false);
		rdbtnLibro.setEnabled(false);
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		btnDisponible.setVisible(false);
		panel_1.setVisible(false);
			
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldIdentificador.setText("");
				textFieldTitulo.setText("");
				textFieldAutorInterpreteDirector.setText("");
				textFieldAnio.setText("");
				textFieldDescripcion.setText("");
				textFieldDuracion.setText("");
				buttonGroup.clearSelection();
				comboBoxGeneroCinematografico.setSelectedItem(null);
				comboBoxGeneroEditorial.setSelectedItem(null);
				comboBoxGeneroMusical.setSelectedItem(null);
				comboBoxEditorial.setSelectedItem(null);
			}	
		});
		btnLimpiar.setBounds(127, 376, 89, 23);
		contentPanel.add(btnLimpiar);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto producto;
				try{
					producto = GestionAlquileres.getTiendaDeAlquiler().getProducto(textFieldTitulo.getText());
					mostrarProducto(producto);
					isDisponible();
				}catch(ProductoNoExisteException e1){
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});	
	}

	/**
	 * Muestra las caracteristicas de un producto.
	 * @param producto
	 * 				Producto a mostrar
	 */
	public void mostrarProducto(Producto producto){
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