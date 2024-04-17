package Laboratorios.Labo08;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ElectrodomesticoAplicacion {

        static ArrayList<Electrodomestico> elementos = new ArrayList<>();
        public static void main(String[] args) { 
            int compra = 0, n = 0;
            compra = inicio(n);
            System.out.println(compra);
            int tipoMensaje = JOptionPane.INFORMATION_MESSAGE;//Eh agregado esto porque me salia con un signo de error
            JOptionPane.showMessageDialog(null, "El resultado de la compra fue: " + calculoCompra(compra), "Resultado", tipoMensaje);
        }

        public static double calculoCompra(int compra) {
            String texto = "";
            texto += "-------------------\n";
            int elemento = 0;
            Electrodomestico aux; //IMPORTANTE NOMBRAR AL AUX
            double precioBase = 100.00;
            String color = "Blanco";
            char letraConsumo = 'F';
            double peso = 5.00;
            int carga = 5;
            int capacidad = 0;
            int potencia = 0;
            double sumaTotal = 0.00;
            for(int i = 0; i<compra ; i++){
                elemento = seleccionElemento();
                color = ingresarColor();
                letraConsumo = ingresarLetra();
                peso = ingresarPeso();
                switch (elemento) {
                    case 0:
                        carga = ingresarCarga();
                        aux = new Lavadora(precioBase, color, letraConsumo, peso, carga);
                        aux.setPrecioBase(precioBase);
                        aux.setColor(color);
                        aux.setConsumoEnergetico(letraConsumo);
                        aux.setPeso(peso);
                        ((Lavadora)aux).setCarga(carga);
                        sumaTotal = sumaTotal + aux.precioFinal();
                        elementos.add(aux);
                        texto+=""+aux.toString()+"\n";
                        texto+="-------------------\n";
                        break;
                    case 1:
                        capacidad = ingresarCapacidad();
                        aux = new Licuadora(precioBase, color, letraConsumo, peso, capacidad);
                        aux.setPrecioBase(precioBase);
                        aux.setColor(color);
                        aux.setConsumoEnergetico(letraConsumo);
                        aux.setPeso(peso);
                        ((Licuadora)aux).setCapacidad(capacidad);
                        sumaTotal = sumaTotal + aux.precioFinal();
                        elementos.add(aux);
                        texto+=""+((Licuadora)aux).toString()+"\n";
                        texto+="-------------------\n";
                        break;
                    case 2:
                        capacidad = ingresarCapacidad();
                        potencia = ingresarPotencia();
                        aux = new Microondas(precioBase, color, letraConsumo, peso, capacidad, potencia);
                        aux.setPrecioBase(precioBase);
                        aux.setColor(color);
                        aux.setConsumoEnergetico(letraConsumo);
                        aux.setPeso(peso);
                        ((Microondas)aux).setCapacidad(capacidad);
                        ((Microondas)aux).setPotencia(potencia);
                        sumaTotal = sumaTotal + aux.precioFinal();
                        elementos.add(aux);
                        texto+=""+((Microondas)aux).toString()+"\n";
                        texto+="-------------------\n";
                        break;
                    /*case 3:*/

                    default:
                        break;
                }
                
                //JOptionPane.showMessageDialog(null, aux.toString());
                
                
            }
            JTextArea obTA = new JTextArea(10, 10);
            obTA.setText(texto);
            JScrollPane obSP = new JScrollPane(obTA);
            JOptionPane.showMessageDialog(null,obTA);
            return sumaTotal;
        }

        private static int ingresarPotencia() {
            String valor = JOptionPane.showInputDialog("Ingrese la potencia del microondas: ");
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
                return ingresarPotencia(); // Pedir de nuevo en caso de error
            }
        }

        private static int ingresarCapacidad() {
            String valor = JOptionPane.showInputDialog("Ingrese la capacidad: ");
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
                return ingresarCapacidad(); // Pedir de nuevo en caso de error
            }
        }

        private static int seleccionElemento() {
            String[] opcionesItems = {"Lavadora", "Licuadora", "Microondas"};//,"Television"
            int opcion = JOptionPane.showOptionDialog(null, 
                                    "Selecciona un elemento:", 
                                    "Selecciona Elemento", 
                                    JOptionPane.DEFAULT_OPTION, 
                                    JOptionPane.QUESTION_MESSAGE, 
                                    null, 
                                    opcionesItems, 
                                    opcionesItems[0]);
            return opcion;
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
            // Si el usuario cancela la selecciÃ³n
            JOptionPane.showMessageDialog(null, "No has seleccionado ningún color.");
            }
            return colorSeleccionado;
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

        

        public static int inicio(int n){
            int num = 0;
            try { 
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ITEMS que va a comprar: ")); 
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número", null, 0);
                return inicio(num);
            }
            return num;
        }
    
}