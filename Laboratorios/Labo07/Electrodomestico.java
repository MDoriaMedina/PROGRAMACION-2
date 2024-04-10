package Laboratorios.Labo07;

public abstract class Electrodomestico {

    public double precioBase;
    public String color;
    public char consumoEnergetico;
    public double peso;

    public Electrodomestico (double precioBase, String color, char consumoEnergetico, double peso){
          this.precioBase = precioBase;
          this.color = color;
          this.consumoEnergetico = consumoEnergetico;
          this.peso = peso;
    }

    //GETTERS Y SETTERS
    public void setPrecioBase(double precioBase) {
          this.precioBase = precioBase;
    }

    public double getPrecioBase() {
          return precioBase;
    }

    public void setColor(String color) {
          this.color = color;
    }

    public String getColor() {
          return color;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
          this.consumoEnergetico = consumoEnergetico;
    }

    public char getConsumoEnergetico() {
          return consumoEnergetico;
    }

    public void setPeso(double peso) {
          this.peso = peso;
    }

    public double getPeso() {
          return peso;
    }

    //MÉTODOS
    public char comprobarConsumoEnergetico(char letra){
          return 'F';
    }

    public String comprobarColor(String color){
          return "Blanco";
    }

    public double precioFinal(){
          return 0;
    }


}
