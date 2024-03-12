package Practicas.Practica02.Ejercicio04;

import java.util.*;
public class ContraseñaAplicacion {
  
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean bandera = false;
        String contraseñaIngresada = "";
        System.out.println("Ingrese la contraseña: ");
        contraseñaIngresada = sc.nextLine();
        Contraseña verificaContraseña = new Contraseña(contraseñaIngresada);
        do{
            bandera = verificaContraseña.controlContraseña();
            if(bandera == false){
                System.out.println("Ingrese la contraseña nuevamente: ");
                verificaContraseña.setContraseña(sc.nextLine());
            }
            
        }while(bandera == false);
        
        System.out.println("Contraseña correcta");
    }
}
