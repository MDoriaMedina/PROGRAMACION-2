package Laboratorios.Labo08;

public class Licuadora extends Electrodomestico{
      
    public int capacidad;

    public Licuadora(double precioBase, String color, char consumoEnergetico, double peso, int capacidad){
          super(precioBase, color, consumoEnergetico, peso);
          this.capacidad = capacidad;
    }

    public void setCapacidad(int capacidad) {
          this.capacidad = capacidad;
    }

    public double getCapacidad() {
          return capacidad;
    }

    @Override
    public double precioFinal(){
          char [] consumoLetra = {'A','B','C','D','E','F'};
          int [] consumoPrecio = {100,80,60,50,30,10};
          //int posicion = 5;
          double res = 0;
          double precioPeso = 0;
          double precioCapacidad = 10;
          double capacidad = 50.00;
          if (getPeso()<=19){
                precioPeso = 10.00;
          }else{
                if(getPeso()>=20&&getPeso()<=49){
                      precioPeso = 50.00;
                }else{
                      if(getPeso()>=51&&getPeso()<=79){
                            precioPeso = 80.00;
                      }else{
                            precioPeso = 100.00;
                      }
                }
          }
          int i = 0;
          for (char consumo : consumoLetra) {
                if (consumo != getConsumoEnergetico()) {
                      i++;
                }
          }
          if(getCapacidad()>2){
                res = (precioCapacidad*(capacidad-2)) + getPrecioBase() + consumoPrecio[i] + precioPeso;
                return res;  
          }else{
                res = getPrecioBase() + consumoPrecio[i] + precioPeso;
                return res;  
          }
    }

    @Override
    public String toString() {
          return "Precio: " + precioBase + "\nColor: " + color + "\nConsumo Energético: " + consumoEnergetico + "\nPeso : " + peso + " kg" + "\nCapacidad : " + capacidad + " Litros";
    }
}