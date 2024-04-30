package Practicas.Practica03.Ejercicio03;

import java.util.ArrayList;

public class Mantenimiento extends Administrativo{
    private ArrayList<String> bloquesAsignados;
    private int horasExtra;

    public Mantenimiento(String nombre, String cedula, String dependencia, ArrayList<String> bloquesAsignados, int horasExtra){
        super(nombre, cedula, dependencia);
        this.bloquesAsignados = bloquesAsignados;
        this.horasExtra = horasExtra;
    }

    public int calcularSalario(){
        int salarioBase = super.calcularSalario();
        int salarioTotal = salarioBase + (horasExtra * 40);
        return salarioTotal;
    }
}
