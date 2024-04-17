package Laboratorios.Labo08;

public class Microondas extends Electrodomestico{

    int capacidad;
    int potencia;

    public Microondas(double precioBase, String color, char consumoEnergetico, double peso, int capacidad, int potencia){
          super(precioBase, color, consumoEnergetico, peso);
          this.capacidad = capacidad;
          this.potencia = potencia;
    }

    public void setCapacidad(int capacidad) {
          this.capacidad = capacidad;
    }

    public int getCapacidad() {
          return capacidad;
    }

    public void setPotencia(int potencia) {
          this.potencia = potencia;
    }

    public int getPotencia() {
          return potencia;
    }

    @Override
    public double precioFinal(){
          char [] consumoLetra = {'A','B','C','D','E','F'};
          int [] consumoPrecio = {100,80,60,50,30,10};
          //int posicion = 5;
          double res = 0;
          double precioPeso = 0;
          double extraPotencia = 5;
          int i = 0;
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
          for (char consumo : consumoLetra) {
                if (consumo != getConsumoEnergetico()) {
                      i++;
                }
          }
          if(getCapacidad()%5==0){
                res = getPrecioBase() + consumoPrecio[i] + extraPotencia + precioPeso;
                return res;  
          }else{
                res = getPrecioBase() + consumoPrecio[i] + precioPeso;
                return res;  
          }
    }
    
}