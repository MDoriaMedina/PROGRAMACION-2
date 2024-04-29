package Practicas.Practica03.Ejercicio01;

import javax.swing.JOptionPane;

public class Aplicacion {
    
    public static void main(String[] args) {
        
        menu();

    }

    public static void menu(){

        int lado = 0;
        int altura = 0;
        int seleccion = 0;
        Cuadrado cuadrado = new Cuadrado(lado);
        Paralelepipedo paralelepipedo = new Paralelepipedo(lado, altura);
        while(seleccion!=3){
            Object[] opciones = {"Superficie cuadrado","Superficie Paralelepípedo", "Volumen Paralelepípedo", "Salir"};
            seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opcion: ", "Selecciona", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            boolean valor = false;
            switch (seleccion) {
                case 0:
                    //JOptionPane.showMessageDialog(null, "Superficie del cuadrado");
                    while (!valor){
                        String side = JOptionPane.showInputDialog("Ingresa el lado del cuadrado");
                        try { 
                            lado = Integer.parseInt(side);
                            valor = true;
                        }catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Se debe ingresar un número entero");
                        } 
                        cuadrado.setLado(lado);
                        JOptionPane.showMessageDialog(null, "La superficie del cuadrado es: "+cuadrado.superficieCuadrado());
                    }
                    break;
                case 1:
                    if(cuadrado.getLado()!=0){
                        while(!valor){
                            String height = JOptionPane.showInputDialog("Ingresa la altura del paralelepípedo");
                            try{
                                altura = Integer.parseInt(height);
                                valor = true;
                            }catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Se debe ingresar un número entero");
                            }
                            paralelepipedo.setAltura(altura);
                            JOptionPane.showMessageDialog(null, "La superficie del paralelepipedo es: "+paralelepipedo.superficieParalelepipedo(lado, altura));
                        }    
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe ingresar el lado del cuadrado en la opcion 1");
                        break;
                    }
                    break;   
                case 2:
                    if(paralelepipedo.getAltura()!=0){
                        JOptionPane.showMessageDialog(null, "El volumen del paralelepipedo es: "+paralelepipedo.volumenParalelepipedo(lado, altura));   
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe ingresar la altura del paralelepipedo en la opcion 2");
                    }
                    break;
                
                case 3:
                    int exit = JOptionPane.showConfirmDialog(null, "¿DESEA SALIR?", "SALIR", JOptionPane.YES_OPTION);
                    if (exit == 0){
                        System.exit(0);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
        
    }
}

