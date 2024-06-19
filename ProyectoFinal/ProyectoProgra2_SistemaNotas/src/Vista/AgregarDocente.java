package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AgregarDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarDocente = new JLabel("AGREGAR DOCENTE");
		lblAgregarDocente.setBounds(169, 10, 100, 13);
		contentPane.add(lblAgregarDocente);
		
		JButton btnAgregarDocenteNacional = new JButton("AGREGAR DOCENTE NACIONAL");
		btnAgregarDocenteNacional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarDocenteNacional ventanaAgregarDocenteNacional = new AgregarDocenteNacional();
				ventanaAgregarDocenteNacional.setVisible(true);
				ventanaAgregarDocenteNacional.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAgregarDocenteNacional.setBounds(126, 50, 175, 21);
		contentPane.add(btnAgregarDocenteNacional);
		
		JButton btnAgregarDocenteExtranjero = new JButton("AGREGAR DOCENTE EXTRANJERO");
		btnAgregarDocenteExtranjero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*AgregarDocenteExtranjero ventanaAgregarDocenteExtranjero = new AgregarDocenteExtranjero();
				ventanaAgregarDocenteExtranjero.setVisible(true);
				ventanaAgregarDocenteExtranjero.setLocationRelativeTo(null);
				dispose();*/
			}
		});
		btnAgregarDocenteExtranjero.setBounds(125, 102, 187, 21);
		contentPane.add(btnAgregarDocenteExtranjero);
		
		JButton btnVolverDos = new JButton("VOLVER");
		btnVolverDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPrincipal ventanaAdminPrincipal = new AdminPrincipal();
				ventanaAdminPrincipal.setVisible(true);
				ventanaAdminPrincipal.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVolverDos.setBounds(10, 232, 85, 21);
		contentPane.add(btnVolverDos);
	}

}
