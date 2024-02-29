package Laboratorios.Labo02;

public class auto {

    //estos son los mÃ©todos: 

    //Primera funcion. No se declaran las funciones como en C++
    public void acelerar(String nombreAuto){
        
        System.out.println(nombreAuto+" acelera");
    }

    //Segunda funcion
    public void frenar(String nombreAuto){
        System.out.println(nombreAuto+" frena");
    }

    //habran dos tipos de bocina
    public void tocarBocina(int tipoAuto){
        if(tipoAuto == 1){
            System.out.println("bip bip bip");    
        }else{
            System.out.println("bum bum");
        }
        
    }
    //Ahora creamos "la fÃ¡brica" para poder ejecutar este "plano"
}
