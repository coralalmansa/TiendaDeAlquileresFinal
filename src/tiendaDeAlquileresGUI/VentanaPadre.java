package tiendaDeAlquileresGUI;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import tiendaDeAlquileres.Editorial;
import tiendaDeAlquileres.GeneroCinematografico;
import tiendaDeAlquileres.GeneroEditorial;
import tiendaDeAlquileres.GeneroMusical;
import tiendaDeAlquileres.GestionAlquileres;
import tiendaDeAlquileres.ProductoNoExisteException;

import java.awt.Color;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class VentanaPadre extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textFieldTitulo;
	protected JTextField textFieldAutorInterpreteDirector;
	protected JTextField textFieldDuracion;
	protected JTextField textFieldIdentificador;
	protected JTextField textFieldAnio;
	protected JTextField textFieldDescripcion;
	protected JPanel panel;
	
	protected JLabel lblTitulo;
	protected JLabel lblAutor;
	protected JLabel lblEditorial;
	protected JLabel lblNumeroPaginas;
	protected JLabel lblGenero;
	protected JLabel lblIdentificador;
	protected JLabel lblDescripcion;
	protected JLabel lblAnio;
	
	protected JButton btnSalir;
	protected JButton btnSiguiente;
	protected JButton btnAnterior;
	
	protected JButton btnEnviar;
	protected JButton btnDisponible;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JRadioButton rdbtnLibro;
	protected JRadioButton rdbtnPelicula;
	protected JRadioButton rdbtnMusica;

	protected JComboBox<Editorial> comboBoxEditorial;
	protected JComboBox<GeneroCinematografico> comboBoxGeneroCinematografico;
	protected JComboBox<GeneroEditorial> comboBoxGeneroEditorial;
	protected JComboBox<GeneroMusical> comboBoxGeneroMusical;
	
	protected JRadioButton rdbtnNormal;
	protected JRadioButton rdbtnNovedad;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	protected JPanel panel_1;
	

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setResizable(false);
		setBounds(100, 100, 433, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setBounds(121, 54, 86, 14);
		contentPanel.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(226, 51, 187, 20);
		contentPanel.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(121, 89, 86, 14);
		contentPanel.add(lblAutor);
		
		textFieldAutorInterpreteDirector = new JTextField();
		textFieldAutorInterpreteDirector.setBounds(226, 86, 187, 20);
		contentPanel.add(textFieldAutorInterpreteDirector);
		textFieldAutorInterpreteDirector.setColumns(10);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(41, 210, 46, 14);
		contentPanel.add(lblEditorial);
		
		lblNumeroPaginas = new JLabel("N\u00BA de p\u00E1ginas");
		lblNumeroPaginas.setBounds(121, 123, 95, 14);
		contentPanel.add(lblNumeroPaginas);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(226, 117, 86, 20);
		contentPanel.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setBounds(121, 154, 46, 14);
		contentPanel.add(lblGenero);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnSalir.setBounds(338, 376, 75, 23);
		contentPanel.add(btnSalir);
		
		btnSiguiente = new JButton(">>");
		btnSiguiente.setBounds(253, 376, 58, 23);
		contentPanel.add(btnSiguiente);
		
		btnAnterior = new JButton("<<");
		btnAnterior.setBounds(193, 376, 58, 23);
		contentPanel.add(btnAnterior);
		
		lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(121, 17, 95, 14);
		contentPanel.add(lblIdentificador);
		
		textFieldIdentificador = new JTextField();
		textFieldIdentificador.setBounds(207, 11, 86, 20);
		contentPanel.add(textFieldIdentificador);
		textFieldIdentificador.setColumns(10);
		
		comboBoxGeneroEditorial = new JComboBox<GeneroEditorial>();
		comboBoxGeneroEditorial.setBounds(226, 148, 187, 20);
		contentPanel.add(comboBoxGeneroEditorial);
		comboBoxGeneroEditorial.setModel(new DefaultComboBoxModel<GeneroEditorial>(GeneroEditorial.values()));
		
		comboBoxGeneroCinematografico = new JComboBox<GeneroCinematografico>();
		comboBoxGeneroCinematografico.setBounds(226, 148, 187, 20);
		contentPanel.add(comboBoxGeneroCinematografico);
		comboBoxGeneroCinematografico.setModel(new DefaultComboBoxModel<GeneroCinematografico>(GeneroCinematografico.values()));

		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 14, 95, 104);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnLibro = new JRadioButton("Libro");
		rdbtnLibro.setSelected(true);
		rdbtnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblAutor.setText("Autor");
				lblNumeroPaginas.setText("Nº de páginas");
				
				lblAutor.setVisible(true);
				lblNumeroPaginas.setVisible(true);
				lblEditorial.setVisible(true);
				comboBoxEditorial.setVisible(true);
				comboBoxGeneroCinematografico.setVisible(false);
				comboBoxGeneroMusical.setVisible(false);
				comboBoxGeneroEditorial.setVisible(true);
			}
		});
		rdbtnLibro.setBounds(6, 16, 83, 23);
		panel.add(rdbtnLibro);
		buttonGroup.add(rdbtnLibro);
		
		rdbtnPelicula = new JRadioButton("Pel\u00EDcula");
		rdbtnPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblAutor.setText("Director");
				lblNumeroPaginas.setText("Duración");
				
				lblAutor.setVisible(true);
				lblNumeroPaginas.setVisible(true);
				lblEditorial.setVisible(false);
				comboBoxEditorial.setVisible(false);
				comboBoxGeneroEditorial.setVisible(false);
				comboBoxGeneroMusical.setVisible(false);	
				comboBoxGeneroCinematografico.setVisible(true);
				
				
			}
		});
		rdbtnPelicula.setBounds(6, 42, 83, 23);
		panel.add(rdbtnPelicula);
		buttonGroup.add(rdbtnPelicula);
		
		rdbtnMusica = new JRadioButton("M\u00FAsica");
		rdbtnMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAutor.setText("Intérprete");
				lblNumeroPaginas.setText("Nº de canciones");
				
				lblAutor.setVisible(true);
				lblNumeroPaginas.setVisible(true);
				lblEditorial.setVisible(false);
				comboBoxEditorial.setVisible(false);
				comboBoxGeneroCinematografico.setVisible(false);
				comboBoxGeneroEditorial.setVisible(false);
				comboBoxGeneroMusical.setVisible(true);
				
				
			}
		});
		rdbtnMusica.setBounds(6, 68, 83, 23);
		panel.add(rdbtnMusica);
		buttonGroup.add(rdbtnMusica);
		
		lblAnio = new JLabel("A\u00F1o");
		lblAnio.setBounds(41, 145, 46, 14);
		contentPanel.add(lblAnio);
		
		textFieldAnio = new JTextField();
		textFieldAnio.setBounds(10, 164, 86, 20);
		contentPanel.add(textFieldAnio);
		textFieldAnio.setColumns(10);
		
		comboBoxEditorial = new JComboBox<Editorial>();
		comboBoxEditorial.setBounds(10, 235, 113, 20);
		contentPanel.add(comboBoxEditorial);
		comboBoxEditorial.setModel(new DefaultComboBoxModel<Editorial>(Editorial.values()));
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(10, 302, 403, 63);
		contentPanel.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(26, 277, 79, 14);
		contentPanel.add(lblDescripcion);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(16, 376, 89, 23);
		contentPanel.add(btnEnviar);
		getRootPane().setDefaultButton(btnEnviar);
		
		btnDisponible = new JButton("Disponible");
		btnDisponible.setBounds(303, 10, 110, 23);
		contentPanel.add(btnDisponible);
		
		comboBoxGeneroMusical = new JComboBox<GeneroMusical>();
		comboBoxGeneroMusical.setBounds(226, 148, 187, 20);
		contentPanel.add(comboBoxGeneroMusical);
		comboBoxGeneroMusical.setModel(new DefaultComboBoxModel<GeneroMusical>(GeneroMusical.values()));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de alquiler", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(211, 218, 184, 46);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(6, 16, 86, 23);
		panel_1.add(rdbtnNormal);
		buttonGroup_1.add(rdbtnNormal);
		
		rdbtnNovedad = new JRadioButton("Novedad");
		rdbtnNovedad.setBounds(92, 16, 86, 23);
		panel_1.add(rdbtnNovedad);
		buttonGroup_1.add(rdbtnNovedad);

	}
	
	/**
	 * Comprueba si un producto está o no disponible.
	 */
	protected void isDisponible(){
		try{
			if(!GestionAlquileres.getTiendaDeAlquiler().get(textFieldIdentificador.getText()).isDisponible())
				btnDisponible.setEnabled(false);
			else
				btnDisponible.setEnabled(true);
		}catch(ProductoNoExisteException e){
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
