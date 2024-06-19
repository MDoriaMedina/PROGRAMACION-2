package Vista;

import java.awt.EventQueue;
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

public class VentanaDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaDocente() {
		
		ArrayList<String> materias = new ArrayList<>();
		
		
		
		setTitle("Docente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelseleccion = new JLabel("Seleccione su materia:");
		labelseleccion.setBounds(36, 28, 121, 13);
		contentPane.add(labelseleccion);
		
		String sql = "select b.materia\r\n"
				+ "from docente a, materia b, curso c\r\n"
				+ "where b.id_materia = c.materia_id_materia\r\n"
				+ "and a.id_docente = c.docente_id_docente;";
		
		try {
			//Conectamos a base de datos para hacer consultas
			Conexion conn = new Conexion();
			Connection conexion = Conexion.conectar();
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String materia = rs.getString("materia");
				materias.add(materia);
			}
			
			System.out.println("Materias para el docente con ID 1:");
	        for (String materia : materias) {
	            System.out.println(materia);
	        }
	        
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		JComboBox comboBoxMaterias = new JComboBox();
		comboBoxMaterias.setBounds(36, 51, 351, 21);
		contentPane.add(comboBoxMaterias);
		
		for (String materia : materias) {
            System.out.println(materia);
            comboBoxMaterias.addItem(materia);  // Agregar cada materia al JComboBox
        }
		
		
		
		
	}
}
