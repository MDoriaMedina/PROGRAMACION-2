package Practicas.Practica04.Ejercicio03.Modelo;

import java.text.DecimalFormat;

public class SimularTiradas {

	public int[] ArrayTiradas;
	
	public SimularTiradas(int lanzamientos, int dado) {
		//int numero = dado;
		ArrayTiradas = new int[lanzamientos];
	}
	
	public void Simular(int numero) {
		for(int i = 0;i<ArrayTiradas.length;i++) {
			ArrayTiradas[i]=(int)(Math.random()*numero)+1;
			//System.out.println(ArrayTiradas[i]);
		}
	}
	
	public String imprimirSimulacion() {
		String frase = "(";
		for(int i = 0;i<ArrayTiradas.length;i++) {
			frase+=ArrayTiradas[i]+", ";
		}
		return frase+=")";
	}
	
	public String promedio(int lanzamientos) {
		
		double res = 0, aux = 0;
		for(int i = 0;i<ArrayTiradas.length;i++) {
			res = res + ArrayTiradas[i];
		}
		aux = res / lanzamientos;
		DecimalFormat formato = new DecimalFormat("#.##");
		String mostrar = formato.format(aux);
		
		return mostrar;
	}
	
	public String caraMayor() {
		String mostrar = "";
		int caraMayor = 0;
		for(int i = 0;i<ArrayTiradas.length;i++) {
			if(ArrayTiradas[i]>caraMayor) {
				caraMayor = ArrayTiradas[i];
			}
		}
		mostrar = String.valueOf(caraMayor);
		return mostrar;
	}
	
	public String caraMenor() {
		String mostrar = "";
		int caraMenor = ArrayTiradas.length;
		for(int i = 0;i<ArrayTiradas.length;i++) {
			if(ArrayTiradas[i]<caraMenor) {
				caraMenor = ArrayTiradas[i];
			}
		}
		mostrar = String.valueOf(caraMenor);
		return mostrar;
	}
	
}

