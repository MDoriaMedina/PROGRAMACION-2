package Laboratorios.Labo05;

public abstract class Empleado {
    public String nombre;
    public String apellido;
    public String carnet;

    public Empleado (String nombre, String apellido, String carnet){
          this.nombre = nombre;
          this.apellido = apellido;
          this.carnet = carnet;
    }

    public void setNombre(String nombre) {
          this.nombre = nombre;
    }

    public String getNombre() {
          return nombre;
    }

    public String getApellido() {
          return apellido;
    }

    public void setApellido(String apellido) {
          this.apellido = apellido;
    }

    public void setCarnet(String carnet) {
          this.carnet = carnet;
    }

    public String getCarnet() {
          return carnet;
    }

    public double calcularSalario (){
          return 0;
      }
  
}