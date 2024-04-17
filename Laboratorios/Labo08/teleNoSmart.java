package Laboratorios.Labo08;

public class teleNoSmart extends Television {
      
    public String resolucion;
    public int cantPuertos;

    public teleNoSmart(double precioBase, String color, char consumoEnergetico, double peso, int pulgadas,String resolucion , int cantPuertos){
          super(precioBase,color,consumoEnergetico,peso,pulgadas);
          this.resolucion = resolucion;
          this.cantPuertos = cantPuertos;
    }

    public void setResolucion(String resolucion) {
          this.resolucion = resolucion;
    }

    public String getResolucion() {
          return resolucion;
    }

    public void setCantPuertos(int cantPuertos) {
          this.cantPuertos = cantPuertos;
    }

    public int getCantPuertos() {
          return cantPuertos;
    }

    @Override
    public double precioFinal(){
          char [] consumoLetra = {'A','B','C','D','E','F'};
          int [] consumoPrecio = {100,80,60,50,30,10};
          //int posicion = 5;
          double res = 0;
          double precioPeso = 0;
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
          if(getPulgadas()>=50){
                res = getPrecioBase() + consumoPrecio[i] + precioPeso + 100.00;
                return res;
          }else{
                res = getPrecioBase() + consumoPrecio[i] + precioPeso;
                return res; 
          }
    }
    
}