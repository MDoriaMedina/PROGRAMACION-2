package Modelo;

public abstract class Estudiante {
	
	public String nombre;
	public String fechaNacimiento;
	public String carrera;
	public String nacionalidad;
	public String direccion;
	
	public Estudiante(String nombre, String fechaNacimiento, String carrera, String nacionalidad, String direccion) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.carrera = carrera;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
