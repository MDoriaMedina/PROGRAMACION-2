package Modelo;

public abstract class Persona {
	
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String nombres;
	public String telefono;
	public int birthYear;
	public int birthMonth;
	public int birthDay;
	public String residencia;
	public String nacionalidad;
	
	public Persona(String apellidoPaterno, String apellidoMaterno, String nombres, String telefono, int birthYear, int birthMonth, int birthDay, String residencia, String nacionalidad) {
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.telefono = telefono;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.residencia = residencia;
		this.nacionalidad = nacionalidad;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	
	public int getBirthMonth() {
		return birthMonth;
	}
	
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	
	public int getBirthDay() {
		return birthDay;
	}
	
	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	
	public String getResidencia() {
		return residencia;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
}
