package Modelo;

public class EstudianteExtranjero extends Estudiante{
	
	public String idioma;
	public String pasaporte;
	
	public EstudianteExtranjero(String nombre, String fechaNacimiento, String carrera, String nacionalidad, String direccion, String idioma, String pasaporte) {
		super(nombre,fechaNacimiento, carrera, nacionalidad, direccion);
		this.idioma = idioma;
		this.pasaporte = pasaporte;
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
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	
	public String getPasaporte() {
		return pasaporte;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNombre() +"\t"+getPasaporte()+"\t"+getFechaNacimiento()+"\t"+getNacionalidad()+"\t"+getIdioma()+"\t"+getDireccion()+"\t"+getCarrera();
	}

}
