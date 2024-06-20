package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Conexion;

public class ListaEstudiantes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 * @param id_curso 
	 */
	public ListaEstudiantes(int id_curso) {
		
		int id = id_curso;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 44, 445, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Estudiante", " "
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setPreferredWidth(155);
		scrollPane.setViewportView(table);
		
		JButton btnVOLVER = new JButton("VOLVER");
		btnVOLVER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVOLVER.setBounds(149, 298, 85, 21);
		contentPane.add(btnVOLVER);
		
		llenarTablaEstudiantes(id);
		
	}
	
	private void llenarTablaEstudiantes(int idCurso) {
        Conexion conn = new Conexion();
        ArrayList<String[]> estudiantes = conn.obtenerEstudiantesPorCurso(idCurso);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        for (String[] estudiante : estudiantes) {
        	//System.out.println(String.valueOf(estudiante));
            model.addRow(estudiante);
        }
    }
}
