package Modelo;

public class TodosEstudiantes {
	
	public String identifiacion;
	public String nombre;
	public String carrera;
	
	public TodosEstudiantes(String identificacion, String nombre, String carrera) {
		this.identifiacion = identificacion;
		this.nombre = nombre;
		this.carrera = carrera;
	}
	
	public void setIdentifiacion(String identifiacion) {
		this.identifiacion = identifiacion;
	}
	
	public String getIdentifiacion() {
		return identifiacion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getIdentifiacion()+"\t|"+getNombre()+"\t\t|"+getCarrera();
	}
	
    public int compareTo(TodosEstudiantes otroEstudiante) {
        return this.nombre.compareTo(otroEstudiante.getNombre());
    }

}
