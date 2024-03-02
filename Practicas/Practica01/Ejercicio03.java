package Practicas.Practica01;

import java.util.*;

//Ejercicio 3. Verifica si dos numeros son amigos

public class Ejercicio03 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int a, b, suma1, suma2; //Definimos variables

        System.out.println("Ingrese dos números y se verificará si son amigos");
        while (!scanner.hasNextInt()) { //verifica si el proximo valor de entrada es un entero
            System.out.println("Debe introducir valores numericos. Inténtelo de nuevo:");
            scanner.next(); // Limpia el buffer de entrada antes de volver a pedir la entrada
        }
        a = scanner.nextInt();
        while (!scanner.hasNextInt()) { 
            System.out.println("Debe introducir valores numericos. Inténtelo de nuevo:");
            scanner.next(); 
        }
        b = scanner.nextInt();
        System.out.println("Los numeros son: "+ a +" y "+ b);
        suma1 = divisor(a);
        suma2 = divisor(b);
        System.out.println("El valor de suma de divisores del primer numero es: "+suma1);
        System.out.println("El valor de suma de divisores del segundo numero es: "+suma2);
        if(a==suma2 && b==suma1){
            System.out.println("Son numeros amigos");
        }else{
            System.out.println("No son numeros amigos");
        }
    }

    //Funcion para calcular la suma de divisores de los numeros
    static int divisor (int num){
         
        int suma = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                suma += i;
            }
        }
        return suma;
    }

}
