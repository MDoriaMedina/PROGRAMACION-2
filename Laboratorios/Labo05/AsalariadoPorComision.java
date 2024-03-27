package Laboratorios.Labo05;

public class AsalariadoPorComision extends PorComision {

    public double pagaSemanal;

    public AsalariadoPorComision(String nombre, String apellido, String carnet, double VentasBrutas, double comision) {
        super(nombre, apellido, carnet, VentasBrutas, comision);
        this.pagaSemanal = pagaSemanal;
        //TODO Auto-generated constructor stub
    }  
      
    public void setPagaSemanal(double pagaSemanal) {
        this.pagaSemanal = pagaSemanal;
    }

    public double getPagaSemanal() {
        return pagaSemanal;
    }

}     

