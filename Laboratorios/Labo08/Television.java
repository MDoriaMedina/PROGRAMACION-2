package Laboratorios.Labo08;

public class Television extends Electrodomestico {
      
    public int pulgadas;

    public Television(double precioBase, String color, char consumoEnergetico, double peso, int pulgadas){
          super(precioBase, color, consumoEnergetico, peso);
          this.pulgadas = pulgadas;
    }

    public void setPulgadas(int pulgadas) {
          this.pulgadas = pulgadas;
    }

    public int getPulgadas() {
          return pulgadas;
    }

    public double PrecioFinal(){
          return 0;
    }

}