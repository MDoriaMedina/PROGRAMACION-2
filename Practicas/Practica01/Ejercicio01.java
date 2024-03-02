package Practicas.Practica01;

import java.util.*;

public class Ejercicio01 {
    
    public static void main(String[] args) {
        
        int opcion;

        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1) Ingresa el texto\n2) Contar vocales\n3) Contar consonantes\n4) Encontrar una palabra en el texto\n5) Reemplazar una palabra por otra palabra\n6) Salir");
        do{
            System.out.println("---------------------------\nElija una opción: ");
            while (!scanner.hasNextInt()) { //verifica si el proximo valor de entrada es un entero
            System.out.println("Error. Elija una opción introduciendo un número del 1 al 6");
            scanner.next();
            }
            opcion = scanner.nextInt();

            //Validamos que el numero se encuentre entre una de las opciones del menu
            if (opcion < 1 || opcion > 6){
                System.out.println("Error. Elija una opción introduciendo un número del 1 al 6");
            }
        }while (opcion < 1 || opcion > 6);

        switch (opcion) {
            case 1:
                limpiarConsola();
                System.out.println("Eligio la opción nro: 1.\nIngrese el texto:");
                break;
            case 2:
                System.out.println("Eligio la opción nro: 2.\nContar vocales");
                break;
            case 3:
                System.out.println("Eligio la opción nro: 3.\nContar consonantes");
                break;
            case 4:
                System.out.println("Eligio la opción nro: 4.\nIntroduzca la palabra que desea encontrar en el texto:");
                break;
            case 5:
                System.out.println("Eligio la opción nro: 5.\nReemplazar una palabra por otra palabra");
                break;
            case 6:
                System.out.println("Hasta pronto!");
                break;
        }

    }

    public static void limpiarConsola(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}
