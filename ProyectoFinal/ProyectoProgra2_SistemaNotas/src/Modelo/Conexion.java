package Modelo;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JOptionPane;

public class Conexion {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto_Progra_2";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
	private static final JOptionPane JOptionpane = null;
	public int id_estudiante = 0;
	public int id_docente = 0;
    
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
	
	public class PasswordGenerator {
	    private static final SecureRandom random = new SecureRandom();
	    private static final int PASSWORD_LENGTH = 12; // Longitud de la contraseña

	    public static String generateRandomPassword() {
	        byte[] passwordBytes = new byte[PASSWORD_LENGTH];
	        random.nextBytes(passwordBytes);
	        return Base64.getEncoder().encodeToString(passwordBytes).substring(0, PASSWORD_LENGTH);
	    }
	}
	
	public void crearUsuario(String apellido, String nombre, int tipoUsuario) {
		
		//int idUsuario = 0;
        String password = PasswordGenerator.generateRandomPassword();
        String sql = "INSERT INTO usuario (usuario,pass,tipo_usuario) VALUES (?, ?, ?)";
        String usuario = generarUsuario(apellido, nombre, tipoUsuario);
        
        //JOptionPane.showMessageDialog(null, "Un nuevo usuario fue insertado exitosamente!");
    	//JOptionPane.showMessageDialog(null, "Usuario: "+usuario+"\nPassword: "+password);
    	try (Connection conexion = this.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

               ps.setString(1, usuario);
               ps.setString(2, password);
               ps.setInt(3, tipoUsuario);

               int rowsInserted = ps.executeUpdate();
               if (rowsInserted > 0) {
                   try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                       if (generatedKeys.next()) {
                           int idUsuario = generatedKeys.getInt(1);
                           System.out.println("Un nuevo usuario fue insertado exitosamente con ID: " + idUsuario);
                           JOptionPane.showMessageDialog(null, "Un nuevo usuario fue insertado exitosamente!");
                           JOptionPane.showMessageDialog(null, "Usuario: " + usuario + "\nPassword: " + password);
                       }
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           } finally {
               this.closeConnection();
           }
    }
	
	public static String generarUsuario(String apellido, String nombre, int tipoUsuario) {
        apellido = apellido.toLowerCase();
        nombre = nombre.toLowerCase();

        if (tipoUsuario == 1) {
            // Inicial del nombre seguido del primer apellido (hasta el primer espacio)
            char inicialNombre = nombre.charAt(0);
            String primerApellido = apellido.split(" ")[0];
            return inicialNombre + primerApellido;
        } else if (tipoUsuario == 2) {
            // Nombre, primer apellido, inicial del segundo apellido separados por puntos
            String[] apellidos = apellido.split(" ");
            String[] primerNombre = nombre.split(" ");
            if (apellidos.length > 1) {
                String primerApellido = apellidos[0];
                char inicialSegundoApellido = apellidos[1].charAt(0);
                return primerNombre + "." + primerApellido + "." + inicialSegundoApellido;
            } else {
                // Si no hay segundo apellido, solo devuelve nombre.primerApellido
                return nombre + "." + apellidos[0];
            }
        } else {
            throw new IllegalArgumentException("Tipo de usuario no válido");
        }
    }
	
	public int obtenerMaximoIdDocente() {
        int maxIdDocente = -1;
        String sql = "SELECT MAX(id_docente) AS numero FROM docente";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                maxIdDocente = rs.getInt("numero");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return maxIdDocente;
    }
	
	public int obtenerMaximoIdEstudiante() {
        int maxIdEst = -1;
        String sql = "SELECT MAX(id_estudiante) AS numero FROM estudiante";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                maxIdEst = rs.getInt("numero");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return maxIdEst;
    }
	
	public int obtenerMaximoIdUsuario() {
        int maxIdUsuario = -1;
        String sql = "SELECT MAX(id_usuario) AS numero FROM usuario";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                maxIdUsuario = rs.getInt("numero");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return maxIdUsuario;
    }
	
	public int obtenerMaximoIdCurso() {
		int maxIdCurso = -1;
        String sql = "SELECT MAX(id_curso) AS numero FROM curso";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
            	maxIdCurso = rs.getInt("numero");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return maxIdCurso;
	}
	
	public int insertarDocente(String apellido, String nombre, String titulo, String tipoDocente, String fechaNacimientoStr, String telefono) {
        int idDocenteInsertar = obtenerMaximoIdDocente() + 1; // Obtener el máximo id_docente y sumarle 1
        int idUsuario_id_usuario = obtenerMaximoIdUsuario() + 1;
        String sql = "INSERT INTO docente (id_docente, apellido, nombre, titulo, tipo_docente, fechaNacimiento, telefono, usuario_id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Convertir la cadena de fecha a java.sql.Date
        Date fechaNacimiento = Date.valueOf(fechaNacimientoStr);

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idDocenteInsertar);
            ps.setString(2, apellido);
            ps.setString(3, nombre);
            ps.setString(4, titulo);
            ps.setString(5, tipoDocente);
            ps.setDate(6, fechaNacimiento);
            ps.setString(7, telefono);
            ps.setInt(8, idUsuario_id_usuario);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nuevo docente insertado con ID: " + idDocenteInsertar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return idDocenteInsertar;
    }
	
