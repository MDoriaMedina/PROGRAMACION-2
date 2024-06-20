package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.Conexion;
import Modelo.Ponderacion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaMateria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public boolean flag = false;
	public int i = 0, num = 0;
	public ArrayList<Ponderacion> ponderaciones = new ArrayList<>(); 

	public VentanaMateria(String materiaSeleccionada, int id_curso) {
		
		setTitle(materiaSeleccionada);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDefinirEvaluacion = new JButton("Definir Ponderación");
		if(materiaSeleccionada != "true") {
			btnDefinirEvaluacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try { 
						num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de ponderaciones"));
						flag = true;
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Debe ingresar solamente números enteros");
					}
					
					if(flag == true) {
						
							AddPonderacion ventana = new AddPonderacion(ponderaciones, num, id_curso);
							ventana.setVisible(true);
							ventana.setLocationRelativeTo(null);
							dispose();
							/*String desc = ventana.descripcion();
							Double val = ventana.valor();
							Ponderacion p = new Ponderacion(desc,val);
							ponderaciones.add(p);*/
						
						//JOptionPane.showMessageDialog(null, "Ponderaciones completas!");
					}
					
				}
			});
		}else {
			btnDefinirEvaluacion.setEnabled(false);
		}
		
		btnDefinirEvaluacion.setBounds(38, 32, 149, 21);
		contentPane.add(btnDefinirEvaluacion);
		
		JButton btnAgregarNotas = new JButton("Agregar Notas");
		btnAgregarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarNotas add = new AgregarNotas(id_curso);
				add.setVisible(true);
				add.setLocationRelativeTo(null);
			}
		});
		btnAgregarNotas.setBounds(38, 74, 149, 21);
		contentPane.add(btnAgregarNotas);
		
		JButton btnVerEstudiantes = new JButton("Lista estudiantes inscritos");
		btnVerEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEstudiantes lista = new ListaEstudiantes(id_curso);
				lista.setVisible(true);
				lista.setLocationRelativeTo(null);
			}
		});
		btnVerEstudiantes.setBounds(38, 115, 149, 21);
		contentPane.add(btnVerEstudiantes);
		
		JButton btnVerPonderacion = new JButton("Ver ponderacion");
		btnVerPonderacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarPonderacion mp = new MostrarPonderacion(ponderaciones,id_curso);
			}
		});
		btnVerPonderacion.setBounds(242, 32, 107, 21);
		contentPane.add(btnVerPonderacion);
	}
	
	
}
