package Laboratorios.Labo03;

import java.util.*;

public class cambioAplicacion {
    
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);

        double montoCambiar = 0;
        System.out.println("Ingrese el monto en bolivianos:");
        montoCambiar = cin.nextInt();

        calculadoraCambio dolares = new calculadoraCambio();

        double res1 = dolares.cambioOficial(montoCambiar);
        System.out.println("El cambio en oficial (6.96) es: "+ res1+" dolares");
        
        double res2 = dolares.cambioParalelo(montoCambiar);
        System.out.println("El cambio en paralelo (8.5) es: "+ res2+" dolares");

        cin.close();
    }
}

