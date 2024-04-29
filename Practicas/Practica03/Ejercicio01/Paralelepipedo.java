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

    public int superficieParalelepipedo() {
        return 0;
    }

    int volumenParalelepipedo() {
        return 0;
    }
}
