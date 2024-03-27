package Laboratorios.Labo05;

public class PorComision extends Empleado {
    
    public double VentasBrutas;
      public double comision;

      public PorComision(String nombre, String apellido, String carnet, double VentasBrutas, double comision){
            super(nombre, apellido, carnet);
            this.VentasBrutas = VentasBrutas;
            this.comision = comision;
      }

      public void setVentasBrutas(double ventasBrutas) {
            VentasBrutas = ventasBrutas;
      }

      public double getVentasBrutas() {
            return VentasBrutas;
      }

      public void setComision(double comision) {
            this.comision = comision;
      }

      public double getComision() {
            return comision;
      }

      @Override
      public double calcularSalario(){
            double res = 0;
            res = (getComision()*getVentasBrutas())/100;
            return res;
      }

      @Override
      public String tipoEmpleado(){
            return "que trabaja por comisión";
        }
}

