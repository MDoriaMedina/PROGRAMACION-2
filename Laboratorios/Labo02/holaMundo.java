package Laboratorios.Labo02;

import java.util.Scanner;

public class holaMundo {
    public static void main(String[] args) {
        
        System.out.println("Hola Mundo"); //x: nos dice que deberia haber un argumento en esta funcion. Es una pequeÃ±a ayuda
        Scanner scanner = new Scanner(System.in);//crea el cin
        int num = scanner.nextInt(); //usando cin
        System.out.println("El numero: "+num);
        scanner.close();//cierra el scanner 

    }
}