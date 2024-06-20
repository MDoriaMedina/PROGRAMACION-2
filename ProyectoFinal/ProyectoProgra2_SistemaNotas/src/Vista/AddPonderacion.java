package Vista;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;
import Modelo.Ponderacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPonderacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDescripcion;
	private JTextField textValor;
	public int i = 0;

	public AddPonderacion(ArrayList<Ponderacion> ponderaciones, int num, int id_curso) {
		
		
		
		setTitle("Ponderaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese la descripción de la ponderación: ");
		lblNewLabel.setBounds(42, 51, 210, 13);
		contentPane.add(lblNewLabel);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(41, 74, 354, 19);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblIngreseElValor = new JLabel("Ingrese el valor de ponderación:");
		lblIngreseElValor.setBounds(42, 103, 210, 13);
		contentPane.add(lblIngreseElValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(41, 126, 354, 19);
		contentPane.add(textValor);
		
		JLabel lblNewLabel_1 = new JLabel("Ponderacion nro:");
		lblNewLabel_1.setBounds(144, 19, 87, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNumero = new JLabel();
		lblNumero.setBounds(233, 28, 45, 13);
		contentPane.add(lblNumero);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textDescripcion.getText().isEmpty() || textValor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar los campos");
				}else {
					Ponderacion p = new Ponderacion(textDescripcion.getText(),Double.parseDouble(textValor.getText()));
					ponderaciones.add(p);
					textValor.setText("");
					textDescripcion.setText("");
					i++;
					if(i == num) {
						
						Conexion conn = new Conexion();
						Connection conexion = Conexion.conectar();
						
						String sql = "insert into NotasPonderacion (descripcion, porcentaje, curso_id_curso) values (?, ?, ?)";
						
						try (PreparedStatement ps = conexion.prepareStatement(sql)) {
				            for (Ponderacion p1 : ponderaciones) {
				                ps.setString(1, p1.getDescripcion());
				                ps.setDouble(2, p1.getValor());
				                ps.setInt(3, id_curso);
				                ps.addBatch();  // Añadir la operación al batch
				            }

				            int[] result = ps.executeBatch();  // Ejecutar el batch
				            System.out.println("Datos insertados correctamente. Resultados: " + result.length);

				        } catch (SQLException e1) {
				            e1.printStackTrace();
				        
						i = 0;
						//Se puede deshabilitar el boton para que no se modifique la forma de calificacion
						String unicaVez = "false";
						VentanaMateria ventana = new VentanaMateria(unicaVez, id_curso);
						ventana.setVisible(true);
						ventana.setLocationRelativeTo(null);
						dispose();
						
				        }
					//dispose();
					}
			}
			}
		});
		btnAgregar.setBounds(144, 175, 134, 31);
		contentPane.add(btnAgregar);
		
		
		
	}
	
	public String descripcion() {
		String desc = "";
		desc = textDescripcion.getText();
		return desc;
	}
	
	public double valor() {
		double valor = 0.0;
		valor = Double.parseDouble(textValor.getText());
		return valor;
	}
	
	
}
