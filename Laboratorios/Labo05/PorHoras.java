package Laboratorios.Labo05;

public class PorHoras extends Empleado {
    
    public int horasTrabajadas;
      public double pagaHora;

      public PorHoras (String nombre, String apellido, String carnet, int horasTrabajadas, double pagaHora){
            super(nombre, apellido, carnet);
            this.horasTrabajadas = horasTrabajadas;
            this.pagaHora = pagaHora;
      }

      public int getHorasTrabajadas() {
            return horasTrabajadas;
      }

      public void setHorasTrabajadas(int horasTrabajadas) {
            this.horasTrabajadas = horasTrabajadas;
      }

      public void setPagaHora(double pagaHora) {
            this.pagaHora = pagaHora;
      }

      public double getPagaHora() {
            return pagaHora;
      }

      @Override
      public double calcularSalario() {
            double res = 0.0;
            int horasExtra = 0;
            int horas = horasTrabajadas;
            if(horas>40){
                  horasExtra = horas - 40;
                  res = (horasExtra*(getPagaHora()*2))+(40*getPagaHora());
            }else{
                  res = getHorasTrabajadas() * getPagaHora();
            }
        return res;
    }

    @Override
    public String tipoEmpleado(){
      return "que trabaja por horas";
  }

}


