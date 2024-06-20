package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public AdminPrincipal() {
		setTitle("Admin Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregarEstudiante = new JButton("AGREGAR ESTUDIANTE");
		btnAgregarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEstudiante ventanaAgregarEstudiante = new AgregarEstudiante();
				ventanaAgregarEstudiante.setVisible(true);
				ventanaAgregarEstudiante.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAgregarEstudiante.setBounds(91, 33, 212, 21);
		contentPane.add(btnAgregarEstudiante);
		
		JButton btnAgregarDocente = new JButton("AGREGAR DOCENTE");
		btnAgregarDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane para seleccionar tipo_docente
				
				
				AgregarDocente ventanaAgregarDocente = new AgregarDocente();
				ventanaAgregarDocente.setVisible(true);
				ventanaAgregarDocente.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAgregarDocente.setBounds(91, 70, 212, 21);
		contentPane.add(btnAgregarDocente);
		
		JButton btnModificarEstudiante = new JButton("MODIFICAR ESTUDIANTE");
		btnModificarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ModificarEstudiante ventanaModificarEstudiante = new ModificarEstudiante();
				ventanaModificarEstudiante.setVisible(true);
				ventanaModificarEstudiante.setLocationRelativeTo(null);
				dispose();*/
			}
		});
		btnModificarEstudiante.setBounds(91, 101, 212, 21);
		contentPane.add(btnModificarEstudiante);
		
		JButton btnModificarDocente = new JButton("MODIFICAR DOCENTE");
		btnModificarDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ModificarDocente ventanaModificarDocente = new ModificarDocente();
				ventanaModificarDocente.setVisible(true);
				ventanaModificarDocente.setLocationRelativeTo(null);
				dispose();*/
			}
		});
		btnModificarDocente.setBounds(91, 132, 212, 21);
		contentPane.add(btnModificarDocente);
		
		JButton btnAsignarMaterias = new JButton("ASIGNAR MATERIAS");
		btnAsignarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignarMateria asignar = new AsignarMateria();
				asignar.setVisible(true);
				asignar.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAsignarMaterias.setBounds(91, 163, 212, 21);
		contentPane.add(btnAsignarMaterias);
	}
}
