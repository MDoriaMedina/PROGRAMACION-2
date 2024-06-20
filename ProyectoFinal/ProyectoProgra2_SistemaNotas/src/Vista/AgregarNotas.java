package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;
import Modelo.Ponderacion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarNotas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    

    /**
     * Create the frame.
     * @param id_curso 
     */
    public AgregarNotas(int id_curso) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 364, 222);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(24, 61, 263, 21);
        contentPane.add(comboBox);

        JLabel lblNewLabel = new JLabel("Seleccione la ponderacion:");
        lblNewLabel.setBounds(26, 23, 198, 13);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Agregar notas");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ponderacionSeleccionada = (String) comboBox.getSelectedItem();
                
                if (ponderacionSeleccionada == null || ponderacionSeleccionada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione una ponderación válida.");
                    return;
                }

                Conexion conn = new Conexion();
                ArrayList<String[]> estudiantes = conn.obtenerEstudiantesPorCurso(id_curso);
                ArrayList<Double> notas = new ArrayList<>();
                String mensaje = "";
                String strnota;
                
                for (String[] estudiante : estudiantes) {
                    mensaje = ""; // Limpiar el mensaje para el próximo estudiante
                    for (String elemento : estudiante) {
                        mensaje += elemento + " ";
                    }
                    System.out.println("Estudiante: " + mensaje);
                    strnota = JOptionPane.showInputDialog(null, "Estudiante: "+ mensaje + "\nIngrese la nota:");
                    try {
                        double nota = Double.parseDouble(strnota);
                        notas.add(nota);
                        
                        System.out.println("desc" + ponderacionSeleccionada);
                        // Obtener los ids necesarios para la inserción
                        // // Ajusta según tu lógica para obtener el id inscrito
                        int ponderacionId = conn.obtenerIdPonderacion(ponderacionSeleccionada);
                        System.out.println(ponderacionId);
                        //int idEstudiante = conn.buscarEstudiantePorApellido(estudiante[0]);
                        //System.out.println(idEstudiante);
                        //int inscritoId = conn.obtenerIdInscrito(mensaje);
                        //System.out.println(inscritoId);
                        // Insertar la nota en la base de datos
                        //conn.insertarNota(nota, inscritoId, ponderacionId);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.");
                    }
                    
                }
                
                JOptionPane.showMessageDialog(null, "Notas agregadas correctamente");
                dispose();
                
            }
        });
        btnNewButton.setBounds(24, 107, 152, 21);
        contentPane.add(btnNewButton);

        // Llamar al método para llenar el JComboBox con las ponderaciones
        llenarComboBoxPonderaciones(comboBox, id_curso);
    }
    
    private void llenarComboBoxPonderaciones(JComboBox<String> comboBox, int idCurso) {
        Conexion conn = new Conexion();
        
        ArrayList<String> ponderaciones = conn.obtenerPonderacionDescripcion(idCurso);

        for (String ponderacion : ponderaciones) {
            comboBox.addItem(ponderacion);
        }
    }
}
