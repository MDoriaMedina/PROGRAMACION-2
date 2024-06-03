package Practicas.Practica04.Ejercicio01.Modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControlCorreos {
	
	static ArrayList<Correo> dominios = new ArrayList<>();

	public void verificarCorreo(String correo) {
		
		int puntosAntesArroba = 0;
		int puntosDespuesArroba = 0;
		int posicionArroba = 0;
		int posicionPunto = 0;
		String dom = "";
		int n = 0;
		
		for (int i=0; i<correo.length(); i++) {
			char caracter = correo.charAt(i);
			
			if (caracter == ' ') {
				JOptionPane.showMessageDialog(null, "Correo inválido. No debe tener espacios");
				break;
			}
			
			if (i == 0 && caracter == '.') {
				JOptionPane.showMessageDialog(null, "Correo inválido. No puede empezar con punto");
				break;
			}
			
			if(caracter == '@' && correo.charAt(i-1)=='.') {
				JOptionPane.showMessageDialog(null, "Correo inválido. No puede terminar con punto antes de arroba");
				break;
			}
			
			if(caracter == '.' && correo.charAt(i-1) == '.') {
				JOptionPane.showMessageDialog(null, "Correo inválido. No pueden haber dos puntos seguidos");
				break;
			}
			
			if(caracter ==  '@') {
				posicionArroba = i;
				//System.out.println("posicion arroba: " + i);
			}
			
			if(caracter == '.' && posicionArroba != 0) {
				puntosDespuesArroba ++;
				posicionPunto = i;
			}
		}
		
		//System.out.println(correo.charAt(posicionArroba));
		
		if(posicionArroba == 0) {
			JOptionPane.showMessageDialog(null, "Correo inválido. Debe contener arroba");
		}else {
			dom = leerDominio(correo,posicionArroba,puntosDespuesArroba, posicionPunto);
			Correo dominioAgregado = new Correo(dom);
			agregarDominio(dominios, dom);
			desplegarDominios(dominios);
		}
		
		//System.out.println(correo);
		
	}
	
	public void desplegarDominios(ArrayList<Correo> dominios2) {
		for (Correo n : dominios2) {
			System.out.print(n.toString());
		}
		System.out.println();
		
	}

	//SUBSTRING
	public String leerDominio(String correo, int posArroba, int puntosDespuesArroba2, int posPunto) {
		String domFinal = "";
		
		if(puntosDespuesArroba2 > 1) {
			domFinal = correo.substring(posArroba + 1);
		}else {
			domFinal = correo.substring(posArroba + 1,posPunto);
		}
		return domFinal;
	}
	
	public static void agregarDominio(ArrayList<Correo> dominios2, String dom2) {
		int control = 0;
		for (Correo n : dominios2) {
			if(n.getNombreDominio().equals(dom2)) {
				n.setCantidad();
				control++;
			}
		}
		if(control == 0) {
			dominios2.add(new Correo(dom2));
		}
	}
	
}
