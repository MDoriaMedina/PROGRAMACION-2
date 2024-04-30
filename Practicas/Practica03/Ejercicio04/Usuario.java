package Practicas.Practica03.Ejercicio04;

public class Usuario {
    
    public String nombre;
    public String apellido;
    public String CI;
    public String direccion;

    public Usuario (String nombre, String apellido, String CI, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.CI = CI;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setCI(String cI) {
        CI = cI;
    }

    public String getCI() {
        return CI;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    
}
