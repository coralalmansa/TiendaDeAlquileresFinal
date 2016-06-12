package tiendaDeAlquileresGUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class AcercaDe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setResizable(false);
		setModal(true);
		setTitle("Acerca de");
		setBounds(100, 100, 324, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRealizadoPorCoral = new JLabel("Realizado por: Coral Almansa Dom\u00EDnguez");
			lblRealizadoPorCoral.setBounds(25, 73, 283, 14);
			contentPanel.add(lblRealizadoPorCoral);
		}
		{
			JLabel lblVersion = new JLabel("version 1.0");
			lblVersion.setBounds(35, 98, 97, 14);
			contentPanel.add(lblVersion);
		}
		{
			JButton btnAceotar = new JButton("Aceptar");
			btnAceotar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();

				}
			});
			btnAceotar.setBounds(209, 158, 89, 23);
			contentPanel.add(btnAceotar);
		}
	}

}
