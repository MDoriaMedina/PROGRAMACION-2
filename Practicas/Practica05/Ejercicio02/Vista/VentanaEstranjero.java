package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.EstudianteExtranjero;
import Modelo.EstudianteRegular;
import Modelo.RegistroEstranjero;

import java.awt.Color;

public class VentanaEstranjero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreE;
	private JTextField textApellidoE;
	private JTextField textDiaE;
	private JTextField textMesS;
	private JTextField textYearS;
	private JTextField textPasaporte;
	private JTextField textNacionalidadE;
	private JTextField textDireccionE;
	private JTextField textIdioma;
	
	RegistroEstranjero registro2 = new RegistroEstranjero();

	/**
	 * Create the frame.
	 */
	public VentanaEstranjero(ArrayList<EstudianteRegular> estReg, ArrayList<EstudianteExtranjero> estranjero) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 190, 159));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	VentanaInicioEstudiantes ventanaInicio = new VentanaInicioEstudiantes(estReg,estranjero);
                ventanaInicio.setVisible(true);
                ventanaInicio.setLocationRelativeTo(null);
                //dispose();
            }
        });

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosRegular = new JLabel("Datos del nuevo estudiante estranjero:");
		lblDatosRegular.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDatosRegular.setBounds(63, 10, 327, 31);
		contentPane.add(lblDatosRegular);
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNombre.setBounds(42, 55, 57, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblApellidos.setBounds(42, 84, 57, 13);
		contentPane.add(lblApellidos);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(42, 113, 130, 13);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNacionalidad.setBounds(255, 142, 83, 13);
		contentPane.add(lblNacionalidad);
		
		JLabel lblCarnet = new JLabel("Pasaporte:");
		lblCarnet.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblCarnet.setBounds(42, 142, 69, 13);
		contentPane.add(lblCarnet);
		
		JLabel lblDireccionDeDomicilio = new JLabel("Direccion de domicilio:");
		lblDireccionDeDomicilio.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDireccionDeDomicilio.setBounds(37, 204, 172, 13);
		contentPane.add(lblDireccionDeDomicilio);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblCarrera.setBounds(42, 262, 57, 13);
		contentPane.add(lblCarrera);
		
		
		
		String [] carreras = {"PSICOLOGIA","ADMINISTRACION DE EMPRESAS","INGENIERIA DE SISTEMAS"};
		JComboBox<Object> comboBoxCarrera = new JComboBox<Object>(carreras);
		comboBoxCarrera.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		comboBoxCarrera.setBounds(107, 259, 183, 21);
		contentPane.add(comboBoxCarrera);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDia.setBounds(174, 113, 35, 13);
		contentPane.add(lblDia);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblMes.setBounds(255, 113, 35, 13);
		contentPane.add(lblMes);
		
		JLabel lblAo = new JLabel("Año:");
		lblAo.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblAo.setBounds(355, 113, 35, 13);
		contentPane.add(lblAo);
		
		
		
		/*String[] items = {"SUMA", "RESTA", "MULTIPLICACION", "DIVISION"};
		JComboBox<Object> comboBoxOperacion = 
				new JComboBox<Object>(items);
		comboBoxOperacion.setBounds(167, 112, 116, 22);
		contentPane.add(comboBoxOperacion);*/
		
		
		
		JButton btnRegEst = new JButton("REGISTRAR");
		btnRegEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombreE.getText().isEmpty() || textApellidoE.getText().isEmpty() || textDiaE.getText().isEmpty() || textMesS.getText().isEmpty() || textYearS.getText().isEmpty() || textPasaporte.getText().isEmpty() || textDireccionE.getText().isEmpty() || comboBoxCarrera.getSelectedIndex() == -1 || textNacionalidadE.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
				}else {
					//System.out.println("Todo lleno");
					try {
						int dia = Integer.parseInt(textDiaE.getText());
						int mes = Integer.parseInt(textMesS.getText());
						int year = Integer.parseInt(textYearS.getText());
						//System.out.println("Departamento: "+comboBoxDepartamento.getSelectedIndex());
						//System.out.println("Carrera: "+comboBoxCarrera.getSelectedIndex());
						
						registro2.AgregarExtranjero(estranjero, textNombreE.getText(), textApellidoE.getText(), textPasaporte.getText(), dia, mes, year, textNacionalidadE.getText(), comboBoxCarrera.getSelectedIndex(), textDireccionE.getText(),textIdioma.getText());
						System.out.println("Lista:\n"+registro2.DesplegarListaExtranjero(estranjero));				
						JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente!");
						VentanaInicioEstudiantes inicio = new VentanaInicioEstudiantes(estReg,estranjero);
						inicio.setVisible(true);
						inicio.setLocationRelativeTo(null);
						dispose();
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Debe introducir valores numéricos");
					}
				}
				//String nombre = textNombre.getText();
				
			}
		});
		btnRegEst.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegEst.setBounds(324, 252, 147, 31);
		contentPane.add(btnRegEst);
		
		textNombreE = new JTextField();
		textNombreE.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textNombreE.setBounds(101, 51, 347, 19);
		contentPane.add(textNombreE);
		textNombreE.setColumns(10);
		
		textApellidoE = new JTextField();
		textApellidoE.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textApellidoE.setColumns(10);
		textApellidoE.setBounds(101, 82, 347, 19);
		contentPane.add(textApellidoE);
		
		textDiaE = new JTextField();
		textDiaE.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textDiaE.setColumns(10);
		textDiaE.setBounds(194, 111, 51, 19);
		contentPane.add(textDiaE);
		
		textMesS = new JTextField();
		textMesS.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textMesS.setColumns(10);
		textMesS.setBounds(296, 110, 42, 19);
		contentPane.add(textMesS);
		
		textYearS = new JTextField();
		textYearS.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textYearS.setColumns(10);
		textYearS.setBounds(391, 110, 57, 19);
		contentPane.add(textYearS);
		
		textPasaporte = new JTextField();
		textPasaporte.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textPasaporte.setColumns(10);
		textPasaporte.setBounds(107, 140, 102, 19);
		contentPane.add(textPasaporte);
		
		textNacionalidadE = new JTextField();
		textNacionalidadE.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textNacionalidadE.setColumns(10);
		textNacionalidadE.setBounds(346, 139, 102, 19);
		contentPane.add(textNacionalidadE);
		
		textDireccionE = new JTextField();
		textDireccionE.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textDireccionE.setColumns(10);
		textDireccionE.setBounds(174, 201, 306, 19);
		contentPane.add(textDireccionE);
		
		JLabel lblLenguaMaterna = new JLabel("Lengua materna:");
		lblLenguaMaterna.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblLenguaMaterna.setBounds(42, 176, 107, 13);
		contentPane.add(lblLenguaMaterna);
		
		textIdioma = new JTextField();
		textIdioma.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textIdioma.setColumns(10);
		textIdioma.setBounds(143, 174, 147, 19);
		contentPane.add(textIdioma);
			
	
	}

}
