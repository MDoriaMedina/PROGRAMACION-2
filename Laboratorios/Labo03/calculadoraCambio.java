package Laboratorios.Labo03;

public class calculadoraCambio {
    
    public int monto;

    public void setMonto(int monto) {
        this.monto = monto;
    }
    public int getMonto() {
        return monto;
    }

    public double cambioOficial(double cant){
        double res = 0.0;
        double oficial = 6.96;
        res = cant/oficial;
        return res;
    }

    public double cambioParalelo(double cant){
        double res = 0.0;
        double paralelo = 8.5;
        res = cant/paralelo;
        return res;
    }
    
}
