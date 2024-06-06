package Vista;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.GridLayout;

public class SeleccionEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public int SeleccionEstudiante(int opcion) {
		
		//int res = 0;
		setLayout(null);
		
		JRadioButton RadioBtnRegular = new JRadioButton("Regular");
		RadioBtnRegular.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		RadioBtnRegular.setBounds(32, 36, 103, 21);
		add(RadioBtnRegular);
		
		JRadioButton RadioBtnEstranjero = new JRadioButton("Estranjero");
		RadioBtnEstranjero.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		RadioBtnEstranjero.setBounds(164, 37, 103, 21);
		add(RadioBtnEstranjero);
		
		ButtonGroup btnEstudiante = new ButtonGroup();
		btnEstudiante.add(RadioBtnRegular);
		btnEstudiante.add(RadioBtnEstranjero);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
        panel.add(RadioBtnRegular);
        panel.add(RadioBtnEstranjero);
		
		opcion = JOptionPane.showConfirmDialog(null,panel,"Seleccione una opcion: ",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (opcion == JOptionPane.OK_OPTION) {
            if (RadioBtnRegular.isSelected()) {
                //System.out.println("Opción 1 seleccionada");
                opcion = 1;
                return opcion;
            } else if (RadioBtnEstranjero.isSelected()) {
                //System.out.println("Opción 2 seleccionada");
                opcion = 2;
                return opcion;
            } else {
                //System.out.println("Ninguna opción seleccionada");
                opcion = 0;
                return opcion;
            }	
            
        } else {
            System.out.println("Diálogo cancelado");
            opcion = 0;
            return opcion;
        }
		
	}
}
