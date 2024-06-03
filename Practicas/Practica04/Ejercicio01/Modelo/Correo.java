package Practicas.Practica04.Ejercicio01.Modelo;

import java.util.ArrayList;

public class Correo {

	public String nombreDominio;
	public int cantidad;
	
	public Correo (String nombreDominio) {
		this.nombreDominio = nombreDominio;
		this.cantidad = 1;
	}

	public void setNombreDominio(String nombreDominio) {
		this.nombreDominio = nombreDominio;
	}
	
	public String getNombreDominio() {
		return nombreDominio;
	}
	
	public void setCantidad() {
		cantidad++;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String toString() {
		return nombreDominio +": "+cantidad+"\n";
	}
}
