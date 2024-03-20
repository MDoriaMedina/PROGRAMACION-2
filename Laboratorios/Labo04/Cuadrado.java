package Laboratorios.Labo04;
//clase hija
public class Cuadrado extends Figura{ //Usando EXTENDS: le estoy diciendo a cuadrado: tu apellido es figura
    //atributos propios del cuadrado
    public double lado;
    //constructor de la clase hija
    public Cuadrado (String color, String nombre, double lado){//se debe agregar los atributos del padre y luego usar super para usar correctamente los atributos de la clase padre. 
      //Asi se crea un constructor con herencia
      super(color, nombre);
      this.lado = lado;
    }

    public void setLado(double lado) {
      this.lado = lado;
    }

    public double getLado() {
      return lado;
    }

    @Override //significa que es un metodo sobreescribiendolo, xq ya existe en Figura pero no es propio del cuadrado, el calculo es del cuadrado pero el area es propia de cualquier figura
    public double area() {
      return lado*lado;
    }

    @Override
    public double perimetro() {
    // TODO Auto-generated method stub
      return lado*4;
    }
}
