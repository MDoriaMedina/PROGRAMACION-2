package Practicas.Practica03.Ejercicio03;

public class ProfesorHoraCatedra extends Docente{
    
    public int horasAsignadas = 0;

    public ProfesorHoraCatedra(String nombre, String cedula, String dependencia, double calificacionAsignada, int salario, int horasAsignadas){
        super(nombre, cedula, dependencia, calificacionAsignada, salario);
        this.horasAsignadas = horasAsignadas;
    }

    public int calcularSalario(){
        salario += horasAsignadas * 50;
        return salario;
    }

    public int getHorasAsignadas(){
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horasAsignadas){
        this.horasAsignadas = horasAsignadas;
    }
}