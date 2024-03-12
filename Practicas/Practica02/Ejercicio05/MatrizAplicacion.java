package Practicas.Practica02.Ejercicio05;

import java.util.*;

public class MatrizAplicacion {
    
    public static void main(String[] args) {
        
        int tamaño = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la matriz: ");
        tamaño = sc.nextInt();
        Matriz carita = new Matriz(tamaño);
        carita.generarMatriz();
        sc.close();
    }

}
