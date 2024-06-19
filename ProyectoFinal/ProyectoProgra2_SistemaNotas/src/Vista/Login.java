package Vista;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setBounds(153, 70, 90, 13);
		contentPane.add(LabelUsuario);
		
		JLabel LabelPass = new JLabel("Contraseña:");
		LabelPass.setBounds(153, 109, 90, 13);
		contentPane.add(LabelPass);
		
		textField = new JTextField();
		textField.setBounds(228, 67, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 106, 96, 19);
		contentPane.add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()==true || passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!");
				}else {
					
					Conexion conn = new Conexion();
					Connection conexion = Conexion.conectar();
					
					String usuario = textField.getText();
					String pass = new String(passwordField.getPassword());
					//Lo convierte en new Strign xq getPassword consigue los valores por char[]
					
					try {
						String sql = "SELECT * FROM usuario where usuario = ? AND pass = ?";
						PreparedStatement ps = conexion.prepareStatement(sql);
						ps.setString(1, usuario);
						ps.setString(2, pass);
						ResultSet rs = ps.executeQuery();
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Login exitoso");
							int tipo = rs.getInt("tipo_usuario");
							switch (tipo) {
							case 1:
								VentanaDocente vd = new VentanaDocente();
								vd.setVisible(true);
								vd.setLocationRelativeTo(null);
								
								break;
							case 2:
								JOptionPane.showMessageDialog(null, "Aqui viene la ventana Estudiante");
								break;
							case 3:
								AdminPrincipal admin = new AdminPrincipal();
								admin.setVisible(true);
								admin.setLocationRelativeTo(null);
							}
							dispose();
								
						}else {
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
						}
						
					}catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, e);
					}finally {
						conn.closeConnection();
					}
				}
			}
			
		});
		btnIngresar.setBounds(190, 170, 85, 21);
		contentPane.add(btnIngresar);
		
		
	}
}
