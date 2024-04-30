package Practicas.Practica03.Ejercicio03;

public class Administrativo extends Empleado{
    public Administrativo(String nombre, String cedula, String dependencia){
        
        super(nombre, cedula, dependencia);
    }

    public int calcularSalario(){
        return 5000;
    }
}
