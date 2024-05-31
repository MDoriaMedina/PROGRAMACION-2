package Practicas.Practica04.Ejercicio03.Vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Practicas.Practica04.Ejercicio03.Modelo.SimularTiradas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLanzamiento;
	public int seleccion = 0;
	private JTextField Promedio;
	private JTextField Mayor;
	private JTextField Menor;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Programa Simulador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIMULADOR DE DADO");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setBounds(133, 31, 222, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblSeleccionDado = new JLabel("Seleccione la opcion de dado:");
		lblSeleccionDado.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblSeleccionDado.setBounds(35, 93, 222, 18);
		contentPane.add(lblSeleccionDado);
		
		JRadioButton rdbtn6caras = new JRadioButton("6 caras");
		rdbtn6caras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion = 6;
			}
		});
		rdbtn6caras.setBackground(Color.LIGHT_GRAY);
		rdbtn6caras.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtn6caras.setBounds(263, 92, 92, 21);
		contentPane.add(rdbtn6caras);
		
		JRadioButton rdbtn8caras = new JRadioButton("8 caras");
		rdbtn8caras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccion = 8;
			}
		});
		rdbtn8caras.setBackground(Color.LIGHT_GRAY);
		rdbtn8caras.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rdbtn8caras.setBounds(354, 92, 114, 21);
		contentPane.add(rdbtn8caras);
		
		ButtonGroup seleccionOpcion = new ButtonGroup();
		seleccionOpcion.add(rdbtn8caras);
		seleccionOpcion.add(rdbtn6caras);
		
		JLabel lblLanzamiento = new JLabel("Lanzamientos: ");
		lblLanzamiento.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblLanzamiento.setBackground(Color.LIGHT_GRAY);
		lblLanzamiento.setBounds(35, 134, 140, 28);
		contentPane.add(lblLanzamiento);
		
		textFieldLanzamiento = new JTextField();
		textFieldLanzamiento.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textFieldLanzamiento.setBounds(156, 135, 146, 28);
		contentPane.add(textFieldLanzamiento);
		textFieldLanzamiento.setColumns(10);
		
		JTextArea txtrAquiSeSimula = new JTextArea();
		txtrAquiSeSimula.setText("Aqui se simula el dado...");
		txtrAquiSeSimula.setBounds(35, 183, 203, 91);
		contentPane.add(txtrAquiSeSimula);
		
		JButton btnSimular = new JButton("SIMULAR");
		btnSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    if(seleccion == 0) {
						JOptionPane.showMessageDialog(null, "Debes seleccionar un tipo de dado!");
					}else {
						System.out.println(seleccion);
					    int tiradas = Integer.parseInt(textFieldLanzamiento.getText());
					    SimularTiradas prueba = new SimularTiradas(tiradas,seleccion);
					    prueba.Simular(seleccion);
					    String imprimir = prueba.imprimirSimulacion();
					    txtrAquiSeSimula.setText(imprimir);
					    String promedio = prueba.promedio(tiradas);
					    Promedio.setText(promedio);
					    String caraMayor = prueba.caraMayor();
					    Mayor.setText(caraMayor);
					    String caraMenor = prueba.caraMenor();
					    Menor.setText(caraMenor);
					}
					
				}catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Debes introducir un número válido!");
				}
			}
		});
		
		btnSimular.setBackground(Color.GRAY);
		btnSimular.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnSimular.setBounds(326, 134, 130, 28);
		contentPane.add(btnSimular);
		
		JLabel lblPromedio = new JLabel("Promedio: ");
		lblPromedio.setBackground(Color.LIGHT_GRAY);
		lblPromedio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPromedio.setBounds(257, 189, 114, 13);
		contentPane.add(lblPromedio);
		
		JLabel lblCaraMayor = new JLabel("Cara mayor:");
		lblCaraMayor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaraMayor.setBackground(Color.LIGHT_GRAY);
		lblCaraMayor.setBounds(257, 225, 114, 13);
		contentPane.add(lblCaraMayor);
		
		JLabel lblCaraMenor = new JLabel("Cara menor:");
		lblCaraMenor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaraMenor.setBackground(Color.LIGHT_GRAY);
		lblCaraMenor.setBounds(257, 261, 114, 13);
		contentPane.add(lblCaraMenor);
		
		Promedio = new JTextField();
		Promedio.setBackground(Color.LIGHT_GRAY);
		Promedio.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		Promedio.setBounds(368, 177, 100, 28);
		contentPane.add(Promedio);
		Promedio.setColumns(10);
		
		Mayor = new JTextField();
		Mayor.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		Mayor.setColumns(10);
		Mayor.setBackground(Color.LIGHT_GRAY);
		Mayor.setBounds(368, 212, 100, 28);
		contentPane.add(Mayor);
		
		Menor = new JTextField();
		Menor.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		Menor.setColumns(10);
		Menor.setBackground(Color.LIGHT_GRAY);
		Menor.setBounds(368, 248, 100, 28);
		contentPane.add(Menor);
		
		/*JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Michelle\\Downloads\\dado8.jpg"));
		lblNewLabel_1.setBounds(365, 23, 69, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Michelle\\Downloads\\Captura de pantalla 2024-05-29 202131.jpg"));
		lblNewLabel_2.setBounds(35, 22, 69, 62);
		contentPane.add(lblNewLabel_2);*/
		
		
	}
}

