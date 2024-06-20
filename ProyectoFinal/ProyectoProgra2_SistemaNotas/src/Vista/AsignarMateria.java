package Vista;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class AsignarMateria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JRadioButton rdbtnRadioDocente;
    private JRadioButton rdbtnEstudiante;
	private Component comboBoxMaterias;
	private Component btnAsignarCurso;
	private int flag = 0;
	private int id;

	/**
	 * Create the frame.
	 */
	public AsignarMateria() {
		
		int rdbt = 0;
		
		setTitle("Asignar Materia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup grupo = new ButtonGroup();
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox_1.setBounds(32, 152, 272, 21);
		comboBox_1.setEnabled(false);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Seleccione:");
		lblNewLabel.setBounds(32, 25, 78, 13);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnRadioDocente = new JRadioButton("Docente");
		rdbtnRadioDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				comboBox_1.setEnabled(true);
                comboBox_1.removeAllItems();
                cargarMaterias(comboBox_1);
			}
		});
		rdbtnRadioDocente.setBounds(116, 21, 103, 21);
		contentPane.add(rdbtnRadioDocente);
		
		JRadioButton rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;
				comboBox_1.setEnabled(true);
                comboBox_1.removeAllItems();
                cargarCursos(comboBox_1);
			}
			
		});
		rdbtnEstudiante.setBounds(242, 21, 103, 21);
		contentPane.add(rdbtnEstudiante);
		
		grupo.add(rdbtnRadioDocente);
		grupo.add(rdbtnEstudiante);
		
		JLabel lblSeleccioneLaMateria = new JLabel("Seleccione la materia:");
		lblSeleccioneLaMateria.setBounds(32, 129, 174, 13);
		contentPane.add(lblSeleccioneLaMateria);
		
		textField = new JTextField();
		textField.setBounds(32, 98, 272, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSeleccioneLaOpcion = new JLabel("Introduzca el apellido para buscar:");
		lblSeleccioneLaOpcion.setBounds(32, 74, 200, 13);
		contentPane.add(lblSeleccioneLaOpcion);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(flag);
				id = buscarPersona(flag);
				if(id!=0) {
					JOptionPane.showMessageDialog(null, "Persona encontrada");
				}
			}
		});
		btnBuscar.setBounds(344, 97, 85, 21);
		contentPane.add(btnBuscar);
		
		JButton btnAsignarCurso = new JButton("Asignar Curso");
		btnAsignarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionado = (String) comboBox_1.getSelectedItem();
		        if (seleccionado == null || seleccionado.isEmpty()) {
		            JOptionPane.showMessageDialog(null,"Debe seleccionar una materia o curso.");
		            return;
		        }else {
		        	if(flag == 1) {
		        		String[] partes = seleccionado.split(" - ");
				        String materia = partes[1];
				        System.out.println(materia);
				        Conexion conn = new Conexion();
				        int idMateria = conn.obtenerIdMateria(materia);
				        //System.out.println("Boton asignar curso" + id);
				        conn.asignarParalelo(id,idMateria);
				        textField.setText("");
		        	}else {
		        		String[] partes2 = seleccionado.split("\\.");
		        		if (partes2.length > 0) { // Verificar que haya al menos un elemento después de dividir
		                    String idCurso = partes2[0];
		                    //System.out.println(idCurso);
		                    int curso_id = Integer.parseInt(idCurso);
		                    Conexion conn = new Conexion();
		                    conn.asignarCurso(id,curso_id);
		                    textField.setText("");
		                } else {
		                    System.out.println("No se pudo dividir correctamente por el punto.");
		                }
		        	}
		        	
		        }

		        
			}
		});
		btnAsignarCurso.setBounds(326, 152, 103, 21);
		btnAsignarCurso.setEnabled(true); 
		contentPane.add(btnAsignarCurso);
		
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPrincipal admin = new AdminPrincipal();
				admin.setVisible(true);
				admin.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVolver.setBounds(169, 187, 85, 21);
		contentPane.add(btnVolver);
	}
	
	public int buscarPersona(int flag) {
		
		boolean encontrado = false;
		Conexion conn = new Conexion();
        String apellido = textField.getText();
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un apellido para buscar.");
        }else {
        	if (flag == 1) {
                // Search in docentes
                this.id = conn.buscarDocentePorApellido(apellido.toUpperCase());
                
            } else if (flag == 2) {
                // Search in estudiantes
                this.id = conn.buscarEstudiantePorApellido(apellido.toUpperCase());
            }
        }
        
        System.out.println(id);
        return id;
    }

	public void cargarMaterias(JComboBox comboBox_1) {
		
		Conexion conn = new Conexion();
        ArrayList<String> materias = conn.obtenerMaterias();
        for (String materia : materias) {
            comboBox_1.addItem(materia);
        }
    }
	
	public void cargarCursos(JComboBox comboBox_1) {
		
		Conexion conn = new Conexion();
        ArrayList<String> cursos = conn.obtenerCursos();
        for (String curso : cursos) {
            comboBox_1.addItem(curso);
        }
    }
	
	
}
