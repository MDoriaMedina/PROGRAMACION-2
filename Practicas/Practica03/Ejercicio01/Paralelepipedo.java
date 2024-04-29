package Practicas.Practica03.Ejercicio01;

public class Paralelepipedo extends Cuadrado{

    public int altura;
    
    public Paralelepipedo(int lado, int altura){
        super(altura);
        this.altura = altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public int superficieParalelepipedo(int a, int b) {
        int rectangulo = (a*b)*4;
        int base = (a*a)*2;
        return rectangulo + base;
    }

    public int volumenParalelepipedo(int a, int b) {
        return a * a * b;
    }
}
