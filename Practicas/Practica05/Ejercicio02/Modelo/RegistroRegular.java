package Modelo;

import java.util.ArrayList;

public class RegistroRegular {
	
	public String AgregarAlumno(ArrayList<EstudianteRegular> estReg, String nombre, String apellido, String carnet, int dia, int mes, int year, String nacionalidad, int departamento, int carrera, String direccion){
		
		EstudianteRegular agregado = new EstudianteRegular(null, null, null, null, null, null, null);
		
		String nombreCompleto = "";
		nombreCompleto += apellido;
		nombreCompleto += " "+nombre;
		
		String nacimiento = "";
		nacimiento = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(year);
		
		String [] departamentos = {"LA PAZ","COCHABAMBA","SANTA CRUZ", "ORURO", "POTOSI", "CHUQUISACA", "PANDO","BENI","TARIJA"};
		String [] carreras = {"PSICOLOGIA","ADMINISTRACION DE EMPRESAS","INGENIERIA DE SISTEMAS"};
		
		agregado.setNombre(nombreCompleto.toUpperCase());
		agregado.setCarnet(carnet.toUpperCase());
		agregado.setFechaNacimiento(nacimiento);
		agregado.setNacionalidad(nacionalidad.toUpperCase());
		agregado.setDepartamento(departamentos[departamento]);
		agregado.setDireccion(direccion.toUpperCase());
		agregado.setCarrera(carreras[carrera]);
		
		estReg.add(agregado);
		
		return agregado.toString();
	}
	
	public String DesplegarLista(ArrayList<EstudianteRegular> estReg) {
		StringBuilder desplegar = new StringBuilder();
		for (EstudianteRegular estudiante : estReg) {
            desplegar.append(estudiante).append("\n");
        }
        return desplegar.toString();
	}

}
