package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto_Progra_2";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
	private static final JOptionPane JOptionpane = null;
    
    private static Connection connection = null;
    
    
	//Funcion conectar base de datos al login
	public static Connection conectar() {
		
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				JOptionPane.showMessageDialog(null, "conexion exitosa");
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "No se estableción la coneccion" + e);
			}
		}
		return connection;
		
	}
	
	//1siempre cerrar la conexion
	public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null; // Limpiar la referencia
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se cerro la conexion" + e);
            }
        }
    }
	
	


}
