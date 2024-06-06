package Modelo;

public class EstudianteRegular extends Estudiante{
	
	public String carnet;
	public String Departamento;

	public EstudianteRegular(String nombre, String fechaNacimiento, String carrera, String nacionalidad, String direccion, String carnet, String Departamento) {
		super(nombre,fechaNacimiento, carrera, nacionalidad, direccion);
		this.carnet = carnet;
		this.Departamento = Departamento;
	}
	
	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}
	
	@Override
	public void setFechaNacimiento(String fechaNacimiento) {
		// TODO Auto-generated method stub
		super.setFechaNacimiento(fechaNacimiento);
	}
	
	@Override
	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return super.getFechaNacimiento();
	}
	
	@Override
	public void setCarrera(String carrera) {
		// TODO Auto-generated method stub
		super.setCarrera(carrera);
	}
	
	@Override
	public String getCarrera() {
		// TODO Auto-generated method stub
		return super.getCarrera();
	}
	
	@Override
	public void setNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		super.setNacionalidad(nacionalidad);
	}
	
	@Override
	public String getNacionalidad() {
		// TODO Auto-generated method stub
		return super.getNacionalidad();
	}
	
	@Override
	public void setDireccion(String direccion) {
		// TODO Auto-generated method stub
		super.setDireccion(direccion);
	}
	
	@Override
	public String getDireccion() {
		// TODO Auto-generated method stub
		return super.getDireccion();
	}
	
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	
	public String getCarnet() {
		return carnet;
	}
	
	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}
	
	public String getDepartamento() {
		return Departamento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNombre() +"\t"+getCarnet()+"\t"+getFechaNacimiento()+"\t"+getNacionalidad()+"\t"+getDepartamento()+"\t"+getDireccion()+"\t"+getCarrera();
	}

}
