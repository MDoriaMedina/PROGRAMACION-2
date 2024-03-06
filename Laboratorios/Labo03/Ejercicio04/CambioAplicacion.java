package Laboratorios.Labo03.Ejercicio04;

import java.util.*;

public class CambioAplicacion {
    
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);

        double montoCambiar = 0;
        System.out.println("Ingrese el monto en bolivianos:");
        montoCambiar = cin.nextInt();

        Cambio dinero = new Cambio(montoCambiar);

        double res1 = dinero.cambioOficial();
        System.out.println("El cambio en oficial (6.96 bs el dolar) es: "+ res1 +" dolares");
        
        double res2 = dinero.cambioParaleloBarato();
        System.out.println("El cambio en paralelo barato (8.5 bs el dolar) es: "+ res2 +" dolares");

        double res3 = dinero.cambioParaleloCaro();
        System.out.println("El cambio en paralelo caro (9.97 bs el dolar) es: "+ res3 +" dolares");

        double res4 = dinero.cambioEuros();
        System.out.println("El cambio en euros (7.50 bs el euro) es: "+ res4 +" euros");

        cin.close();
    }

}
