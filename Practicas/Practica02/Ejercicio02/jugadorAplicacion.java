package Practicas.Practica02.Ejercicio02;

import java.util.*;

public class jugadorAplicacion {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numeroJugadores = 0; 
        System.out.println("Cuantos jugadores desea ingresar?");
        numeroJugadores = sc.nextInt();

        jugador[] jugadores = new jugador[numeroJugadores];
        
        jugador.datosJugadores(numeroJugadores);


    }
    
    



}
