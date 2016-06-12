package tiendaDeAlquileresGUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.KeyStroke;

import tiendaDeAlquileres.*;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo ;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmAbrir ;
	private JMenuItem mntmGuardar ;
	private JMenuItem mntmGuardarComo;
	private JMenuItem mntmSalir;
	private JMenu mnProductos;
	private JMenuItem mntmAnadir;
	private JMenuItem mntmEliminar ;
	private JMenuItem mntmMostrarTienda;
	private JMenu mnBuscar;
	private JMenuItem mntmPorTitulo;
	private JMenu mnAlquiler;
	private JMenuItem mntmRegistraralquilar;
	private JMenuItem mntmDevolverAlquiler;
	private JMenu mnAyuda;
	private Ayuda ayuda;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAcercaDe;
	private Mostrar mostrar;
	private Baja baja;
	private MostrarPorTitulo mostrarPorTitulo;
	private MostrarPorIdentificador mostrarPorIdentificador;
	private Alquilar alquilar;
	private Devolver devolver;
	
	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
	private JMenuItem mntmPorIdentificador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal(){
		setTitle("Sin t\u00EDtulo");
		setResizable(false);
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		
		frame = new JFrame();
		frame.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		fileChooser.setFileFilter(filtro);

		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0) {
				if (GestionAlquileres.isModificado()) {
					int n = JOptionPane.showOptionDialog(frame.getContentPane(),
									"La tienda ha sido modificada. ¿Desea guardar los cambios?",
									"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (n) {
					case JOptionPane.YES_OPTION:
						guardar();
						System.exit(0);
					case JOptionPane.NO_OPTION:
						System.exit(0);
					case JOptionPane.CANCEL_OPTION:
						return;
					}
				} else {
					System.exit(0);
				}
			}
		});
	
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.setMnemonic('N');
		mnArchivo.add(mntmNuevo);
		
		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrir.setMnemonic('A');
		mnArchivo.add(mntmAbrir);
		
		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);
		
		mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardar.setMnemonic('G');
		mnArchivo.add(mntmGuardar);
		
		mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mntmGuardarComo.setMnemonic('c');
		mnArchivo.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestionAlquileres.isModificado()) {
					int n = JOptionPane.showOptionDialog(frame.getContentPane(),
									"La tienda ha sido modificada. ¿Desea guardar los cambios?",
									"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (n) {
					case JOptionPane.YES_OPTION:
						guardar();
						System.exit(0);
					case JOptionPane.NO_OPTION:
						System.exit(0);
					case JOptionPane.CANCEL_OPTION:
						return;
					}
				} else{
					System.exit(0);
				}
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSalir.setMnemonic('S');
		mnArchivo.add(mntmSalir);
		
		mnProductos = new JMenu("Productos");
		mnProductos.setMnemonic('P');
		menuBar.add(mnProductos);
		
		mntmAnadir = new JMenuItem("A\u00F1adir");
		mntmAnadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.CTRL_MASK));
		mntmAnadir.setMnemonic('A');
		mntmAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Alta alta = new Alta();
				alta.setVisible(true);
			}
		});
		mnProductos.add(mntmAnadir);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, InputEvent.CTRL_MASK));
		mntmEliminar.setMnemonic('E');
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();	
			}		
		});
		mnProductos.add(mntmEliminar);
		
		mntmMostrarTienda = new JMenuItem("Mostrar Tienda");
		mntmMostrarTienda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmMostrarTienda.setMnemonic('M');
		mntmMostrarTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar();
				
			}
		});
		mnProductos.add(mntmMostrarTienda);
	
		mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('B');
		menuBar.add(mnBuscar);
		
		mntmPorTitulo = new JMenuItem("Por t\u00EDtulo");
		mntmPorTitulo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mntmPorTitulo.setMnemonic('t');
		mntmPorTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorTitulo();
			}
		});
		
		mntmPorIdentificador = new JMenuItem("Por identificador");
		mntmPorIdentificador.setMnemonic('i');
		mntmPorIdentificador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				mostrarPoridentificador();		
			}	
		});
		mntmPorIdentificador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mnBuscar.add(mntmPorIdentificador);
		mnBuscar.add(mntmPorTitulo);
		
		
		mnAlquiler = new JMenu("Alquiler");
		mnAlquiler.setMnemonic('l');
		menuBar.add(mnAlquiler);
		
		mntmRegistraralquilar = new JMenuItem("Registrar Alquiler");
		mntmRegistraralquilar.setMnemonic('R');
		mntmRegistraralquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alquilar();
				
			}	
		});
		mnAlquiler.add(mntmRegistraralquilar);
		
		mntmDevolverAlquiler = new JMenuItem("Devolver Alquiler");
		mntmDevolverAlquiler.setMnemonic('D');
		mntmDevolverAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				devolver();	
			}
		});
		mnAlquiler.add(mntmDevolverAlquiler);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		menuBar.add(mnAyuda);
		
		mntmAyuda = new JMenuItem("Ver ayuda");
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmAyuda.setMnemonic('V');
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda = Ayuda.getInstance();
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmAcercaDe.setMnemonic('A');
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

	/**
	 * Crea una nueva tienda, en caso de que la tienda se haya modificado
	 * se pregunta al usuario si desea guardarlo
	 */
	private void nuevo() {
		if (GestionAlquileres.isModificado()) {
			int n = JOptionPane.showOptionDialog(frame.getContentPane(),
							"La tienda ha sido modificada. ¿Desea guardar los cambios?",
							"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (n) {
			case JOptionPane.YES_OPTION:
				guardar();
				break;
			case JOptionPane.NO_OPTION:
				break;
			case JOptionPane.CANCEL_OPTION:
				return;
			}
		}
		GestionAlquileres.setTiendaDeAlquiler(new TiendaDeAlquiler());
		GestionAlquileres.setFile(new File("Sin título"));
		GestionAlquileres.setModificado(false);
		setTitle(GestionAlquileres.getFile().getName());
	}
	
	/**
	 * Recupera el contenido de un fichero, en caso de que la tienda se haya
	 * modificado se pregunta al usuario si desea guardarlo
	 */
	private void abrir() {
		if (GestionAlquileres.isModificado()) {
			int n = JOptionPane.showOptionDialog(frame.getContentPane(),
							"La tienda ha sido modificada. ¿Desea guardar los cambios?",
							"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (n) {
			case JOptionPane.YES_OPTION:
				guardar();
				break;
			case JOptionPane.NO_OPTION:
				break;
			case JOptionPane.CANCEL_OPTION:
				return;
			}
		}
		int seleccion = fileChooser.showOpenDialog(frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				GestionAlquileres.setTiendaDeAlquiler(Fichero.abrir(file));
				GestionAlquileres.setFile(file);
				setTitle(GestionAlquileres.getFile().getName());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"Fichero con información distinta a la esperada.",
						"Warning", JOptionPane.WARNING_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"El sistema no puede abrir el fichero.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	
	/**
	 * Guarda el contenido en un fichero, si no hay un fichero previo se
	 * solicita el nombre del mismo
	 */
	private void guardar() {
		if (GestionAlquileres.getFile() == null || GestionAlquileres.getFile().getName().equals("Sin título"))
			guardarComo();
		else {
			try {
				File file = fileChooser.getSelectedFile();
				Fichero.guardar(file, GestionAlquileres.getTiendaDeAlquiler());
				GestionAlquileres.setModificado(false);
				GestionAlquileres.setFile(file);
				setTitle(GestionAlquileres.getFile().getName());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"El sistema no puede guardar el fichero.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	/**
	 * Guarda el contenido en un fichero solicitando el nombre del mismo, en
	 * caso de existir el fichero se pregunta al usuario si desea
	 * sobreescribirlo
	 */
	private void guardarComo() {
		int seleccion = fileChooser.showSaveDialog(frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				if (Fichero.isExists(file)) {
					int n = JOptionPane.showOptionDialog(frame.getContentPane(),
							"El fichero ya existe. ¿Desea sobreescribirlo?",
							"Confirmar", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					switch (n) {
					case JOptionPane.NO_OPTION:
						return;
					}
				}
				Fichero.guardar(file, GestionAlquileres.getTiendaDeAlquiler());
				GestionAlquileres.setModificado(false);
				GestionAlquileres.setFile(file);
				setTitle(GestionAlquileres.getFile().getName());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"El sistema no puede guardar el fichero.",
						"Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void baja() {
		if (GestionAlquileres.getTiendaDeAlquiler().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay productos en la tienda.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		baja = new Baja();
		baja.setVisible(true);
	}
	
	/**
	 * Muestra los productos de la tienda
	 */
	private void mostrar() {
		if (GestionAlquileres.getTiendaDeAlquiler().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay productos en la tienda.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrar = new Mostrar();
		mostrar.setVisible(true);
	}
	
	/**
	 * Muestra por título los productos de la tienda
	 */
	private void mostrarPorTitulo() {
		if (GestionAlquileres.getTiendaDeAlquiler().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay productos en la tienda.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrarPorTitulo = new MostrarPorTitulo();
		mostrarPorTitulo.setVisible(true);	
	}
	
	/**
	 * Muestra por identificador los productos de la tienda
	 */
	private void mostrarPoridentificador() {
		
		if (GestionAlquileres.getTiendaDeAlquiler().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay productos en la tienda.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		
		}
	mostrarPorIdentificador = new MostrarPorIdentificador();
	mostrarPorIdentificador.setVisible(true);
	}
	
	
	private void alquilar() {
		if (GestionAlquileres.getTiendaDeAlquiler().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay productos en la tienda.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		alquilar = new Alquilar();
		alquilar.setVisible(true);		
	}
	

	private void devolver() {
		if (GestionAlquileres.getTiendaDeAlquiler().size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay productos en la tienda.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		devolver = new Devolver();
		devolver.setVisible(true);
	}	
}