	public boolean actualizarContrasena(int idUsuario, String contrasenaAntigua, String contrasenaNueva) {
        String sqlSelect = "SELECT contrasena FROM usuarios WHERE id_usuario = ?";
        String sqlUpdate = "UPDATE usuarios SET contrasena = ? WHERE id_usuario = ?";

        try (Connection conexion = this.conectar();
             PreparedStatement psSelect = conexion.prepareStatement(sqlSelect);
             PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate)) {

            // Verificar la contraseña antigua
            psSelect.setInt(1, idUsuario);
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                String contrasenaActual = rs.getString("contrasena");

                // Aquí puedes agregar lógica adicional para verificar la contraseña, por ejemplo, usando hashing
                if (contrasenaActual.equals(contrasenaAntigua)) {
                    // Actualizar la contraseña
                    psUpdate.setString(1, contrasenaNueva);
                    psUpdate.setInt(2, idUsuario);

                    int rowsUpdated = psUpdate.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Contraseña actualizada exitosamente.");
                        return true;
                    }
                } else {
                    System.out.println("La contraseña antigua no es correcta.");
                }
            } else {
                System.out.println("Usuario no encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return false;
    }
	
	public ArrayList<String> obtenerCarreras() {
        ArrayList<String> carreras = new ArrayList<>();
        String sql = "SELECT sigla, carrera FROM carrera";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String sigla = rs.getString("sigla");
                String carrera = rs.getString("carrera");
                carreras.add(sigla + " - " + carrera);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return carreras;
    }
	
	public int insertarEstudiante(String apellido, String nombre, String fechaNacimientoStr, String telefono, String sigla) {
        int idInsertarEst = obtenerMaximoIdEstudiante() + 1; // Obtener el máximo id_docente y sumarle 1
        int idUsuario_id_usuario = obtenerMaximoIdUsuario() + 1;
        String sql = "INSERT INTO estudiante (id_estudiante, apellido, nombre, fechaNacimiento, telefono, carrera_id_carrera, usuario_id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Convertir la cadena de fecha a java.sql.Date
        Date fechaNacimiento = Date.valueOf(fechaNacimientoStr);

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idInsertarEst);
            ps.setString(2, apellido);
            ps.setString(3, nombre);
            ps.setDate(4, fechaNacimiento);
            ps.setString(5, telefono);
            ps.setString(6, sigla);
            ps.setInt(7, idUsuario_id_usuario);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nuevo estudiante insertado con ID: " + idInsertarEst);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return idInsertarEst;
    }
	
	public ArrayList<String> obtenerMaterias() {
        ArrayList<String> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	int id_materia = rs.getInt("id_materia");
                String nombre = rs.getString("materia");
                String sigla = rs.getString("carrera_sigla");
                materias.add(sigla + " - " + nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return materias;
    }

	public ArrayList<String> obtenerCursos() {
        ArrayList<String> cursos = new ArrayList<>();
        String sql = "select b.id_curso, a.carrera_sigla ,a.materia,b.paralelo\r\n"
        		+ "from materia a, curso b\r\n"
        		+ "where a.id_materia = b.materia_id_materia";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	int id_curso = rs.getInt("id_curso");
                String sigla = rs.getString("carrera_sigla");
                String nombre = rs.getString("materia");
                int paralelo = rs.getInt("paralelo");
                cursos.add(id_curso + ". " + sigla + " - " + nombre + " Par: " + paralelo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return cursos;
    }
	
	public ArrayList<String> obtenerPonderacionDescripcion(int id_curso) {
        ArrayList<String> ponderacion = new ArrayList<>();
        String sql = "select * from notasponderacion\r\n"
        		+ "where curso_id_curso = ?;";

        try (Connection conexion = this.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql)) {
               
               ps.setInt(1, id_curso);
               ResultSet rs = ps.executeQuery();
               
               while (rs.next()) {
                   String descripcion = rs.getString("descripcion");
                   ponderacion.add(descripcion);
               }

           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return ponderacion;
    }

	
	
	
	public int buscarDocentePorApellido(String apellido) {
        String sql = "SELECT * FROM docente WHERE apellido = ?";
        boolean encontrado = false;

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, apellido);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	id_docente = rs.getInt("id_docente");
                    encontrado = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return id_docente;
    }
	
	public int buscarEstudiantePorApellido(String apellido) {
        String sql = "SELECT * FROM estudiante WHERE apellido = ?";
        boolean encontrado = false;

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, apellido);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	id_estudiante = rs.getInt("id_estudiante");
                    encontrado = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        System.out.println(id_estudiante);
        return id_estudiante;
    }

	public void asignarParalelo(int id, int idMateria) {
		// Obtener el paralelo deseado (por ejemplo, el siguiente al máximo actual)
	    int paralelo = obtenerParalelo(idMateria) + 1;
	    int idCurso = obtenerMaximoIdCurso() + 1;

	    // Insertar el nuevo curso
	    String sqlInsertCurso = "INSERT INTO curso (id_curso, paralelo, materia_id_materia, docente_id_docente) VALUES (?, ?, ?, ?)";

	    try (Connection conexion = this.conectar();
	         PreparedStatement psInsertCurso = conexion.prepareStatement(sqlInsertCurso)) {

	    	psInsertCurso.setInt(1, idCurso);
	        psInsertCurso.setInt(2, paralelo);
	        psInsertCurso.setInt(3, idMateria);
	        psInsertCurso.setInt(4, id);

	        int rowsInserted = psInsertCurso.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(null, "Paralelo asignado exitosamente.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al asignar paralelo.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
	    } finally {
	        this.closeConnection();
	    }
	}
	
	public void asignarCurso(int id, int curso_id) {
		// Obtener el paralelo deseado (por ejemplo, el siguiente al máximo actual)
	    int inscrito = obtenerMaximoInscrito() + 1;

	    // Insertar el nuevo curso
	    String sqlInsertCurso = "INSERT INTO inscrito (id_inscrito, estudiante_id_estudiante, curso_id_curso) VALUES (?, ?, ?)";

	    try (Connection conexion = this.conectar();
	         PreparedStatement psInsertCurso = conexion.prepareStatement(sqlInsertCurso)) {

	    	psInsertCurso.setInt(1, inscrito);
	        psInsertCurso.setInt(2, id);
	        psInsertCurso.setInt(3, curso_id);

	        int rowsInserted = psInsertCurso.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(null, "Inscrito exitosamente.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al inscribir en curso");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
	    } finally {
	        this.closeConnection();
	    }
	}

	private int obtenerMaximoInscrito() {
		int maxId = -1;
        String sql = "SELECT MAX(id_inscrito) AS numero FROM inscrito";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                maxId = rs.getInt("numero");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return maxId;
	}

	public int obtenerIdMateria(String materia) {
		String sql = "SELECT id_materia FROM materia WHERE materia = ?";
        int idMateria = -1;

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, materia);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idMateria = rs.getInt("id_materia");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return idMateria;
	}
	
	public int obtenerParalelo(int idMateria) {
		int maxParalelo = 0;
	    String sql = "SELECT MAX(paralelo) AS mayor FROM curso WHERE materia_id_materia = ?";
	    try (Connection conexion = this.conectar();
	         PreparedStatement ps = conexion.prepareStatement(sql)) {
	        
	        ps.setInt(1, idMateria);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                maxParalelo = rs.getInt("mayor");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        this.closeConnection();
	    }

	    return maxParalelo;
	}

	public ArrayList<String[]> obtenerEstudiantesPorCurso(int idCurso) {
        ArrayList<String[]> estudiantes = new ArrayList<>();
        String sql = "select a.id_estudiante, a.apellido, a.nombre \r\n"
        		+ "from estudiante a, inscrito b, curso c\r\n"
        		+ "where a.id_estudiante = b.estudiante_id_estudiante\r\n"
        		+ "and b.curso_id_curso = c.id_curso\r\n"
        		+ "and c.id_curso = ?\r\n"
        		+ "group by a.id_estudiante,a.apellido,a.nombre\r\n"
        		+ "order by a.apellido;";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCurso);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                	int id_estudiante = rs.getInt("id_estudiante");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    estudiantes.add(new String[]{apellido /*+ " " + nombre*/});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return estudiantes;
    }

	public ArrayList<Ponderacion> obtenerPonderaciones(int idCurso) {
        ArrayList<Ponderacion> ponderaciones = new ArrayList<>();
        String sql = "SELECT descripcion, porcentaje FROM NotasPonderacion WHERE curso_id_curso = ?";

        try (Connection conexion = this.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idCurso);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String descripcion = rs.getString("descripcion");
                    double porcentaje = rs.getDouble("porcentaje");
                    Ponderacion p = new Ponderacion(descripcion, porcentaje);
                    ponderaciones.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return ponderaciones;
    }

	public int obtenerIdInscrito(String apellido) {
	    int idInscrito = 0;
	    String sql = "SELECT a.id_inscrito " +
	                 "FROM inscrito a " +
	                 "JOIN estudiante b ON a.estudiante_Id_estudiante = b.Id_estudiante " +
	                 "WHERE b.apellido = ?;"; // Ajusta la consulta según tu esquema
	    try (Connection conexion = this.conectar();
	         PreparedStatement ps = conexion.prepareStatement(sql)) {
	        ps.setString(1, apellido);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            idInscrito = rs.getInt("id_inscrito");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return idInscrito;
	}

	
	public int obtenerIdPonderacion(String descripcionPonderacion) {
	    int idPonderacion = 0;
	    String sql = "SELECT id_ponderacion FROM NotasPonderacion WHERE descripcion = ?";
	    try (Connection conexion = this.conectar();
	         PreparedStatement ps = conexion.prepareStatement(sql)) {
	        ps.setString(1, descripcionPonderacion);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            idPonderacion = rs.getInt("id_ponderacion");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return idPonderacion;
	}
	
	public void insertarNota(double nota, int inscritoId, int ponderacionId) {
	    String sql = "INSERT INTO notas (nota, inscrito_id_inscrito, NotasPonderacion_id_ponderacion) VALUES (?, ?, ?)";
	    try (Connection conexion = this.conectar();
	         PreparedStatement ps = conexion.prepareStatement(sql)) {
	        ps.setDouble(1, nota);
	        ps.setInt(2, inscritoId);
	        ps.setInt(3, ponderacionId);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
