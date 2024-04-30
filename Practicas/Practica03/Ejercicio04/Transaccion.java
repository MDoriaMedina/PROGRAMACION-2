package Practicas.Practica03.Ejercicio04;

import java.util.Date;

public abstract class Transaccion {

    public Date fechaPrestamo;
    public Date fechaDevolucion;
    
    public Transaccion (Date fechaPrestamo, Date fechaDevolucion){
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String realizarTransaccion(int a){
        String mensaje = null;
        return mensaje;
    }
}
