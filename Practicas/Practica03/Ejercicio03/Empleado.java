package Practicas.Practica03.Ejercicio03;

public class Empleado {
    public String nombre = "";
    public String cedula = "";
    public String dependencia = "";

    public Empleado(String nombre, String cedula, String dependencia){
        this.nombre = nombre;
        this.cedula = cedula;
        this.dependencia = dependencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public int calcularSalario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularSalario'");
    }
}
