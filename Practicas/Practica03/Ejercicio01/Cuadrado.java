package Practicas.Practica03.Ejercicio01;

public class Cuadrado implements CalculoCuadradoInterfaz{
    
    public int lado;

    //constructor
    public Cuadrado(int lado){
        this.lado = lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public int superficieCuadrado(){
        return lado * 4;
    }

}
