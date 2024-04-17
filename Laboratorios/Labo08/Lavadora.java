package Laboratorios.Labo08;

public class Lavadora extends Electrodomestico {
      
    public int carga;

    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, int carga){
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getCarga() {
            return carga;
    }
    
    @Override
    public double precioFinal(){
          char [] consumoLetra = {'A','B','C','D','E','F'};
          int [] consumoPrecio = {100,80,60,50,30,10};
          //int posicion = 5;
          double res = 0;
          double precioPeso = 0;
          double cargaExtra = 50.00;
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

          if(getCarga()>30){
                res = cargaExtra + getPrecioBase() + consumoPrecio[i] + precioPeso;
                return res;  
          }else{
                res = getPrecioBase() + consumoPrecio[i] + precioPeso;
                return res;  
          }
          
    }

    @Override
    public String toString() {
          return "Precio: " + precioBase + "\nColor: " + color + "\nConsumo EnergÃ©tico: " + consumoEnergetico + "\nPeso : " + peso + " kg" + "\nCarga : " + carga + " kg.";
    }
}