package Practicas.Practica03.Ejercicio03;

public class Docente extends Empleado {
    public double calificacionAsignada = 0.0;
    public int salario = 0;

    public Docente(String nombre, String cedula, String dependencia, double calificacionAsignada, int salario){
        super(nombre, cedula, dependencia);
        this.calificacionAsignada = calificacionAsignada;
        this.salario = salario;
    }

    public int calcularSalario() {
        if (calificacionAsignada >= 4.5) {
            salario += 2000;
        }
        return salario;
    }

    public double getCalificacionAsignada() {
        return calificacionAsignada;
    }

    public void setCalificacionAsignada(double calificacionAsignada) {
        this.calificacionAsignada = calificacionAsignada;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
