package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public VentanaEstudiante(int id_usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido estudiante, selecciona una materia:");
		lblNewLabel.setBounds(26, 22, 277, 26);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(22, 58, 365, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Notas:");
		lblNewLabel_1.setBounds(22, 100, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 123, 361, 133);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Evaluacion", "Ponderacion", "Nota"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnLoadData = new JButton("Cargar Notas");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTabla();
			}
		});
		btnLoadData.setBounds(26, 266, 150, 21);
		contentPane.add(btnLoadData);
		
		// Añade las materias al comboBox (esto es solo un ejemplo, puedes obtener las materias de tu base de datos)
		comboBox.addItem("Materia 1");
		comboBox.addItem("Materia 2");
		comboBox.addItem("Materia 3");
	}
	
	private void llenarTabla() {
		// Listas de datos
        ArrayList<String> evaluaciones = new ArrayList<>(Arrays.asList(
            "Examen Parcial 1", "Proyecto 1", "Examen Parcial 2", "Proyecto 2"
        ));
        ArrayList<Integer> ponderaciones = new ArrayList<>(Arrays.asList(25, 25, 25, 25));
        ArrayList<Integer> notas = new ArrayList<>(Arrays.asList(75, 90, 20, 80));

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        // Llenar la tabla con los datos
        for (int i = 0; i < evaluaciones.size(); i++) {
            String evaluacion = evaluaciones.get(i);
            int ponderacion = ponderaciones.get(i);
            int nota = notas.get(i);

            model.addRow(new Object[]{evaluacion, ponderacion, nota});
        }
	}
}
