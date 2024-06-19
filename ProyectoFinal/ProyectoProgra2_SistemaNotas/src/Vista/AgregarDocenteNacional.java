package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AgregarDocenteNacional extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCarnet;
	private JTextField textNacionalidad;
	private JTextField textResidencia;
	private JTextField textDeptoNacimiento;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textTitulo;
	private JTextField textTipoDocente;
	private JTextField textFechaNacimiento;
	private JTextField textTelefono;

	/**
	 * Create the frame.
	 */
	public AgregarDocenteNacional() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AGREGAR DOCENTE NACIONAL");
		lblNewLabel.setBounds(136, 10, 158, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnVolverDosUno = new JButton("VOLVER");
		btnVolverDosUno.setBounds(10, 232, 85, 21);
		btnVolverDosUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarDocente ventanaAgregarDocente = new AgregarDocente();
				ventanaAgregarDocente.setVisible(true);
				ventanaAgregarDocente.setLocationRelativeTo(null);
				dispose();
			}
		});
		contentPane.add(btnVolverDosUno);
		
		JLabel lblCarnet = new JLabel("Carnet");
		lblCarnet.setBounds(249, 49, 45, 13);
		contentPane.add(lblCarnet);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(241, 87, 68, 13);
		contentPane.add(lblNacionalidad);
		
		JLabel lblResidencia = new JLabel("Residencia");
		lblResidencia.setBounds(252, 116, 57, 13);
		contentPane.add(lblResidencia);
		
		JLabel lblDeptoNacimiento = new JLabel("Depto. Nacimiento");
		lblDeptoNacimiento.setBounds(227, 145, 85, 13);
		contentPane.add(lblDeptoNacimiento);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 49, 45, 13);
		contentPane.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 84, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 114, 45, 13);
		contentPane.add(lblTitulo);
		
		JLabel lblTipoDocente = new JLabel("Tipo Docente");
		lblTipoDocente.setBounds(10, 147, 45, 13);
		contentPane.add(lblTipoDocente);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(10, 180, 45, 13);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(264, 180, 45, 13);
		contentPane.add(lblTelefono);
		
		textCarnet = new JTextField();
		textCarnet.setBounds(319, 46, 96, 19);
		contentPane.add(textCarnet);
		textCarnet.setColumns(10);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setBounds(319, 84, 96, 19);
		contentPane.add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		textResidencia = new JTextField();
		textResidencia.setBounds(319, 113, 96, 19);
		contentPane.add(textResidencia);
		textResidencia.setColumns(10);
		
		textDeptoNacimiento = new JTextField();
		textDeptoNacimiento.setBounds(319, 142, 96, 19);
		contentPane.add(textDeptoNacimiento);
		textDeptoNacimiento.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(65, 46, 96, 19);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(65, 84, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(65, 113, 96, 19);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		textTipoDocente = new JTextField();
		textTipoDocente.setBounds(65, 142, 96, 19);
		contentPane.add(textTipoDocente);
		textTipoDocente.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(65, 177, 96, 19);
		contentPane.add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(319, 177, 96, 19);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnConfirmarTres = new JButton("CONFIRMAR");
		btnConfirmarTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String carnet = textCarnet.getText();
					String nacionalidad = textNacionalidad.getText();
					String residencia = textResidencia.getText();
					String deptoNacimiento = textDeptoNacimiento.getText();
					String apellido = textApellido.getText();
					String nombre = textNombre.getText();
					String titulo = textTitulo.getText();
					String tipoDocente = textTipoDocente.getText();
					String fechaNacimiento = textFechaNacimiento.getText();
					String telefono = textTelefono.getText();
					
					//crear usuario:
					//if()
					
					
					Conexion conn = new Conexion();
					Connection conexion = Conexion.conectar();
					
					
					
					//insertar en tablas
					String sqlDocente = "INSERT INTO docente (apellido, nombre, titulo, tipo_docente, fechaNacimiento, telefono, usuario_id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstDocente = conexion.prepareStatement(sqlDocente, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstDocente.setString(1, apellido);
                    pstDocente.setString(2, nombre);
                    pstDocente.setString(3, titulo);
                    pstDocente.setString(4, tipoDocente);
                    pstDocente.setDate(5, java.sql.Date.valueOf(fechaNacimiento));
                    pstDocente.setString(6, telefono);
                    
                    
                    pstDocente.setInt(7, 0); // Aquí deberías colocar el valor adecuado para usuario_id_usuario

                    int affectedRowsDocente = pstDocente.executeUpdate();
                    if (affectedRowsDocente == 0) {
                        throw new SQLException("Fallo la inserción del docente, no se obtuvo ninguna fila afectada.");
                    }

                    int docenteId;
                    try (ResultSet generatedKeys = pstDocente.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            docenteId = generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Fallo la inserción del docente, no se obtuvo el ID.");
                        }
                    }

                    // Insertar datos en la tabla docente_nacional
                    String sqlDocenteNacional = "INSERT INTO docente_nacional (carnet, nacionalidad, residencia, deptoNacimiento, docente_id_docente) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstDocenteNacional = conexion.prepareStatement(sqlDocenteNacional);
                    pstDocenteNacional.setString(1, carnet);
                    pstDocenteNacional.setString(2, nacionalidad);
                    pstDocenteNacional.setString(3, residencia);
                    pstDocenteNacional.setString(4, deptoNacimiento);
                    pstDocenteNacional.setInt(5, docenteId);

                    pstDocenteNacional.executeUpdate();

                    pstDocente.close();
                    pstDocenteNacional.close();
                    conexion.close();
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnConfirmarTres.setBounds(309, 232, 96, 21);
		contentPane.add(btnConfirmarTres);
	}
}
