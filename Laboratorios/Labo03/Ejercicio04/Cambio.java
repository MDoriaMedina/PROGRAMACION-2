package Laboratorios.Labo03.Ejercicio04;

public class Cambio {
    
    double monto;

    //constructor
    public Cambio(double monto){
        this.monto = monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    //metodo cambio Oficial
    public double cambioOficial(){
        double oficial = 6.96, res = 0.0;
        double cant = getMonto();
        res = cant/oficial;
        return res;
    }

    //metodo cambio Paralelo Barato
    public double cambioParaleloBarato(){
        double paraleloBarato = 8.5, res = 0.0;
        double cant = getMonto();
        res = cant/paraleloBarato;
        return res;
    }

    //metodo cambio Paralelo Caro
    public double cambioParaleloCaro(){
        double paraleloCaro = 9.97, res = 0.0;
        double cant = getMonto();
        res = cant/paraleloCaro;
        return res;
    }

    //metodo cambio bolivianos a euros
    public double cambioEuros(){
        double euros = 7.5, res = 0.0;
        double cant = getMonto();
        res = cant/euros;
        return res;
    }
}
