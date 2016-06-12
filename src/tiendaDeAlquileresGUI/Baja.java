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
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Baja extends VentanaPadre {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public Baja() {
		textFieldIdentificador.setLocation(226, 14);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		textFieldDescripcion.setEditable(false);
		
		setModal(true);
		setTitle("Baja");
		
		btnEnviar.setText("Baja");
		
		rdbtnMusica.setEnabled(false);
		rdbtnPelicula.setEnabled(false);
		rdbtnLibro.setEnabled(false);
		comboBoxEditorial.setEnabled(false);
		textFieldAnio.setEditable(false);
		comboBoxGeneroMusical.setEnabled(false);
		comboBoxGeneroCinematografico.setEnabled(false);
		comboBoxGeneroEditorial.setEnabled(false);
		textFieldDuracion.setEditable(false);
		textFieldAutorInterpreteDirector.setEditable(false);
		textFieldTitulo.setEditable(false);
	
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		btnDisponible.setVisible(false);
		panel_1.setVisible(false);
	
		btnEnviar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Producto producto;
				try{
					producto = GestionAlquileres.getTiendaDeAlquiler().get(textFieldIdentificador.getText());
					mostrarProducto(producto);
					isDisponible();
					int i = JOptionPane.showOptionDialog(null, 
							"¿Está seguro de que desea eliminar el producto?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (i){
						case JOptionPane.YES_OPTION:
							GestionAlquileres.getTiendaDeAlquiler().eliminar(textFieldIdentificador.getText());
							GestionAlquileres.setModificado(true);
							limpiar();
							break;
						case JOptionPane.NO_OPTION:
							return;
						case JOptionPane.CANCEL_OPTION:
							return;	
					}
				}catch (ProductoNoExisteException e1){
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			}
					
		});
		
	}
	
	/**
	 * Borra el contenido del diálogo.
	 */
	private void limpiar(){
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
		panel_1.setVisible(false);
	}
	
	/**
	 * Muestra las características de un producto.
	 * 
	 * @param producto
	 * 			Producto que se va a mostrar
	 */
	private void mostrarProducto(Producto producto){
		if(producto instanceof Pelicula){
			Pelicula pelicula = (Pelicula) producto;
			textFieldTitulo.setText(pelicula.getTitulo());
			textFieldAnio.setText(String.valueOf(pelicula.getAnio()));
			textFieldDescripcion.setText(pelicula.getDescripcion());
			textFieldAutorInterpreteDirector.setText(pelicula.getDirector());
			textFieldDuracion.setText(String.valueOf(pelicula.getDuracion()));
			rdbtnPelicula.setSelected(true);
			comboBoxGeneroCinematografico.addItem(pelicula.getGenero());
			comboBoxGeneroCinematografico.setSelectedItem(pelicula.getGenero());
		}else if(producto instanceof Musica){
			Musica musica = (Musica) producto;
			textFieldTitulo.setText(musica.getTitulo());
			textFieldAnio.setText(String.valueOf(musica.getAnio()));
			textFieldDescripcion.setText(musica.getDescripcion());
			textFieldAutorInterpreteDirector.setText(musica.getInterprete());
			textFieldDuracion.setText(String.valueOf(musica.getNumeroCanciones()));
			rdbtnMusica.setSelected(true);
			comboBoxGeneroMusical.addItem(musica.getGenero());
			comboBoxGeneroMusical.setSelectedItem(musica.getGenero());
		}else{
			Libro libro = (Libro) producto;
			textFieldTitulo.setText(libro.getTitulo());
			textFieldAnio.setText(String.valueOf(libro.getAnio()));
			textFieldDescripcion.setText(libro.getDescripcion());
			textFieldAutorInterpreteDirector.setText(libro.getAutor());
			textFieldDuracion.setText(String.valueOf(libro.getNumeroPaginas()));
			rdbtnLibro.setSelected(true);
			comboBoxGeneroEditorial.addItem(libro.getGenero());
			comboBoxGeneroEditorial.setSelectedItem(libro.getGenero());		
		}		
	}
}
