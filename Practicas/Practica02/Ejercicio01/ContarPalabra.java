//Ej1. Contar letras y su total. Clase aplicación 

package Practicas.Practica02.Ejercicio01;

import java.util.*;

public class ContarPalabra {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String palabraIngresada = "";

        System.out.println("Ingrese la palabra: ");
        palabraIngresada = sc.nextLine();

        //Instanciar clase Palabra
        Palabra aContar = new Palabra(palabraIngresada);
        aContar.aMayuscula();
        String nuevaPalabra = aContar.getPalabra();
        System.out.println("Palabra ingresada : " + nuevaPalabra);
        aContar.letras();
        sc.close();
    }
}
