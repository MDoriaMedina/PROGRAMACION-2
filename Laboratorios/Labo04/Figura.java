package Laboratorios.Labo04;
//clase papá
public class Figura {

  public String color;
  public String nombre;

  public Figura (String color, String nombre){
    this.color = color;
    this.nombre = nombre;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  //Agregamos un metodo
  public double area(){
    return 0;
  }

  public double perimetro(){
    return 0;
  }
}

