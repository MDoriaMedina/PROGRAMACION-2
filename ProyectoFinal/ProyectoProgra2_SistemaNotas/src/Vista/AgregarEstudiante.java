package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class AgregarEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AgregarEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarEstudiante = new JLabel("AGREGAR ESTUDIANTE");
		lblAgregarEstudiante.setBounds(154, 10, 115, 13);
		contentPane.add(lblAgregarEstudiante);
		
		JButton btnVolverUno = new JButton("VOLVER");
		btnVolverUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPrincipal ventanaAdminPrincipal = new AdminPrincipal();
				ventanaAdminPrincipal.setVisible(true);
				ventanaAdminPrincipal.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVolverUno.setBounds(10, 203, 85, 21);
		contentPane.add(btnVolverUno);
		
		JRadioButton rdbtnAgregarEstudianteNacional = new JRadioButton("Estudiante Nacional");
		rdbtnAgregarEstudianteNacional.setSelected(true);
		rdbtnAgregarEstudianteNacional.setBounds(43, 55, 135, 21);
		contentPane.add(rdbtnAgregarEstudianteNacional);
		
		JRadioButton rdbtnAgregarEstudianteExtranjero = new JRadioButton("Estudiante Extranjero");
		rdbtnAgregarEstudianteExtranjero.setBounds(43, 96, 123, 21);
		contentPane.add(rdbtnAgregarEstudianteExtranjero);
		
		ButtonGroup grupoAgregarEstudiante = new ButtonGroup();
		grupoAgregarEstudiante.add(rdbtnAgregarEstudianteNacional);
		grupoAgregarEstudiante.add(rdbtnAgregarEstudianteExtranjero);
		
		JButton btnAgregarEstudiante = new JButton("AGREGAR");
		btnAgregarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAgregarEstudianteNacional.isSelected()) {
					AgregarEstudianteNacional ventanaAgregarEstudianteNacional = new AgregarEstudianteNacional();
					ventanaAgregarEstudianteNacional.setVisible(true);
					ventanaAgregarEstudianteNacional.setLocationRelativeTo(null);
					dispose();
				} 
				
				/*else {
					if (rdbtnAgregarEstudianteExtranjero.isSelected()) {
						AgregarEstudianteExtranjero ventanaAgregarEstudianteExtranjero = new AgregarEstudianteExtranjero();
						ventanaAgregarEstudianteExtranjero.setVisible(true);
						ventanaAgregarEstudianteExtranjero.setLocationRelativeTo(null);
						dispose();
					}
				}*/
			}
		});
		btnAgregarEstudiante.setBounds(280, 79, 85, 21);
		contentPane.add(btnAgregarEstudiante);
	}
}
