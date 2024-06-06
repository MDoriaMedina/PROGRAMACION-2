package Control;

import java.util.ArrayList;

import Modelo.EstudianteExtranjero;
import Modelo.EstudianteRegular;
import Vista.VentanaInicioEstudiantes;

public class Main {
	
	public static ArrayList<EstudianteRegular> estReg = new ArrayList<EstudianteRegular>();
	
	public static ArrayList<EstudianteExtranjero> Estranjero = new ArrayList<EstudianteExtranjero>();

	public static void main(String[] args) {
		
		VentanaInicioEstudiantes principal = new VentanaInicioEstudiantes(estReg,Estranjero);
		principal.setVisible(true);
		principal.setLocationRelativeTo(null);

	}

}
