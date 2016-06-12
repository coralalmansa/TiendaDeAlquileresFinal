package tiendaDeAlquileresGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tiendaDeAlquileres.Alquiler;
import tiendaDeAlquileres.GestionAlquileres;
import tiendaDeAlquileres.Libro;
import tiendaDeAlquileres.Musica;
import tiendaDeAlquileres.Pelicula;
import tiendaDeAlquileres.Producto;
import tiendaDeAlquileres.ProductoDisponibleException;
import tiendaDeAlquileres.ProductoNoExisteException;
import javax.swing.JLabel;

/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Devolver extends VentanaPadre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JTextField textFieldFechaAlquiler;
	private JTextField textFieldFechaDevolucion;

	public Devolver() {
		panel_1.setLocation(217, 245);
		textFieldDescripcion.setEditable(false);
		comboBoxEditorial.setEnabled(false);
		comboBoxGeneroEditorial.setEnabled(false);
		panel_1.setVisible(false);
		btnDisponible.setVisible(false);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		setModal(true);
		setTitle("Devolver producto");
		
		btnEnviar.setText("Devolver");
		
		textFieldTitulo.setEditable(false);
		textFieldAutorInterpreteDirector.setEditable(false);
		textFieldDuracion.setEditable(false);
		textFieldAnio.setEditable(false);
		rdbtnMusica.setEnabled(false);
		rdbtnPelicula.setEnabled(false);
		rdbtnLibro.setEnabled(false);
		
		JLabel label = new JLabel("Fecha Alquiler");
		label.setBounds(207, 193, 102, 14);
		contentPanel.add(label);
		
		textFieldFechaAlquiler = new JTextField();
		textFieldFechaAlquiler.setEditable(false);
		textFieldFechaAlquiler.setColumns(10);
		textFieldFechaAlquiler.setBounds(327, 193, 86, 20);
		contentPanel.add(textFieldFechaAlquiler);
		
		textFieldFechaDevolucion = new JTextField();
		textFieldFechaDevolucion.setEditable(false);
		textFieldFechaDevolucion.setColumns(10);
		textFieldFechaDevolucion.setBounds(327, 221, 86, 20);
		contentPanel.add(textFieldFechaDevolucion);
		
		JLabel label_1 = new JLabel("Fecha Devoluci\u00F3n");
		label_1.setBounds(207, 222, 102, 14);
		contentPanel.add(label_1);
				
		lblDescripcion.setVisible(false);
		textFieldDescripcion.setVisible(false);
		
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);	
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Producto producto;
				Alquiler alquilar;
				try{
					producto = GestionAlquileres.getTiendaDeAlquiler().get(textFieldIdentificador.getText());
					alquilar = new Alquiler (producto);
					mostrarProducto(producto);
					isDisponible();
					if (producto.isDisponible()){
						JOptionPane.showMessageDialog(contentPanel,
								"El producto ya está disponible.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					textFieldFechaAlquiler.setText(producto.getFechaAlquiler());
					textFieldFechaDevolucion.setText(producto.getFechaDevolucion());
					int i = JOptionPane.showOptionDialog(null,
							"¿Está seguro de que desea devolverlo?",
							"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (i){
						case JOptionPane.YES_OPTION:
							try{
								alquilar.devolver();
								isDisponible();
								GestionAlquileres.setModificado(true);
								clear();
							}catch (ProductoDisponibleException e){
								JOptionPane.showMessageDialog(contentPanel,
										e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
						case JOptionPane.NO_OPTION:
							return;
						case JOptionPane.CANCEL_OPTION:
							return;					
					}

				}catch (ProductoNoExisteException e){
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Borra el contenido del diálogo.
	 */
	private void clear(){
		textFieldIdentificador.setText("");
		textFieldTitulo.setText("");
		textFieldAutorInterpreteDirector.setText("");
		textFieldAnio.setText("");
		textFieldDescripcion.setText("");
		textFieldDuracion.setText("");
		buttonGroup.clearSelection();
		comboBoxGeneroCinematografico.setSelectedItem(null);
		comboBoxGeneroMusical.setSelectedItem(null);
		comboBoxGeneroEditorial.setSelectedItem(null);
		comboBoxEditorial.setSelectedItem(null);	
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
