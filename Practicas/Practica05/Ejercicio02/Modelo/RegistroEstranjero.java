package Modelo;

import java.util.ArrayList;

public class RegistroEstranjero {
	
	public String AgregarExtranjero(ArrayList<EstudianteExtranjero> estranjero, String nombre, String apellido, String pasaporte, int dia, int mes, int year, String nacionalidad,int carrera, String direccion, String idioma){
		
		EstudianteExtranjero nuevo = new EstudianteExtranjero(null, null, null, null, null, null, null);
		
		String nombreCompleto = "";
		nombreCompleto += apellido;
		nombreCompleto += " "+nombre;
		
		String nacimiento = "";
		nacimiento = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(year);
		
		
		String [] carreras = {"PSICOLOGIA","ADMINISTRACION DE EMPRESAS","INGENIERIA DE SISTEMAS"};
		
		nuevo.setNombre(nombreCompleto.toUpperCase());
		nuevo.setPasaporte(pasaporte.toUpperCase());
		nuevo.setFechaNacimiento(nacimiento);
		nuevo.setNacionalidad(nacionalidad.toUpperCase());
		nuevo.setDireccion(direccion.toUpperCase());
		nuevo.setCarrera(carreras[carrera]);
		nuevo.setIdioma(idioma);
		
		estranjero.add(nuevo);
		
		return nuevo.toString();
	}
	
	public String DesplegarListaExtranjero(ArrayList<EstudianteExtranjero> estranjero) {
		StringBuilder desplegar = new StringBuilder();
		for (EstudianteExtranjero extranjero : estranjero) {
            desplegar.append(extranjero).append("\n");
        }
        return desplegar.toString();
	}

	public void AgregarEstranjero(ArrayList<EstudianteExtranjero> estranjero, String text, String text2, String text3,
			int dia, int mes, int year, String text4, int selectedIndex, String text5) {
		// TODO Auto-generated method stub
		
	}

}
