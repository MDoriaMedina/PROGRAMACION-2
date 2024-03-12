package Practicas.Practica02.Ejercicio03;

import java.util.*;

public class EmpleadoAplicacion {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String nombreEmp = "", horaIngreso = "", horaSalida = "";
        Double ingresoMensual = 0.00;
        System.out.println("Ingrese los datos del empleado que se pidan a continuación...");
        System.out.print("Nombre del empleado: ");
        nombreEmp = sc.nextLine();
        System.out.print("Ingreso mensual: ");
        ingresoMensual = sc.nextDouble();
        sc.nextLine();
        System.out.print("Indique la hora de ingreso en el formato: 00:00 am: ");
        horaIngreso = sc.nextLine();
        System.out.print("Indique la hora de ingreso en el formato: 00:00 pm: ");
        horaSalida = sc.nextLine();
        Empleado empleado1 = new Empleado(nombreEmp, ingresoMensual, horaIngreso, horaSalida);
        System.out.println("La hora de entrada es: " + empleado1.getHoraEntrada());
        /*Prueba de salida de datos */
        /*System.out.println("Funciona: " + empleado1.horarioEntrada());
        System.out.println("Funciona: " + empleado1.horarioSalida());*/
        System.out.println("El ingreso del empleado es: " + empleado1.calculoIngreso());
    }
}
