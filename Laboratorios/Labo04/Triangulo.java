package Laboratorios.Labo04;

public class Triangulo extends Figura{
  
  public double lado;

  public Triangulo(String color, String nombre, double lado){
    super(color, nombre);
    this.lado = lado;
  }

  public void setLado(double lado) {
    this.lado = lado;
  }

  public double getLado() {
    return lado;
  }

  @Override
  public double area() {
    return ((Math.sqrt(3)*Math.pow(lado, 2))/4);
  }

  @Override
  public double perimetro() {
    return 3 * lado;
  }
}

