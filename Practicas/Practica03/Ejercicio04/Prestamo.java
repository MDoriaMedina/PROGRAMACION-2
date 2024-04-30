package Practicas.Practica03.Ejercicio04;

import java.util.Date;

public class Prestamo extends Transaccion{
    
    public Usuario usuarioPrestamo;
    public Libro libroPrestamo;
    

    public Prestamo(Usuario usuarioPrestamo, Libro libroPrestamo, Date fechaInicial, Date fechaFinal){
        super(fechaInicial, fechaFinal);
        this.usuarioPrestamo = usuarioPrestamo;
        this.libroPrestamo = libroPrestamo;
        
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioPrestamo = usuario;
    }

    public Usuario getUsuario() {
        return usuarioPrestamo;
    }

    public void setLibro(Libro libro) {
        this.libroPrestamo = libro;
    }

    public Libro getLibro() {
        return libroPrestamo;
    }

    @Override
    public String realizarTransaccion(int a){
        if (a == 0) {
            String mensaje = "Prestamo realizado exitosamente";
            return mensaje;
        }else{
            String mensaje = "Prestamo no disponible";
            return mensaje;
        }
    }
    

}
