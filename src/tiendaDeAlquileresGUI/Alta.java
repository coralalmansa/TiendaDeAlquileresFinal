package tiendaDeAlquileresGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;







import tiendaDeAlquileres.*;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;

/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Alta extends VentanaPadre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Alta() {
		textFieldIdentificador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				comprobarIdentificador(textFieldIdentificador.getText());
			}

			/**
			 * Método que comprueba que el identificador sea válido, si no lo es, 
			 * al perder el foco, el texto se pone en rojo.
			 * 
			 * @param text
			 */
			private void comprobarIdentificador(String text) {
				if(!Producto.esValidoId(text)){
					textFieldIdentificador.setForeground(Color.RED);
				}	
			}
			
			/**
			 * Método que hace que al ganar el foco, el texto se ponga en negro.
			 */
			@Override
			public void focusGained(FocusEvent e) {
				textFieldIdentificador.setForeground(Color.BLACK);
			}
		});
	
		textFieldIdentificador.setLocation(225, 14);
		textFieldTitulo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				comprobarTitulo(textFieldTitulo.getText());
			}
			
			/**
			 * Método que comprueba que el título sea válido, si no lo es, 
			 * al perder el foco, el texto se pone en rojo.
			 * 
			 * @param text
			 */
			private void comprobarTitulo(String text) {			
				if (!Producto.esValidoTitulo(text)){
					textFieldTitulo.setForeground(Color.RED);
				}	
			}
			
			/**
			 * Método que hace que al ganar el foco, el texto se ponga en negro.
			 */
			@Override
			public void focusGained(FocusEvent arg0) {
				textFieldTitulo.setForeground(Color.BLACK);
			}
		});
		
		textFieldAutorInterpreteDirector.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				comprobarAutorInterpreteDirector(textFieldAutorInterpreteDirector.getText());
			}

			/**
			 * Método que comprueba que el autor, el intérprete o el director sean válidos, si no lo son, 
			 * al perder el foco, el texto se pone en rojo.
			 * 
			 * @param text
			 */
			private void comprobarAutorInterpreteDirector(String text) {
				if(!Libro.esValidoAutor(text) | !Musica.esValidoInterprete(text) | !Pelicula.esValidoDirector(text)){
					textFieldAutorInterpreteDirector.setForeground(Color.RED);
				}	
			}
			
			/**
			 * Método que hace que al ganar el foco, el texto se ponga en negro.
			 */
			@Override
			public void focusGained(FocusEvent e) {
				textFieldAutorInterpreteDirector.setForeground(Color.BLACK);
			}
		});
		
		textFieldDescripcion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				comprobarDescripcion(textFieldDescripcion.getText());
			}

			/**
			 * Método que comprueba que la descripción sea válida, si no lo es, 
			 * al perder el foco, el texto se pone en rojo.
			 * 
			 * @param text
			 */
			private void comprobarDescripcion(String text) {
				if(!Producto.esValidaDescripcion(text)){
					textFieldDescripcion.setForeground(Color.RED);
				}	
			}
			
			/**
			 * Método que hace que al ganar el foco, el texto se ponga en negro.
			 */
			@Override
			public void focusGained(FocusEvent e) {
				textFieldDescripcion.setForeground(Color.BLACK);
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		setModal(true);
		setTitle("Alta");
		
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		btnDisponible.setVisible(false);
		panel_1.setVisible(false);
		btnDisponible.setVisible(false);

		btnEnviar.setText("Alta");
	
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnLimpiar.setBounds(121, 376, 89, 23);
		contentPanel.add(btnLimpiar);
		
		btnEnviar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException{
				try{
					if (getTipo() == TipoProducto.PELICULA){
						GestionAlquileres.getTiendaDeAlquiler().aniadir(textFieldIdentificador.getText().toUpperCase(), 
								textFieldTitulo.getText(), 
								Integer.parseInt(textFieldAnio.getText()), 
								textFieldDescripcion.getText(), 
								textFieldAutorInterpreteDirector.getText(), 
								Integer.parseInt(textFieldDuracion.getText()), 
								(GeneroCinematografico) comboBoxGeneroCinematografico.getSelectedItem());
						GestionAlquileres.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "La película se ha añadido!");
					
					
					}else if(getTipo() == TipoProducto.MUSICA){
						GestionAlquileres.getTiendaDeAlquiler().aniadir(textFieldIdentificador.getText().toUpperCase(), 
								textFieldTitulo.getText(),
								Integer.parseInt(textFieldAnio.getText()), 
								textFieldDescripcion.getText(), 
								textFieldAutorInterpreteDirector.getText(),
								Integer.parseInt(textFieldDuracion.getText()), 
								(GeneroMusical) comboBoxGeneroMusical.getSelectedItem());
						GestionAlquileres.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "La música se ha añadido!");
					}else if (getTipo() == TipoProducto.LIBRO ){
						GestionAlquileres.getTiendaDeAlquiler().aniadir(textFieldIdentificador.getText().toUpperCase(), 
								textFieldTitulo.getText(), 
								Integer.parseInt(textFieldAnio.getText()), 
								textFieldDescripcion.getText(),
								textFieldAutorInterpreteDirector.getText(), 
								Integer.parseInt(textFieldDuracion.getText()), 
								(GeneroEditorial) comboBoxGeneroEditorial.getSelectedItem(), 
								(Editorial) comboBoxEditorial.getSelectedItem());
						GestionAlquileres.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "El libro se ha añadido!");
					}else{
						JOptionPane.showMessageDialog(contentPanel, "Debe seleccionar un producto.", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(ProductoYaExisteException | IdNoValidoException 
						| TituloNoValidoException | AnioNoValidoException
						| AutorNoValidoException |GeneroNoValidoException | NumberFormatException 
						| DuracionPeliculaNoValidaException | DirectorNoValidoException | DescripcionNoValidaException 
						| NumeroPaginasNoValidoException | NumeroCancionesNoValidoException | InterpreteNoValidoException | EditorialNoValidaException e){
					JOptionPane.showMessageDialog(contentPanel,
							e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
				
		}
	
		/**
		 * Devuelve el tipo de producto seleccionado
		 * 
		 * @return Tipo de producto seleccionado
		 */
		private TipoProducto getTipo() {
			if (rdbtnPelicula.isSelected())
				return TipoProducto.PELICULA;
			else if (rdbtnLibro.isSelected())
				return TipoProducto.LIBRO;
			else if (rdbtnMusica.isSelected())
				return TipoProducto.MUSICA;
			else
				return null;
		}
}
