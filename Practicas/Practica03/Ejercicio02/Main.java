import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int num_ruedas, num_pasajeros, capacidad_carga, opcion;
        String tipo_automovil;
        System.out.println("AUTOMOVILES");
        num_ruedas = Entrada("Ingrese el numero de ruedas: ");
        num_pasajeros = Entrada("Ingrese el numero de pasajeros: ");
        opcion = Entrada("Escoga una de estas opciones:\n1)Camion\n2)AutoMovil\nRes: ");
        switch (opcion) {
            case 1:
                capacidad_carga = Entrada("Ingrese la capacidad de carga: ");
                Camion camion = new Camion(num_ruedas, num_pasajeros, capacidad_carga);
                System.out.println(camion.toString());
                break;
            case 2:
                System.out.print("Ingrese el tipo de automovil: ");
                tipo_automovil = cin.next();
                AutoMovil automovil = new AutoMovil(num_ruedas, num_pasajeros, tipo_automovil);
                System.out.println(automovil.toString());
                break;
            default:
                break;
        }

    }

    public static int Entrada(String mensaje){
        int a = 0;
        Scanner cin = new Scanner(System.in);
        while(true){
            try{
                System.out.print(mensaje);
                a = Integer.parseInt(cin.next());
                return a;
            }
            catch (NumberFormatException e) {
                System.out.println("Ingresaste un dato incorrecto...");
            }
        }
    
    }
}

