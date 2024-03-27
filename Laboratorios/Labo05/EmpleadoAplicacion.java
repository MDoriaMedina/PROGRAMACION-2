package Laboratorios.Labo05;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class EmpleadoAplicacion {

    public static void main(String[] args) {
        String texto = "EMPRESA DE HOODIES\n";
        texto += "CALCULO DE SALARIOS\nSELECCIONE UNA OPCION: ";
        //texto += "Seleccione una opcion:";
        int opcionSeleccionada = mostrarOpciones(texto, "Calcular Salario", "Salir");
        // Mostrar la opción seleccionada en número
        menu(opcionSeleccionada);
    }

    public static int mostrarOpciones(String mensaje, String opcion1, String opcion2) {
        Object[] opciones = {opcion1, opcion2};
        int seleccion = JOptionPane.showOptionDialog(null, mensaje, "Selección de opción",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        return seleccion;
    }

    public static void menu(int opcionSeleccionada) {
        String nombre = "";
        String apellido = "";
        String carnet = "";
        int tipoEmpleado = 0;
        double paga = 0.0;
        int horas = 0;
        double ventas = 0.0;
        double comision = 0.0;
        switch (opcionSeleccionada){
            case 0:
                nombre = ingresarNombre(nombre);
                //JOptionPane.showMessageDialog(null, nombre);
                apellido = ingresarApellido(apellido);
                carnet = ingresarCarnet(carnet);
                String mensaje = "Seleccione la forma de trabajo del empleado: ";
                tipoEmpleado = tipoEmpleado(mensaje, "Asalariado", "Por Horas", "Por Comision");
                switch (tipoEmpleado){
                    case 0:
                        paga = ingresarPagaSemanal();
                        Empleado emp1 = new Asalariado(nombre, apellido, carnet, paga);
                        //JOptionPane.showMessageDialog(null, "El perimetro del "+circulo.getNombre()+" "+circulo.getColor()+": " + redondear(circulo.calcularPerimetro()));
                        JOptionPane.showMessageDialog(null, "El salario mensual del empleado "+emp1.tipoEmpleado()+ ": "+emp1.getNombre()+" "+emp1.getApellido()+", con CI: "+emp1.getCarnet()+", es: "+redondear(emp1.calcularSalario()));
                        break;
                    case 1:
                        horas = ingresarHoras();
                        paga = ingresarPagaPorHora();
                        Empleado emp2 = new PorHoras(nombre, apellido, carnet, horas, horas);
                        JOptionPane.showMessageDialog(null, "El salario mensual del empleado "+emp2.tipoEmpleado()+" "+emp2.getApellido()+", con CI: "+emp2.getCarnet()+", es: "+redondear(emp2.calcularSalario()));
                        break;
                    case 3:
                        ventas = ingresarVentas();
                        comision = ingresarComsion();
                        Empleado emp3 = new PorComision(nombre, apellido, carnet, ventas, comision);
                        JOptionPane.showMessageDialog(null, "El salario mensual del empleado "+emp3.tipoEmpleado()+" "+emp3.getApellido()+", con CI: "+emp3.getCarnet()+", es: "+redondear(emp3.calcularSalario()));
                        break;
                }
                break;
            case 1:
                int exit = JOptionPane.showConfirmDialog(null, "¿DESEA SALIR?", "SALIR", JOptionPane.YES_OPTION);
                if (exit == 0){
                    System.exit(0);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "OPCION INVALIDA", "ERROR", JOptionPane.WARNING_MESSAGE);       
        }
    }

    private static double ingresarComsion() {
        String input = JOptionPane.showInputDialog("Ingrese el porcentaje de comision por venta: ");
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ingresarPagaPorHora(); // Pedir de nuevo en caso de error
        }
    }

    private static double ingresarVentas() {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de venta total: ");
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ingresarPagaPorHora(); // Pedir de nuevo en caso de error
        }
    }

    private static double ingresarPagaPorHora() {
        String input = JOptionPane.showInputDialog("Ingrese el monto que gana el empleado por hora: ");
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ingresarPagaPorHora(); // Pedir de nuevo en caso de error
        }
    }

    private static int ingresarHoras() {
        String input = JOptionPane.showInputDialog("Ingrese el número de horas que trabajo el empleado: ");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ingresarHoras(); // Pedir de nuevo en caso de error
        }
        
    }

    private static String ingresarCarnet(String carnet) {
        // TODO Auto-generated method stub
        return JOptionPane.showInputDialog("Ingrese el número de carnet del empleado: ");
    }

    private static String ingresarApellido(String apellido) {
        // TODO Auto-generated method stub
        return JOptionPane.showInputDialog("Ingrese el apellido del empleado: ");
    }

    public static String ingresarNombre(String nombre){
        return JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
    }

    public static double ingresarPagaSemanal() {
        String input = JOptionPane.showInputDialog("Ingrese el monto que gana el empleado semanalmente: ");
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ingresarPagaSemanal(); // Pedir de nuevo en caso de error
        }
    }



    public static int tipoEmpleado(String mensaje, String opcion1, String opcion2, String opcion3) {
        Object[] opciones = {opcion1, opcion2, opcion3};
        int seleccion = JOptionPane.showOptionDialog(null, mensaje, "Selección de opción",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        return seleccion;
    }

    public static String redondear(double num){
        DecimalFormat df = new DecimalFormat("#.00");
        String numeroFormateado = df.format(num);
        return numeroFormateado;
    }

}

