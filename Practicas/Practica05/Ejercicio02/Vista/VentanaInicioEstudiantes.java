package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Estudiante;
import Modelo.EstudianteExtranjero;
import Modelo.EstudianteRegular;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaInicioEstudiantes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param estReg 
	 * @param estranjero 
	 */
	public VentanaInicioEstudiantes(ArrayList<EstudianteRegular> estReg, ArrayList<EstudianteExtranjero> estranjero) {
		
		//ArrayList<EstudianteRegular> estReg = new ArrayList<EstudianteRegular>();
		List<Estudiante> todosLosEstudiantes = new ArrayList<>();
        todosLosEstudiantes.addAll(estReg);
        todosLosEstudiantes.addAll(estranjero);
		
		setTitle("Universidad \"XYZ\" Registro de estudiantes nuevos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 253);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenida = new JLabel("Bienvenido al registro de estudiantes");
		lblBienvenida.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		lblBienvenida.setBounds(72, 30, 295, 26);
		contentPane.add(lblBienvenida);
		
		JLabel lblSeleccione = new JLabel("Seleccione la opción que desea realizar:\r\n");
		lblSeleccione.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblSeleccione.setBounds(82, 70, 295, 13);
		contentPane.add(lblSeleccione);
		
		JButton btnRegistro = new JButton("Registro de estudiante");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = 0;
				SeleccionEstudiante OptionPane = new SeleccionEstudiante();
				OptionPane.setVisible(true);
				opcion = OptionPane.SeleccionEstudiante(opcion);
				//System.out.println(opcion);
				if(opcion == 1) {
					VentanaRegistro vtnRegular = new VentanaRegistro(estReg,estranjero);
					vtnRegular.setVisible(true);
					vtnRegular.setLocationRelativeTo(null);
					dispose();
				}
				
				if(opcion == 2) {
					VentanaEstranjero vtnExtranjero = new VentanaEstranjero(estReg,estranjero);
					vtnExtranjero.setVisible(true);
					vtnExtranjero.setLocationRelativeTo(null);
					dispose();
				}
				
			}
		});
		btnRegistro.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnRegistro.setBounds(96, 104, 224, 27);
		contentPane.add(btnRegistro);
		
		JButton btnReporteCarrera = new JButton("Reporte de carrera");
		btnReporteCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCarrera carreras = new ReporteCarrera(estReg, estranjero);
				carreras.setVisible(true);
				carreras.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnReporteCarrera.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnReporteCarrera.setBounds(96, 141, 224, 27);
		contentPane.add(btnReporteCarrera);
		
		JButton btnReporteDeEstudiante = new JButton("Reporte de estudiante");
		btnReporteDeEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteAlumno alumno = new ReporteAlumno(estReg, estranjero);
				alumno.setVisible(true);
				alumno.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnReporteDeEstudiante.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnReporteDeEstudiante.setBounds(96, 179, 224, 27);
		contentPane.add(btnReporteDeEstudiante);
	}

	public void VentanaInicioEstudiantes(ArrayList<EstudianteRegular> estReg, ArrayList<EstudianteExtranjero> estranjero) {
		// TODO Auto-generated constructor stub
	}

	public void VentanaInicioEstudiantes1(ArrayList<EstudianteRegular> estReg) {
		// TODO Auto-generated constructor stub
	}
}
