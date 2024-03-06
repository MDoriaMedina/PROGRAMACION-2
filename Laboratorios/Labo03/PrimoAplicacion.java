package Laboratorios.Labo03;

import java.util.*;

public class PrimoAplicacion {
    
    public static void main(String[] args) {
        
        int a = 0;
        Scanner cin = new Scanner(System.in);

        System.out.print("Ingrese el numero: ");
        a = cin.nextInt();

        Primo numeroPrimo = new Primo();

        numeroPrimo.calcPrimo(a);

        cin.close();
    }
}
