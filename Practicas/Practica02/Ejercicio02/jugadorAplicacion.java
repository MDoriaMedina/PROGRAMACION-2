package Practicas.Practica02.Ejercicio02;

import java.util.*;

public class jugadorAplicacion {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numeroJugadores = 0, numeroPolera = 0, tarjetaAmarilla = 0, tarjetaRoja = 0, goles = 0, partidosJugados = 0, expulsion = 0; 
        System.out.println("Cuantos jugadores desea ingresar?");
        numeroJugadores = sc.nextInt();

        jugador[] jugadores = new jugador[numeroJugadores];
        
        for(int i = 0; i < numeroJugadores; i++){
            System.out.print("Ingrese el numero del jugador");
            numeroPolera = sc.nextInt();
            System.out.print("Ingrese el numero de tarjetas amarillas que tiene: ");
            tarjetaAmarilla = sc.nextInt();
            System.out.print("Ingrese el numero de tarjetas rojass que tiene: ");
            tarjetaRoja = sc.nextInt();
            System.out.print("Ingrese el numero de goles que ha anotado: ");
            goles = sc.nextInt();
            System.out.print("Ingrese el numero de partidos jugados: ");
            partidosJugados = sc.nextInt();

            //Instanciamos
            jugadores [i] = new jugador(numeroPolera, tarjetaAmarilla, tarjetaRoja, goles, partidosJugados);
        }
        jugador jugadorConMasTarjetasRojas = jugadorExpulsiones(jugadores);

        // Imprimir la información del jugador con más tarjetas rojas
        System.out.println("Jugador con más expulsiones: " + jugadorConMasTarjetasRojas);
        
    }

    
    
    



}
