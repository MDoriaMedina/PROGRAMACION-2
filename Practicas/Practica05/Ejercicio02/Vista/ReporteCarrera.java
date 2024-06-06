package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.EstudianteExtranjero;
import Modelo.EstudianteRegular;
import Modelo.TodosEstudiantes;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;

public class ReporteCarrera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ReporteCarrera(ArrayList<EstudianteRegular> estReg, ArrayList<EstudianteExtranjero> estranjero) {
		setTitle("Reporte estudiantes por carrera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String [] carreras = {"PSICOLOGIA","ADMINISTRACION DE EMPRESAS","INGENIERIA DE SISTEMAS"};
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(459, 73, 17, 261);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("Seleccione una carrera:\r\n");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 19, 185, 21);
		contentPane.add(lblNewLabel);
		
		/*JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 71, 643, 254);
		contentPane.add(textArea);*/
		
		JButton btnNewButton = new JButton("Volver\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicioEstudiantes app = new VentanaInicioEstudiantes(estReg,estranjero);
				app.setVisible(true);
				app.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnNewButton.setBounds(355, 18, 121, 30);
		contentPane.add(btnNewButton);
		
		JTextArea textAreaFile = new JTextArea();
        textAreaFile.setBounds(12, 73, 465, 262);
        contentPane.add(textAreaFile);
		
		JComboBox<Object>comboBoxCarreras = new JComboBox<Object>(carreras);
		comboBoxCarreras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TodosEstudiantes> todosLista = new ArrayList();
				for (EstudianteRegular estudiante : estReg) {
		            TodosEstudiantes todos = new TodosEstudiantes(estudiante.getCarnet(),estudiante.getNombre(),estudiante.getCarrera());
		            todosLista.add(todos);
		        }
				
				for (EstudianteExtranjero extranjero : estranjero) {
		            TodosEstudiantes todos = new TodosEstudiantes(extranjero.getPasaporte(),extranjero.getNombre(),extranjero.getCarrera());
		            todosLista.add(todos);
		        }
				
				String [] carreras = {"PSICOLOGIA","ADMINISTRACION DE EMPRESAS","INGENIERIA DE SISTEMAS"};
				int valor = comboBoxCarreras.getSelectedIndex();
				
		        List<TodosEstudiantes> estudiantesFiltrados = new ArrayList<>();
		        for (TodosEstudiantes estudiante : todosLista) {
		            if (estudiante.getCarrera().equalsIgnoreCase(carreras[valor])) {
		                estudiantesFiltrados.add(estudiante);
		            }
		        }
				
				Collections.sort(todosLista, Comparator.comparing(TodosEstudiantes::toString));
				
				File archivo = new File ("D:/archivo.txt");
				//String rutaArchivo = "C:/ruta/a/tu/directorio/estudiantes_ordenados.txt";
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
		            for (TodosEstudiantes estudiante : todosLista) {
		                writer.write(estudiante.toString());
		                writer.newLine();
		            }
		            System.out.println("Archivo creado exitosamente");
		            //textAreaFile.setText(contenidoArchivo.toString());
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }

		        // Leer el archivo de texto y mostrarlo en un JFrame
		        StringBuilder contenidoArchivo = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        contenidoArchivo.append(linea).append("\n");
                    }
                    textAreaFile.setText(contenidoArchivo.toString());
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

		        /*JFrame frame = new JFrame("Estudiantes Ordenados");*/
		        /*JTextArea textArea = new JTextArea(contenidoArchivo.toString());
		        textArea.setEditable(false);
		        frame.add(new JScrollPane(textArea));
		        frame.setSize(600, 400);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);*/
				
			}
		});
		comboBoxCarreras.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		comboBoxCarreras.setBounds(207, 16, 107, 30);
		contentPane.add(comboBoxCarreras);
		
		
		
		
	}
}
