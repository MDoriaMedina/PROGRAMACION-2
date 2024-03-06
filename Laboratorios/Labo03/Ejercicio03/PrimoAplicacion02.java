package Laboratorios.Labo03.Ejercicio03;

import java.util.*;

public class PrimoAplicacion02 {
    
    public static void main(String[] args) {
        
        int a = 0;
        Scanner cin = new Scanner(System.in);

        System.out.print("Ingrese el numero: ");
        a = cin.nextInt();

        Primo02 numeroPrimo = new Primo02(a);
        
        numeroPrimo.calcPrimo();

        cin.close();
    }

}


