package Laboratorios.Labo04;

public class Circulo extends Figura{
  
  public double radio;

  public Circulo (String color, String nombre, double radio){
    super(color, nombre);
    this.radio = radio;
  }

  public void setRadio(double radio) {
    this.radio = radio;
  }

  public double getRadio() {
    return radio;
  }

  @Override
  public double area() {
    return Math.PI *(Math.pow(radio, 2));
  }

  @Override
  public double perimetro() {
    return (2 * Math.PI) * radio;
  }
}

