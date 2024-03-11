package Practicas.Practica02.Ejercicio01;

public class Palabra {
    
    public String palabra;

    public Palabra(String palabra){
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void aMayuscula(){
        String Mayusculas;
        Mayusculas = getPalabra().toUpperCase();
        setPalabra(Mayusculas);
    }

    //funcion para volver array a la palabra
    public char[] caracterPorCaracter(){
        return getPalabra().toCharArray();
    }

    //funcion para comparar letra por letra
    public void letras(){
        char[] palabra = caracterPorCaracter();
        char[] palabraComparar = caracterPorCaracter();
        char letra = '0';
        int repeticion = 0, total = 0;
        for(int i = 0 ; i < palabra.length; i++){
            for(int j = 0; j < palabraComparar.length; j++){
                if (palabra[i] == palabraComparar[j]) {
                    repeticion++;
                    palabraComparar[j] = '0';
                }
            }
            letra = palabra[i];
            if(repeticion!=0){
                System.out.println(letra+" = "+repeticion);
                total = total + repeticion;
            }
            repeticion = 0;
        }
        System.out.println("TOTAL = " + total);

    }
}
