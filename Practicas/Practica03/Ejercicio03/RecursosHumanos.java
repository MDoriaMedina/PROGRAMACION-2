package Practicas.Practica03.Ejercicio03;

public class RecursosHumanos extends Administrativo {
    private boolean esTesoreria;

    public RecursosHumanos(String nombre, String cedula, String dependencia, boolean esTesoreria){
        super(nombre, cedula, dependencia);
        this.esTesoreria = esTesoreria;
    }

    public int calcularSalario(){
        
        int salarioBase = super.calcularSalario();
        if(esTesoreria){
            salarioBase += 1000;

        }else{
            salarioBase += 700;
        }
        return salarioBase;
    }
}