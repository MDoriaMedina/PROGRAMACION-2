package Vista;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class AgregarEstudianteNacional extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCarnet;
	private JTextField textResidencia;
	private JTextField textPaterno;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textAnio;
	private JTextField textMaterno;
	private JTextField textCorreo;
	private JComboBox comboBox_1;
	public int tipo_usuario = 2;
	

	/**
	 * Create the frame.
	 */
	public AgregarEstudianteNacional() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarEstudianteNacional = new JLabel("AGREGAR ESTUDIANTE NACIONAL");
		lblAgregarEstudianteNacional.setBounds(10, 10, 175, 13);
		contentPane.add(lblAgregarEstudianteNacional);
		
		JButton btnVolverUnoUno = new JButton("VOLVER");
		btnVolverUnoUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEstudiante ventanaAgregarEstudiante = new AgregarEstudiante();
				ventanaAgregarEstudiante.setVisible(true);
				ventanaAgregarEstudiante.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVolverUnoUno.setBounds(34, 277, 85, 21);
		contentPane.add(btnVolverUnoUno);
		
		JLabel lblCarnet = new JLabel("Carnet");
		lblCarnet.setBounds(10, 167, 45, 13);
		contentPane.add(lblCarnet);
		
		JLabel lblDeptoNacimiento = new JLabel("Depto. Nacimiento");
		lblDeptoNacimiento.setBounds(201, 129, 93, 13);
		contentPane.add(lblDeptoNacimiento);
		
		JLabel lblResidencia = new JLabel("Residencia");
		lblResidencia.setBounds(237, 161, 57, 13);
		contentPane.add(lblResidencia);
		
		JLabel lblPaterno = new JLabel("Paterno");
		lblPaterno.setBounds(10, 36, 45, 13);
		contentPane.add(lblPaterno);
		
		JLabel lblMaterno = new JLabel("Materno");
		lblMaterno.setBounds(10, 67, 45, 13);
		contentPane.add(lblMaterno);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 98, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 138, 45, 13);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaNacimiento.setBounds(201, 21, 104, 13);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblAnio = new JLabel("Año");
		lblAnio.setBounds(260, 39, 24, 13);
		contentPane.add(lblAnio);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(260, 67, 24, 13);
		contentPane.add(lblMes);
		
		JLabel lblDia = new JLabel("Día");
		lblDia.setBounds(260, 98, 24, 13);
		contentPane.add(lblDia);
		
		textCarnet = new JTextField();
		textCarnet.setBounds(77, 164, 96, 19);
		contentPane.add(textCarnet);
		textCarnet.setColumns(10);
		
		textResidencia = new JTextField();
		textResidencia.setBounds(291, 158, 96, 19);
		contentPane.add(textResidencia);
		textResidencia.setColumns(10);
		
		textPaterno = new JTextField();
		textPaterno.setBounds(77, 33, 96, 19);
		contentPane.add(textPaterno);
		textPaterno.setColumns(10);
		
		textMaterno = new JTextField();
		textMaterno.setBounds(77, 64, 96, 19);
		contentPane.add(textMaterno);
		textMaterno.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(77, 95, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(77, 132, 96, 19);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textAnio = new JTextField();
		textAnio.setBounds(291, 36, 96, 19);
		contentPane.add(textAnio);
		textAnio.setColumns(10);
		
		String[] departamentos = {"Pando","Beni","La Paz",
								  "Cochabamba","Santa Cruz","Oruro",
								  "Chuquisaca","Potosí","Tarija"};
		JComboBox comboBoxDeptoNacimiento = new JComboBox(departamentos);
		comboBoxDeptoNacimiento.setBounds(291, 125, 96, 21);
		contentPane.add(comboBoxDeptoNacimiento);
		
		String[] meses = {"Enero","Febrero","Marzo",
						  "Abril","Mayo","Junio",
						  "Julio","Agosto","Septiembre",
						  "Octubre","Noviembre","Diciembre"};
		JComboBox comboBoxMes = new JComboBox(meses);
		comboBoxMes.setBounds(291, 63, 96, 21);
		contentPane.add(comboBoxMes);
		
		String[] dias = new String[31];
		for(int i=0; i < 31; i++) {
			dias[i] = String.valueOf(i+1);
		}
		JComboBox comboBoxDia = new JComboBox(dias);
		comboBoxDia.setBounds(291, 94, 96, 21);
		contentPane.add(comboBoxDia);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 197, 45, 13);
		contentPane.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(77, 193, 310, 19);
		contentPane.add(textCorreo);
		
		//JComboBox comboBox = new JComboBox();
		Conexion conn = new Conexion();
		ArrayList<String> carreras = conn.obtenerCarreras();
        comboBox_1 = new JComboBox<>(carreras.toArray(new String[0]));
        comboBox_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox_1.getSelectedItem();
            }
        });
		comboBox_1.setBounds(77, 222, 169, 21);
		contentPane.add(comboBox_1);
		
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(10, 226, 45, 13);
		contentPane.add(lblCarrera);
		
		JButton btnAgregarEstudianteNacional = new JButton("CONFIRMAR");
		btnAgregarEstudianteNacional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(comprobarCamposLlenos()) 
					{
						if (comprobarNumerico()) 
						{
							if (comprobarAnioValido()) 
							{
								int dia = comboBoxDia.getSelectedIndex() + 1;
								int mes = comboBoxMes.getSelectedIndex() + 1;
								int anio = Integer.parseInt(textAnio.getText().trim());
								
								if (comprobarFechaValida(dia,mes,anio)) 
								{
									// Composición del apellido
									String paterno = textPaterno.getText().toUpperCase();
									String materno = textMaterno.getText().toUpperCase();
									String sigla = ((String) comboBox_1.getSelectedItem()).split(" - ")[0];;
									// Variables oficiales para la base de datos:
									String carnet = textCarnet.getText();
									String nacionalidad = "BOLIVIANA";
									String deptoNacimiento = comboBoxDeptoNacimiento.getSelectedItem().toString().toUpperCase();
									String residencia = textResidencia.getText();
									String nombre = textNombre.getText().toUpperCase();
									String apellido = paterno + " " + materno;
									String telefono = textTelefono.getText();
									String fechaNacimiento = anio + "-" + mes + "-" + dia;

									// Una vez registrado, se restablecen los campos 
									JOptionPane.showMessageDialog(null, "Se registró con éxito");
									
									Conexion conn = new Conexion();
									
									//Se puede insertar el correo para enviar por correo
									conn.crearUsuario(apellido, nombre, tipo_usuario);
									int idEstudiante = conn.insertarEstudiante(apellido, nombre, fechaNacimiento, telefono, sigla);
									
									restablecerCampos();
								}
								else 
								{
									JOptionPane.showMessageDialog(null, "La fecha no es válida");
								}
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "El año no es válido");
							}
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "Teléfono y Año deben ser enteros");
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
					}
					
					
				} catch(Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnAgregarEstudianteNacional.setBounds(302, 260, 85, 21);
		contentPane.add(btnAgregarEstudianteNacional);
		
		
	}
	
	// Comprobar que todos los campos estén llenados
	private boolean comprobarCamposLlenos(){
		
		boolean noVacio = true;
		JTextField[] campos = {textNombre, textPaterno, textMaterno, textTelefono, 
							   textResidencia, textCarnet,
							   textAnio};
		for (JTextField campo : campos) {
			if (campo.getText().trim().isEmpty()) {
				noVacio = false;
				break;
			}
		}
		return noVacio;
	}
	
	// Comprobar que el teléfono y año sean números enteros
	private boolean comprobarNumerico() {
		
		boolean numerico = true;
		try {
			Integer.parseInt(textTelefono.getText().trim());
			Integer.parseInt(textAnio.getText().trim());
		} catch (NumberFormatException f) {
			numerico = false;
		}
		return numerico;
	}
	
	// Comprobar que el año sea razonable (en este caso de 1900 hasta 2024)
	private boolean comprobarAnioValido() {
		boolean anioValido = true;
		int anio = Integer.parseInt(textAnio.getText().trim()); 
		if(anio >= 2025 || anio <= 1899) {
			anioValido = false;
		}
		return anioValido;
	}
	
	// Comprobar que los días y meses sean acordes
	private boolean comprobarFechaValida(int dia, int mes, int anio) {
        boolean fechaValida = true;

        if (mes < 1 || mes > 12) 
        {
            fechaValida = false;
        } 
        else 
        {
            switch (mes) {
                case 2: 
                	
                    if (comprobarBisiesto(anio)) 
                    {
                        if (dia < 1 || dia > 29) 
                        {
                            fechaValida = false;
                        }
                    } 
                    
                    else 
                    {
                        if (dia < 1 || dia > 28) 
                        {
                            fechaValida = false;
                        }
                    }
                    break;
                case 4: 
                case 6:
                case 9:
                case 11:
                    if (dia < 1 || dia > 30) 
                    {
                        fechaValida = false;
                    }
                    break;
                default:
                    if (dia < 1 || dia > 31) 
                    {
                        fechaValida = false;
                    }
                    break;
            }
        }

        return fechaValida;
    }
	
	// Comprobar los años bisiestos
	private boolean comprobarBisiesto(int anio) {
        return (anio % 4 == 0) && (anio % 100 != 0 || anio % 400 == 0);
    }
	
	// Cuando ya se registra, se restablecen los campos
    private void restablecerCampos() {
        textNombre.setText("");
        textPaterno.setText("");
        textMaterno.setText("");
        textTelefono.setText("");
        textResidencia.setText("");
        textCarnet.setText("");
        textAnio.setText("");
        textCorreo.setText("");
    }
}
