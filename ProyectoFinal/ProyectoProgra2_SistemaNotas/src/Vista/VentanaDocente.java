package Vista;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
 	public int id_curso = 0;

	public VentanaDocente(int id_usuario) {
		
		ArrayList<String> materias = new ArrayList<>();
		
		setTitle("Docente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelseleccion = new JLabel("Seleccione su materia:");
		labelseleccion.setBounds(36, 58, 121, 13);
		contentPane.add(labelseleccion);
		
		Connection conexion = Conexion.conectar();
		
		String sql = "select b.materia, c.paralelo, c.id_curso\r\n"
				+ "from docente a, materia b, curso c\r\n"
				+ "where b.id_materia = c.materia_id_materia\r\n"
				+ "and a.id_docente = c.docente_id_docente\r\n"
				+ "and a.usuario_id_usuario = ?";
	
		try (PreparedStatement ps = conexion.prepareStatement(sql);){
			
			ps.setInt(1, id_usuario);
			//ResultSet rs = ps.executeQuery();	
			//new Conexion();
			//Connection conexion = Conexion.conectar();
			//PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//comprobamos el id del usuario
			System.out.println(id_usuario);
			
			while(rs.next()) {
				String materia = rs.getString("materia");
				String paralelo = rs.getString("paralelo");
				id_curso = rs.getInt("id_curso");
				materias.add(materia+" Paralelo: "+paralelo);
			}
			
			System.out.println("Materias para el docente con ID 1:");
	        for (String materia : materias) {
	            System.out.println(materia);
	        }
	        
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		JComboBox<String> comboBoxMaterias = new JComboBox<>();
		comboBoxMaterias.setBounds(36, 81, 351, 21);
		contentPane.add(comboBoxMaterias);
		
		JLabel lblNewLabel = new JLabel("Bienvenido!");
		lblNewLabel.setBounds(37, 22, 99, 13);
		contentPane.add(lblNewLabel);
		
		for (String materia : materias) {
            //System.out.println(materia);
            comboBoxMaterias.addItem(materia);  // Agregar cada materia al JComboBox
        }
		
		
		comboBoxMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String materiaSeleccionada = (String) comboBoxMaterias.getSelectedItem();
				if(materiaSeleccionada.isEmpty()) {
					JOptionPane.showMessageDialog(null,"El docente no tiene materias asignadas");
				}else {
					VentanaMateria materia = new VentanaMateria(materiaSeleccionada, id_curso);
					materia.setVisible(true);
					materia.setLocationRelativeTo(null);
					dispose();
				}
				
			}
		});
		
		JButton btbModPass = new JButton("Cambiar contraseña");
		btbModPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btbModPass.setBounds(36, 218, 151, 21);
		contentPane.add(btbModPass);
		
		
		
		
		
		
		
		
	}
}
