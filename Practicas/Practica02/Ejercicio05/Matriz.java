package Practicas.Practica02.Ejercicio05;

public class Matriz {
    
    public int n;

    public Matriz(int n){
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    } 

    public void generarMatriz(){
        int filas = 0, columnas = 0, numeroPrevio = 0, numeroSiguiente = 1;
        filas = columnas = getN();
        Object matriz[][] = new Object[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(i == j && i == (filas/2) && (filas%2==1)){
                    matriz[i][j] = ">:v";
                }else{
                    if(i == j){
                        matriz[i][j] = numeroPrevio;
                    }else{
                        matriz[i][j] = 0;
                    }
                if(j == (filas - (i+1))){
                    matriz[i][j] = numeroSiguiente;
                    numeroPrevio = numeroPrevio + numeroSiguiente;
                    numeroSiguiente = numeroSiguiente + numeroPrevio;
                }   
    
                }  
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
