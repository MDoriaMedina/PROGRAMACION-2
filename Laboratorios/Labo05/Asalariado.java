package Laboratorios.Labo05;

public class Asalariado extends Empleado{

    public double pagaSemanal;

    public Asalariado(String nombre, String apellido, String carnet, double pagaSemanal){
        super(nombre, apellido, carnet);
        this.pagaSemanal = pagaSemanal;
    }

    public void setPagaSemanal(double pagaSemanal) {
        this.pagaSemanal = pagaSemanal;
    }

    public double getPagaSemanal() {
        return pagaSemanal;
    }
      
    @Override
    public double calcularSalario(){
        double res = 0;
        res = getPagaSemanal()*4;
        return res;
    }
    
    @Override
    public String tipoEmpleado(){
        return "asalariado";
    }
}
