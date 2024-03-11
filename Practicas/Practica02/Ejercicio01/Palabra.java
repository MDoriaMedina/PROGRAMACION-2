package Practicas.Practica02.Ejercicio01;

public class Palabra {
    
    public String palabra;

    public Palabra(String Palabra){
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String aMayuscula(){
        String Mayusculas;
        Mayusculas = getPalabra().toUpperCase();
        return Mayusculas;
    }
}
