package Laboratorios.Labo04;
import java.util.*;
public class FiguraAplicacion {
    public static void main(String[] args){

        Scanner scanner = new Scanner (System.in);
        int opcion = 0, opcionSeg = 0;
        String color = "Rojo";
        String nombre = "Cuadrado";
        double lado = 4;

        Cuadrado cuad = new Cuadrado(color, nombre, lado);
        Triangulo tri = new Triangulo(color, nombre, lado);
        Circulo circ = new Circulo(color, nombre, lado);

        //System.out.println(cuad.area());
        //System.out.println(cuad.perimetro());
        //System.out.println(tri.area());
        //System.out.println(tri.perimetro());
        //System.out.println(circ.area());
        //System.out.println(circ.perimetro());

        do {
            
            mostrarMenuPrincipal();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                
                case 1:
                    
                    System.out.println("Ha seleccionado la Opción 1.\n");
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre de la figura: ");
                    nombre = scanner.nextLine();
                    cuad.setNombre(nombre);
                    //scanner.nextLine();
                    System.out.println("Ingrese el color de la figura: ");
                    color = scanner.nextLine();
                    cuad.setColor(color);
                    System.out.println("Ingrese la dimension de lado: ");
                    lado = scanner.nextDouble();
                    cuad.setLado(lado);
                    do {
                        mostrarSegundoMenu();
                        System.out.print("Ingrese su opción: ");
                        opcionSeg = scanner.nextInt();

                        switch (opcionSeg) {
                            case 1:
                                System.out.println("El área de : "+cuad.getNombre()+" "+cuad.getColor()+" es: "+cuad.area());
                                break;
                            case 2:
                                System.out.println("El perímetro de : "+cuad.getNombre()+" "+cuad.getColor()+" es: "+cuad.perimetro());
                                break;
                            case 3:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                                break;
                        }

                    } while (opcionSeg != 3);
                    break;

                case 2:
                    System.out.println("Ha seleccionado la Opción 2.");
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre de la figura: ");
                    nombre = scanner.nextLine();
                    tri.setNombre(nombre);
                    System.out.println("Ingrese el color de la figura: ");
                    color = scanner.nextLine();
                    tri.setColor(color);
                    System.out.println("Ingrese la dimension de lado: ");
                    lado = scanner.nextDouble();
                    tri.setLado(lado);
                    
                    do {
                        mostrarSegundoMenu();
                        System.out.print("Ingrese su opción: ");
                        opcionSeg = scanner.nextInt();

                        switch (opcionSeg) {
                            case 1:
                                System.out.println("El área de : "+tri.getNombre()+" "+tri.getColor()+" es: "+tri.area());
                                break;
                            case 2:
                                System.out.println("El perímetro de : "+tri.getNombre()+" "+tri.getColor()+" es: "+tri.perimetro());
                                break;
                            case 3:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                                break;
                        }

                    } while (opcionSeg != 3);
                    break;

                case 3:
                    System.out.println("Ha seleccionado la Opción 3.");
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre de la figura: ");
                    nombre = scanner.nextLine();
                    circ.setNombre(nombre);
                    System.out.println("Ingrese el color de la figura: ");
                    color = scanner.nextLine();
                    circ.setColor(color);
                    System.out.println("Ingrese la dimension del radio: ");
                    lado = scanner.nextDouble();
                    circ.setRadio(lado);
                    do {
                        mostrarSegundoMenu();
                        System.out.print("Ingrese su opción: ");
                        opcionSeg = scanner.nextInt();

                        switch (opcionSeg) {
                            case 1:
                                System.out.println("El área de : "+circ.getNombre()+" "+circ.getColor()+" es: "+circ.area());
                                break;
                            case 2:
                                System.out.println("El perímetro de : "+circ.getNombre()+" "+circ.getColor()+" es: "+circ.perimetro());
                                break;
                            case 3:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                                break;
                        }

                    } while (opcionSeg != 3);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }

            System.out.println(); // Espacio en blanco para mejor legibilidad

        } while (opcion != 4);


    }

 

    //usamos el get.area() implementado en figura pero desarrollado en cuadrado
    //EStamos usando un get.color en cuadrado, porque es heredado

    //Figura fig = new Figura(color, nombre);
    //System.out.println(fig.getColor());


    //funcion que limpia la consola
    public static void limpiarConsola(){  
      System.out.println("\033[H\033[2J");
      System.out.flush();
    }

    //funcion para mostrar el Menu
    private static void mostrarMenuPrincipal() {
      System.out.println("======== Menú Figuras ========");
      System.out.println("Seleccione una opción:");
      System.out.println("1) Cuadrado ");
      System.out.println("2) Triangulo");
      System.out.println("3) Circulo");
      System.out.println("4) Salir");
      System.out.println("==============================");
    }

    private static void mostrarSegundoMenu() {
        
        System.out.println("Seleccione una opción:");
        System.out.println("1) Área");
        System.out.println("2) Perímetro");
        System.out.println("3) Salir");
        
    }

  

}

