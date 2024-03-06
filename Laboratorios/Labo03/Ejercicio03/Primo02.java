package Laboratorios.Labo03.Ejercicio03;

public class Primo02 {
    
    public int numero;

    //Constructor
    public Primo02(int numero){
        this.numero = numero;
    }

    //Setter
    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Getter
    public int getNumero() {
        return numero;
    }

    public void calcPrimo(){
        
        int n = getNumero(); //usamos getter
        int cont = 0;
        for(int i=1; i<=n;i++){
            
            if(n%i==0){
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
