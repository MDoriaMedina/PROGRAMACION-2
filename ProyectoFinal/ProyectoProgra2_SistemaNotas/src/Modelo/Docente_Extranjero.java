package Modelo;

public class Docente_Extranjero extends Docente{
	
	public String pasaporte;
	public String idioma;

	public Docente_Extranjero(String apellidoPaterno, String apellidoMaterno, String nombres, String telefono, int birthYear, int birthMonth, int birthDay, String residencia, String nacionalidad, String pasaporte, String idioma) {
		super(apellidoPaterno, apellidoMaterno, nombres, telefono, birthYear, birthMonth, birthDay, residencia, nacionalidad);
		this.pasaporte = pasaporte;
		this.idioma = idioma;
	}
	
	@Override
	public void setApellidoPaterno(String apellidoPaterno) {
		// TODO Auto-generated method stub
		super.setApellidoPaterno(apellidoPaterno);
	}
	
	@Override
	public String getApellidoPaterno() {
		// TODO Auto-generated method stub
		return super.getApellidoPaterno();
	}
	
	@Override
	public void setApellidoMaterno(String apellidoMaterno) {
		// TODO Auto-generated method stub
		super.setApellidoMaterno(apellidoMaterno);
	}
	
	@Override
	public String getApellidoMaterno() {
		// TODO Auto-generated method stub
		return super.getApellidoMaterno();
	}
	
	@Override
	public void setNombres(String nombres) {
		// TODO Auto-generated method stub
		super.setNombres(nombres);
	}
	
	@Override
	public String getNombres() {
		// TODO Auto-generated method stub
		return super.getNombres();
	}
	
	@Override
	public void setTelefono(String telefono) {
		// TODO Auto-generated method stub
		super.setTelefono(telefono);
	}
	
	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub
		return super.getTelefono();
	}
	
	@Override
	public void setBirthDay(int birthDay) {
		// TODO Auto-generated method stub
		super.setBirthDay(birthDay);
	}
	
	@Override
	public int getBirthDay() {
		// TODO Auto-generated method stub
		return super.getBirthDay();
	}
	
	@Override
	public void setBirthMonth(int birthMonth) {
		// TODO Auto-generated method stub
		super.setBirthMonth(birthMonth);
	}
	
	@Override
	public int getBirthMonth() {
		// TODO Auto-generated method stub
		return super.getBirthMonth();
	}
	
	@Override
	public void setBirthYear(int birthYear) {
		// TODO Auto-generated method stub
		super.setBirthYear(birthYear);
	}
	
	@Override
	public int getBirthYear() {
		// TODO Auto-generated method stub
		return super.getBirthYear();
	}
	
	@Override
	public void setResidencia(String residencia) {
		// TODO Auto-generated method stub
		super.setResidencia(residencia);
	}
	
	@Override
	public String getResidencia() {
		// TODO Auto-generated method stub
		return super.getResidencia();
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
	
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	
	public String getPasaporte() {
		return pasaporte;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	@Override
	public String toString() {
		return apellidoPaterno + "\n" + apellidoMaterno + "\n" + nombres + "\n" + pasaporte + "\n" + birthDay + "/" + birthMonth + "/" + birthYear + "\n" + telefono + "\n" + residencia + "\n" + nacionalidad + "\n" + idioma;
	}

	
}
