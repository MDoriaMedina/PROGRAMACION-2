package Vista;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.EstudianteExtranjero;
import Modelo.EstudianteRegular;
import Modelo.RegistroRegular;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCarnet;
	private JTextField textDomicilio;
	private JTextField textNacionalidad;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textYear;
	
	RegistroRegular registro = new RegistroRegular();
	
	/**
	 * Create the frame.
	 * @param estranjero 
	 */
	public VentanaRegistro(ArrayList<EstudianteRegular> estReg, ArrayList<EstudianteExtranjero> estranjero) {
		
		setTitle("Registro estudiante regular");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 189, 255));
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
		
		JLabel lblDatosRegular = new JLabel("Datos del nuevo estudiante regular:");
		lblDatosRegular.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDatosRegular.setBounds(107, 10, 280, 31);
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
		
		JLabel lblDepartamentoDeNacimiento = new JLabel("Departamento de nacimiento:");
		lblDepartamentoDeNacimiento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDepartamentoDeNacimiento.setBounds(42, 200, 172, 13);
		contentPane.add(lblDepartamentoDeNacimiento);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNacionalidad.setBounds(42, 177, 83, 13);
		contentPane.add(lblNacionalidad);
		
		JLabel lblCarnet = new JLabel("Carnet:");
		lblCarnet.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblCarnet.setBounds(42, 142, 51, 13);
		contentPane.add(lblCarnet);
		
		JLabel lblDireccionDeDomicilio = new JLabel("Direccion de domicilio:");
		lblDireccionDeDomicilio.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDireccionDeDomicilio.setBounds(42, 229, 172, 13);
		contentPane.add(lblDireccionDeDomicilio);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblCarrera.setBounds(42, 262, 57, 13);
		contentPane.add(lblCarrera);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textNombre.setBounds(107, 51, 387, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textApellidos.setColumns(10);
		textApellidos.setBounds(107, 82, 387, 19);
		contentPane.add(textApellidos);
		
		textCarnet = new JTextField();
		textCarnet.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textCarnet.setColumns(10);
		textCarnet.setBounds(107, 139, 206, 19);
		contentPane.add(textCarnet);
		
		textDomicilio = new JTextField();
		textDomicilio.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(174, 226, 320, 19);
		contentPane.add(textDomicilio);
		
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
		lblMes.setBounds(268, 114, 35, 13);
		contentPane.add(lblMes);
		
		JLabel lblAo = new JLabel("Año:");
		lblAo.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblAo.setBounds(360, 114, 35, 13);
		contentPane.add(lblAo);
		
		String [] departamentos = {"LA PAZ","COCHABAMBA","SANTA CRUZ", "ORURO", "POTOSI", "CHUQUISACA", "PANDO","BENI","TARIJA"};
		JComboBox<Object> comboBoxDepartamento = new JComboBox<Object>(departamentos);
		comboBoxDepartamento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		comboBoxDepartamento.setBounds(224, 197, 163, 21);
		contentPane.add(comboBoxDepartamento);
		
		/*String[] items = {"SUMA", "RESTA", "MULTIPLICACION", "DIVISION"};
		JComboBox<Object> comboBoxOperacion = 
				new JComboBox<Object>(items);
		comboBoxOperacion.setBounds(167, 112, 116, 22);
		contentPane.add(comboBoxOperacion);*/
		
		textNacionalidad = new JTextField();
		textNacionalidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textNacionalidad.setColumns(10);
		textNacionalidad.setBounds(130, 171, 183, 19);
		contentPane.add(textNacionalidad);
		
		textDia = new JTextField();
		textDia.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textDia.setColumns(10);
		textDia.setBounds(198, 111, 51, 19);
		contentPane.add(textDia);
		
		textMes = new JTextField();
		textMes.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textMes.setColumns(10);
		textMes.setBounds(299, 111, 51, 19);
		contentPane.add(textMes);
		
		textYear = new JTextField();
		textYear.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textYear.setColumns(10);
		textYear.setBounds(394, 111, 62, 19);
		contentPane.add(textYear);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombre.getText().isEmpty() || textApellidos.getText().isEmpty() || textDia.getText().isEmpty() || textMes.getText().isEmpty() || textYear.getText().isEmpty() || textCarnet.getText().isEmpty() || textDomicilio.getText().isEmpty() || comboBoxDepartamento.getSelectedIndex() == -1 || comboBoxCarrera.getSelectedIndex() == -1 || textNacionalidad.getText().isEmpty())  {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
				}else {
					//System.out.println("Todo lleno");
					try {
						int dia = Integer.parseInt(textDia.getText());
						int mes = Integer.parseInt(textMes.getText());
						int year = Integer.parseInt(textYear.getText());
						//System.out.println("Departamento: "+comboBoxDepartamento.getSelectedIndex());
						//System.out.println("Carrera: "+comboBoxCarrera.getSelectedIndex());
						
						registro.AgregarAlumno(estReg, textNombre.getText(), textApellidos.getText(), textCarnet.getText(), dia, mes, year, textNacionalidad.getText(), comboBoxDepartamento.getSelectedIndex(), comboBoxCarrera.getSelectedIndex(), textDomicilio.getText());
						System.out.println("Lista:\n"+registro.DesplegarLista(estReg));				
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(347, 262, 147, 31);
		contentPane.add(btnNewButton);
			
	}
}
