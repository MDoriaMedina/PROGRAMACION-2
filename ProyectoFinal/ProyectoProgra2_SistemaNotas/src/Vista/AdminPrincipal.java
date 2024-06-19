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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JButton btnAgregarEstudiante = new JButton("AGREGAR ESTUDIANTE");
		btnAgregarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*AgregarEstudiante ventanaAgregarEstudiante = new AgregarEstudiante();
				ventanaAgregarEstudiante.setVisible(true);
				ventanaAgregarEstudiante.setLocationRelativeTo(null);
				dispose();*/
			}
		});
		btnAgregarEstudiante.setBounds(91, 54, 212, 21);
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
		btnAgregarDocente.setBounds(91, 92, 212, 21);
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
		btnModificarEstudiante.setBounds(91, 131, 212, 21);
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
		btnModificarDocente.setBounds(91, 169, 212, 21);
		contentPane.add(btnModificarDocente);
	}
}
