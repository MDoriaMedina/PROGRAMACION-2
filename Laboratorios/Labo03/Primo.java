package Laboratorios.Labo03;

public class Primo {
     
    public int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void calcPrimo(int num){
        
        int cont = 0;
        for(int i=1; i<=num;i++){
            
            if(num%i==0){
                cont++;
            }
        }
        if(cont==2){
            System.out.println("Es Primo");
        }else{
            System.out.println("No es primo");
        }

    }

}