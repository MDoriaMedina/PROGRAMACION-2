package Practicas.Practica04.Ejercicio01.Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCorreos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textDominios;

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
		
		textField = new JTextField();
		textField.setBounds(106, 87, 194, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrear.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCrear.setBounds(317, 90, 85, 21);
		contentPane.add(btnCrear);
		
		textDominios = new JTextField();
		textDominios.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		textDominios.setBounds(86, 139, 242, 101);
		contentPane.add(textDominios);
		textDominios.setColumns(10);
	}
}

