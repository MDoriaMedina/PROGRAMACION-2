import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Practicas.Practica04.Ejercicio01.Modelo.ControlCorreos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class VentanaCorreos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCorreo;
	public String verificar = "";

	ControlCorreos control = new ControlCorreos();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCorreos frame = new VentanaCorreos();
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
	public VentanaCorreos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreadorCorreos = new JLabel("CREADOR DE CORREOS");
		lblCreadorCorreos.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblCreadorCorreos.setBounds(117, 34, 194, 21);
		contentPane.add(lblCreadorCorreos);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblCorreo.setBounds(38, 92, 66, 13);
		contentPane.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textCorreo.setBounds(106, 87, 194, 27);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificar = textCorreo.getText();
				if(verificar.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un correo!");
				}else {
					control.verificarCorreo(verificar);
				}
			}
		});
		btnCrear.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCrear.setBounds(310, 87, 89, 27);
		contentPane.add(btnCrear);
		
		JTextArea textAreaDominios = new JTextArea();
		textAreaDominios.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textAreaDominios.setBounds(106, 136, 237, 117);
		contentPane.add(textAreaDominios);
	}
}
