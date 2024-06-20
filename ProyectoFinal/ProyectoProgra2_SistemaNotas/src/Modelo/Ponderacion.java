package Modelo;

public class Ponderacion {

	public String descripcion;
	public double valor;
	
	public Ponderacion(String descripcion, double valor) {
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
