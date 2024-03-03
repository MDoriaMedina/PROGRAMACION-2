package Practicas.Practica01;

import java.util.*;

public class Ejercicio01 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        int opcion;
        String texto="";
        //Scanner scanner = new Scanner(System.in);
        
        do{
            do{
                limpiarConsola();
                mostrarMenu();
                while (!scanner.hasNextInt()) { //verifica si el proximo valor de entrada es un entero
                limpiarConsola();
                System.out.println("ERROR. Elija una opción introduciendo un número del 1 al 6");
            
                mostrarMenu();
                scanner.next();
            }
            
            opcion = scanner.nextInt();
            scanner.nextLine();//Para evitar que se salte la entrada en cada Case de Switch

            //Validamos que el numero se encuentre entre una de las opciones del menu
            if (opcion < 1 || opcion > 6){
                limpiarConsola();
                System.out.println("ERROR. Elija una opción introduciendo un número del 1 al 6");
                //limpiarConsola();
            }

            }while (opcion < 1 || opcion > 6);

            switch (opcion) {
                
                case 1:

                    limpiarConsola();
                    System.out.println("Eligio la opción nro: 1.\n");
                    do{
                        texto = textoIngresado();
                        
                        if (texto.trim().isEmpty()) {
                            System.out.println("Debe ingresar un texto.");
                        }

                    }while(texto.trim().isEmpty());
                    System.out.println("\n");
                    System.out.println("EL texto ingresado fue: "+texto);
                    System.out.println("\n");
                    System.out.println("Presione Enter para continuar...");//con la modificacion en el scanner.nextLine despues de opcion ahora si espera a pulsar para continuar
                    scanner.nextLine();
                    break;
                
                case 2:
                    
                    limpiarConsola();
                    System.out.println("Eligio la opción nro: 2. Contar vocales");
                        if (texto.trim().isEmpty()) {
                            txtNoEncontrado();
                            break;
                        }else{
                            System.out.println("\n");
                            System.out.println("EL texto ingresado fue: "+texto); 
                            System.out.println("\n");
                            System.out.println("Se contaron "+ contarVocales(texto) +" vocales");
                        }
                    System.out.println("\n");
                    System.out.println("Presione Enter para continuar...");
                    scanner.nextLine();

                    break;

                case 3:
                    
                    limpiarConsola();
                    System.out.println("Eligio la opción nro: 3.\nContar consonantes");
                    if (texto.trim().isEmpty()) {
                        txtNoEncontrado();
                        break;
                    }
                    System.out.println("\n");
                    System.out.println("Presione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 4:

                    limpiarConsola();
                    System.out.println("Eligio la opción nro: 4.\nIntroduzca la palabra que desea encontrar en el texto:");
                    if (texto.trim().isEmpty()) {
                        txtNoEncontrado();
                        break;
                    }
                    break;

                case 5:

                    limpiarConsola();
                    System.out.println("Eligio la opción nro: 5.\nReemplazar una palabra por otra palabra");
                    if (texto.trim().isEmpty()) {
                        txtNoEncontrado();
                        break;
                    }
                    break;

                case 6:

                    limpiarConsola();
                    System.out.println("HASTA PRONTO!");
                    break;
            }
        
        }while(opcion!=6);

        //scanner.close();
    
    }

    //funcion que limpia la consola
    public static void limpiarConsola(){  
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    //funcion para mostrar el Menu
    private static void mostrarMenu() {
        System.out.println("======== Menú ========");
        System.out.println("1) Ingresa el texto");
        System.out.println("2) Contar vocales");
        System.out.println("3) Contar consonantes");
        System.out.println("4) Encontrar una palabra en el texto");
        System.out.println("5) Reemplazar una palabra por otra palabra");
        System.out.println("6) Salir");
        System.out.println("=======================");
        System.out.print("Ingrese el numero de la opción que desea realizar: ");
    }

    //funcion para ingresar texto
    public static String textoIngresado(){
        System.out.println("Ingrese el texto:");
        return scanner.nextLine();
        //String textoEnviado = txt;
    }

    //funcion texto no encontrado
    public static void txtNoEncontrado(){
        
        System.out.println("\n");
        System.out.println("Texto no encontrado. Debe ingresar un texto.\nPuede hacerlo mediante la opcion 1 del menú");
        System.out.println("\n");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    //funcion para contar vocales
    private static int contarVocales(String texto){
        
        int contadorVocales = 0;
        String vocales = "aeiouAEIOU";

        for(int i = 0; i < texto.length(); i++){
            //char vocal = texto.charAt(i);
            if((texto.charAt(i) == 'a')||(texto.charAt(i) == 'e')||(texto.charAt(i) == 'i')||(texto.charAt(i) == 'o')||(texto.charAt(i) == 'u')){
                contadorVocales++;
            }
        }

        return contadorVocales;
    }
}
