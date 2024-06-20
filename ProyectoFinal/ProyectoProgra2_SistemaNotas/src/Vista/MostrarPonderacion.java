package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modelo.Conexion;
import Modelo.Ponderacion;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarPonderacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    public MostrarPonderacion(ArrayList<Ponderacion> ponderaciones, int id_curso) {
        int id = id_curso;
        setTitle("Ponderaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 234);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 43, 387, 103);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Descripcion", "Ponderación"}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(155);
        scrollPane.setViewportView(table);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(171, 166, 85, 21);
        contentPane.add(btnAceptar);

        JLabel lblNewLabel = new JLabel("Lista de ponderaciones");
        lblNewLabel.setBounds(23, 10, 162, 13);
        contentPane.add(lblNewLabel);

        // Llamar al método para llenar la tabla
        llenarTablaPonderaciones(id);
    }

    private void llenarTablaPonderaciones(int idCurso) {
    	
    	Conexion conn = new Conexion();
	    ArrayList<Ponderacion> ponderaciones = conn.obtenerPonderaciones(idCurso);

	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

	    for (Ponderacion ponderacion : ponderaciones) {
	        String[] row = {
	            ponderacion.getDescripcion(),
	            //String.valueOf(ponderacion.getPorcentaje())
	        };
	        model.addRow(row);
	    }
	}
}
