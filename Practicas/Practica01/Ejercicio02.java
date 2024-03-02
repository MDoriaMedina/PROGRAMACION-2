package Practicas.Practica01;

//Ejercicio 2. Ayuda a Microsoft para mejorar su algoritmo de contar palabras en Word

import java.util.Scanner;

public class Ejercicio02 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un texto:");
        String texto = scanner.nextLine();

        System.out.println("El texto es:"+ texto);
        int numeroPalabras = contarPalabras(texto);

        System.out.println("Número de palabras en el texto: " + numeroPalabras);
        scanner.close();
    }

    //funcion para contar palabras
    private static int contarPalabras(String texto){
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        
        String[] palabras = texto.split("\\W+"); // Dividir el texto en palabras utilizando espacios en blanco como delimitadores
        //La  expresion "\\s+" separa las palabras por espacios para poder ser contadas 
        
        return palabras.length; //Se retorna el valor de longitud de las palabras al ser separadas
        
    }
    
}
