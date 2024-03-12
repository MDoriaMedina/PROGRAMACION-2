package Practicas.Practica02.Ejercicio02;

public class jugador {

    public int numeroPolera;
    public int tarjetaAmarilla;
    public int tarjetaRoja;
    public int goles;
    public int partidosJugados;
    
    //constructor
    public jugador(int numeroPolera, int tarjetaAmarilla, int tarjetaRoja, int goles, int partidosJugados){
        this.numeroPolera = numeroPolera;
        this.tarjetaAmarilla = tarjetaAmarilla;
        this.tarjetaRoja = tarjetaRoja;
        this.goles = goles;
        this.partidosJugados = partidosJugados;
    }
    //setters y getters
    public void setNumeroPolera(int numeroPolera) {
        this.numeroPolera = numeroPolera;
    }

    public int getNumeroPolera() {
        return numeroPolera;
    }

    public void setTarjetaAmarilla(int tarjetaAmarilla) {
        this.tarjetaAmarilla = tarjetaAmarilla;
    }

    public int getTarjetaAmarilla() {
        return tarjetaAmarilla;
    }

    public void setTarjetaRoja(int tarjetaRoja) {
        this.tarjetaRoja = tarjetaRoja;
    }

    public int getTarjetaRoja() {
        return tarjetaRoja;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getGoles() {
        return goles;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }
    
    
}
