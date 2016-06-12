package tiendaDeAlquileresGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
/**
 * 
 * @author Coral Almansa Domínguez
 * @version 1.0
 *
 */
public class Factura extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private String mensaje;
	
	/**
	 * Create the dialog.
	 */
	public Factura(String mensaje) {
		setResizable(false);
		setModal(true);
		setTitle("Factura de alquiler");
		setBounds(100, 100, 290, 300);
		
		this.mensaje = mensaje;
		
		JTextPane textPanel = new JTextPane();
		textPanel.setBackground(new Color(220, 220, 220));
		textPanel.setBounds(10, 11, 424, 179);
		textPanel.setEditable(false);
		textPanel.setText(mensaje);
		
		JScrollPane scrollPane = new JScrollPane(textPanel);
		scrollPane.setBounds(10, 11, 264, 213);
		
		contentPanel.setLayout(null);
		contentPanel.add(scrollPane);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton guardar = new JButton("Guardar");
				guardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							guardar();
							guardar.setEnabled(false);
							JOptionPane.showMessageDialog(contentPanel, "Factura guardada con éxito.");
						} catch (IOException e) {
							JOptionPane.showMessageDialog(contentPanel,
									"El sistema no puede guardar el fichero.",
									"Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				guardar.setActionCommand("Guardar");
				buttonPane.add(guardar);
				getRootPane().setDefaultButton(guardar);
			}
			{
				JButton salir = new JButton("Salir");
				salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				salir.setActionCommand("Salir");
				buttonPane.add(salir);
			}
		}
	}
	
	/**
	 * Método para guardar una factura
	 * 
	 * @throws IOException
	 */
	private void guardar() throws IOException {
		try (PrintWriter print = new PrintWriter(new FileWriter("factura.txt", true))) {
			print.println(mensaje);
		}
	}
	
}