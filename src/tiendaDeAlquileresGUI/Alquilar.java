package tiendaDeAlquileresGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tiendaDeAlquileres.*;
import javax.swing.JLabel;
import javax.swing.JButton;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Alquilar extends VentanaPadre {

	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Alquiler> listaDeAlquileres = new ArrayList<Alquiler>();
	private Date fechaDevolucion;
	
	private JTextField textFieldFechaAlquiler;
	private JTextField textFieldFechaDevolucion;
	private JButton btnFactura;
	
	public Alquilar() {
		textFieldDescripcion.setEditable(false);
		rdbtnNormal.setLocation(17, 16);
		rdbtnNovedad.setLocation(114, 16);
		panel_1.setSize(206, 53);
		panel_1.setLocation(207, 256);
		
		rdbtnNormal.setSelected(true);
		
		btnFactura = new JButton("Factura");
		btnFactura.setBounds(121, 376, 89, 23);
		contentPanel.add(btnFactura,0);

		comboBoxEditorial.setEnabled(false);
		comboBoxGeneroCinematografico.setEnabled(false);
		comboBoxGeneroMusical.setEnabled(false);
		comboBoxGeneroEditorial.setEnabled(false);
		textFieldTitulo.setEditable(false);
		textFieldAutorInterpreteDirector.setEditable(false);
		textFieldDuracion.setEditable(false);
		textFieldAnio.setEditable(false);
		rdbtnMusica.setEnabled(false);
		rdbtnPelicula.setEnabled(false);
		rdbtnLibro.setEnabled(false);
		btnFactura.setVisible(false);
		btnDisponible.setVisible(false);
		
		setTitle("Alquilar producto");
		
		btnEnviar.setText("Alquilar");

		JLabel lblFechaAlquiler = new JLabel("Fecha Alquiler");
		lblFechaAlquiler.setBounds(207, 190, 102, 14);
		contentPanel.add(lblFechaAlquiler);
		
		JLabel labelFechaDevolucion = new JLabel("Fecha Devoluci\u00F3n");
		labelFechaDevolucion.setBounds(207, 219, 102, 14);
		contentPanel.add(labelFechaDevolucion);
		
		textFieldFechaAlquiler = new JTextField();
		textFieldFechaAlquiler.setEditable(false);
		textFieldFechaAlquiler.setColumns(10);
		textFieldFechaAlquiler.setBounds(327, 190, 86, 20);
		contentPanel.add(textFieldFechaAlquiler);
		
		textFieldFechaDevolucion = new JTextField();
		textFieldFechaDevolucion.setColumns(10);
		textFieldFechaDevolucion.setBounds(327, 218, 86, 20);
		contentPanel.add(textFieldFechaDevolucion);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFactura.setVisible(false);
				textFieldIdentificador.setText("");
				textFieldTitulo.setText("");
				textFieldAutorInterpreteDirector.setText("");
				textFieldAnio.setText("");
				textFieldDescripcion.setText("");
				textFieldDuracion.setText("");
				textFieldFechaAlquiler.setText("");
				textFieldFechaDevolucion.setText("");
				buttonGroup.clearSelection();
				comboBoxGeneroCinematografico.setSelectedItem(null);
				comboBoxGeneroEditorial.setSelectedItem(null);
				comboBoxGeneroMusical.setSelectedItem(null);
				comboBoxEditorial.setSelectedItem(null);	
				
				
			}
		});
		btnLimpiar.setBounds(239, 376, 89, 23);
		contentPanel.add(btnLimpiar);
		
		
				
		lblDescripcion.setVisible(false);
		textFieldDescripcion.setVisible(false);
		
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFactura.setVisible(true);
				Producto producto;
				Alquiler alquilar;
				if (textFieldFechaDevolucion.getText() == "" || !esValidaFecha(textFieldFechaDevolucion.getText())){
					JOptionPane.showMessageDialog(contentPanel,
							"La fecha no es válida.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
					
				}if(fechaDevolucion.before(new Date())){
					JOptionPane.showMessageDialog(contentPanel,
							"La fecha ha de ser posterior a la actual.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;	
				}
				try{
					producto = GestionAlquileres.getTiendaDeAlquiler().get(textFieldIdentificador.getText());
					alquilar = new Alquiler(producto);
					producto.setFechaAlquiler(new Date());
					producto.setFechaDevolucion(fechaDevolucion);
					mostrarProducto(producto);
					isDisponible();
					alquilar.setFechaDevolucion(fechaDevolucion);
					textFieldFechaAlquiler.setText(alquilar.getFechaAlquiler());
					if(!producto.isDisponible()){
						JOptionPane.showMessageDialog(contentPanel,
								"El producto no está disponible.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					int i =  JOptionPane.showOptionDialog(null,
							"¿Está seguro de que desea alquilarlo?",
							"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (i){
						case JOptionPane.YES_OPTION:
							try{
								alquilar.alquilar();
								listaDeAlquileres.add(alquilar);
								isDisponible();
								GestionAlquileres.setModificado(true);
								
								break;
								
							}catch (ProductoNoDisponibleException e){
								JOptionPane.showMessageDialog(contentPanel,
									e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

							}
						case JOptionPane.NO_OPTION:
							return;
						case JOptionPane.CANCEL_OPTION:
							return;	
					}
					
				}catch (ProductoNoExisteException  e){
					JOptionPane.showMessageDialog(contentPanel, e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		
		
		
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listaDeAlquileres.isEmpty()){
					JOptionPane.showMessageDialog(contentPanel,
							"No se ha podido crear la factura.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int dias = Integer.parseInt(textFieldFechaDevolucion.getText().substring(0, 2))
						- Integer.parseInt(textFieldFechaAlquiler.getText().substring(0, 2));
				Factura factura = new Factura (Alquiler.crearFactura(listaDeAlquileres, dias, getPrecio()));
				factura.setVisible(true);
			}
		});
		
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDeAlquileres.clear();	
			}
		});	
		
	}
		
	
		/**
		 * Comprueba si la fecha introducida es válida o no
		 * 
		 * @param fecha
		 *            Representa la fecha a validar
		 * @return true si la fecha es válida, false si la fecha no es válida
		 */
		private boolean esValidaFecha(String fecha) {
			try {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				formato.setLenient(false);
				fechaDevolucion = formato.parse(fecha);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		
		/**
		 * Devuelve el precio del tipo de alquiler seleccionado.
		 * 
		 * @return	Precio del tipo de alquiler
		 */
		private TipoAlquiler getPrecio(){
			if (rdbtnNormal.isSelected())
				return TipoAlquiler.NORMAL;
			else if (rdbtnNovedad.isSelected())
				return TipoAlquiler.NOVEDAD;
			else
				return null;
	
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
