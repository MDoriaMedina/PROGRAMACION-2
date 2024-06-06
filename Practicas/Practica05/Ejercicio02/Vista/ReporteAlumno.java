package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.EstudianteExtranjero;
import Modelo.EstudianteRegular;
import Modelo.TodosEstudiantes;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReporteAlumno(ArrayList<EstudianteRegular> estReg, ArrayList<EstudianteExtranjero> estranjero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	VentanaInicioEstudiantes ventanaInicio = new VentanaInicioEstudiantes(estReg,estranjero);
                ventanaInicio.setVisible(true);
                ventanaInicio.setLocationRelativeTo(null);
                //dispose();
            }
        });

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<TodosEstudiantes> model = new DefaultListModel<>();
		
		ArrayList<TodosEstudiantes> todosLista = new ArrayList();
		for (EstudianteRegular estudiante : estReg) {
            TodosEstudiantes todos = new TodosEstudiantes(estudiante.getCarnet(),estudiante.getNombre(),estudiante.getCarrera());
            todosLista.add(todos);
        }
		
		for (EstudianteExtranjero extranjero : estranjero) {
            TodosEstudiantes todos = new TodosEstudiantes(extranjero.getPasaporte(),extranjero.getNombre(),extranjero.getCarrera());
            todosLista.add(todos);
        }
		
		Collections.sort(todosLista, Comparator.comparing(TodosEstudiantes::toString));

        // Agregar elementos de todosLista al modelo
        for (TodosEstudiantes estudiante : todosLista) {
            model.addElement(estudiante);
        }

        // Crear el JList con el modelo
        JList<TodosEstudiantes> list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBounds(10, 10, 450, 207);
        contentPane.add(list);

        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Obtener el objeto seleccionado en el JList
                TodosEstudiantes estudianteSeleccionado = list.getSelectedValue();
                if (estudianteSeleccionado != null) {
                    // Obtener el valor de identificación del objeto seleccionado
                    String identificacion = estudianteSeleccionado.getIdentifiacion(); // Suponiendo que 'getCarnet()' devuelve la identificación
                    System.out.println("Identificación seleccionada: " + identificacion);
                } else {
                    System.out.println("Ningún estudiante seleccionado");
                }
        	}
        });
        btnAceptar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        btnAceptar.setBounds(70, 229, 126, 21);
        contentPane.add(btnAceptar);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaInicioEstudiantes ventanaInicio = new VentanaInicioEstudiantes(estReg,estranjero);
                ventanaInicio.setVisible(true);
                ventanaInicio.setLocationRelativeTo(null);
                dispose();
        	}
        });
        btnVolver.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        btnVolver.setBounds(279, 230, 126, 21);
        contentPane.add(btnVolver);
	}
}
