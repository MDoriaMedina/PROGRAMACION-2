package Laboratorios.Labo07;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LavadoraAplicacion {

        static ArrayList<Lavadora> lavadoras = new ArrayList<>();
        public static void main(String[] args) { 
                int compra = 0, n = 0;
                compra = inicio(n);
                System.out.println(compra);
                int tipoMensaje = JOptionPane.INFORMATION_MESSAGE;//Eh agregado esto porque me salia con un signo de error 
                JOptionPane.showMessageDialog(null, "El resultado de la compra fue: " + calculoCompra(compra), "Resultado", tipoMensaje);
        }

        public static double calculoCompra(int compra) {
            Lavadora aux;
            double precioBase = 100.00;
            double total = 0.00;
            String color = "Blanco";
            char letraConsumo = 'F';
            double peso = 5.00;
            int carga = 5;
            double sumaTotal = 0.00;
            for(int i = 0; i<compra ; i++){
                color = ingresarColor();
                letraConsumo = ingresarLetra();
                peso = ingresarPeso();
                carga = ingresarCarga();
                aux = new Lavadora(precioBase, color, letraConsumo, peso, carga);
                aux.setPrecioBase(precioBase);
                aux.setColor(color);
                aux.setConsumoEnergetico(letraConsumo);
                aux.setPeso(peso);
                aux.setCarga(carga);
                sumaTotal = sumaTotal + aux.precioFinal();
                lavadoras.add(aux);
            }
            return sumaTotal;
        }

        private static int ingresarCarga() {
            String valor = JOptionPane.showInputDialog("Ingrese la carga de la lavadora: ");
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
                return ingresarCarga(); // Pedir de nuevo en caso de error
            }
        }

        private static double ingresarPeso() {
            String valor = JOptionPane.showInputDialog("Ingrese el peso: ");
            try {
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
                return ingresarPeso(); // Pedir de nuevo en caso de error
            }
        }

        private static char ingresarLetra() {
            String letraConsumo = JOptionPane.showInputDialog("Ingrese la letra de consumo energético: ");
            char letra = letraConsumo.charAt(0);
            return letra;
        }

        private static String ingresarColor() {
            String[] opcionesColores = {"Blanco", "Negro", "Rojo", "Azul", "Gris"};

            // Mostrar el diálogo de selección de colores con Blanco como opción predeterminada
            String colorSeleccionado = (String) JOptionPane.showInputDialog(null, 
                                    "Selecciona un color:", 
                                    "Selecciona Color", 
                                    JOptionPane.QUESTION_MESSAGE, 
                                    null, 
                                    opcionesColores, 
                                    opcionesColores[0]); // Blanco seleccionado por defecto

            // Verificar si el usuario ha seleccionado un color
            if (colorSeleccionado != null) {
            // Imprimir el color seleccionado
                JOptionPane.showMessageDialog(null, "Color seleccionado: " + colorSeleccionado);
            } else {
            // Si el usuario cancela la selección
            JOptionPane.showMessageDialog(null, "No has seleccionado ningún color.");
            }
            return colorSeleccionado;
        }

        public static int inicio(int n){
                int num = 0;
                try { 
                    num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de lavadoras que va a comprar: ")); 
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número", null, 0);
                    return inicio(num);
                }
                return num;
        }
    
}
