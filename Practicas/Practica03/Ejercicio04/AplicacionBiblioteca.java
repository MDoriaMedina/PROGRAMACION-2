package Practicas.Practica03.Ejercicio04;

import java.util.Date;

import javax.swing.JOptionPane;

public class AplicacionBiblioteca {
    
    public static void main(String[] args) {
        
        menu();
    }

    public static void menu() {
        
        RegistroBiblioteca biblioteca = new RegistroBiblioteca();
        boolean disponible = false;
        int seleccion = 0;
        while(seleccion!=4){
            Object[] opciones = {"Registrar Libro","Registrar cliente", "Prestamos", "Devoluciones", "Salir"};
            seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opcion: ", "Seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch(seleccion){
                case 0:
                    String titulo = JOptionPane.showInputDialog("Ingresar el titulo del libro");
                    String autor = JOptionPane.showInputDialog("Ingresar el autor del libro");
                    String ISBN = JOptionPane.showInputDialog("Ingresar el codigo isbn del libro");
                    String genero = JOptionPane.showInputDialog("Ingresar el género del libro");
                    disponible = true;
                    Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero, disponible);
                    biblioteca.agregarLibro(nuevoLibro);
                    JOptionPane.showMessageDialog(null, "Libro registrado exitosamente!");
                    break;
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingresar el nombre");
                    String apellido = JOptionPane.showInputDialog("Ingresar el apellido");
                    String CI = JOptionPane.showInputDialog("Ingresar el carnet de identidad");
                    String direccion = JOptionPane.showInputDialog("Ingresar la direccion de casa");
                    Usuario nuevoUsuario = new Usuario(nombre, apellido, CI, direccion);
                    biblioteca.agregarUsuario(nuevoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente!");
                    break;
                case 2:
                    String ciPrestamo = JOptionPane.showInputDialog("Ingresar el carnet de identidad");
                    String libroPrestamo = JOptionPane.showInputDialog("Ingresar el código del libro a ser prestado");
                    Usuario usuarioPrestamo = biblioteca.buscarPorCarnet(ciPrestamo);
                    Libro libroPrestado = biblioteca.buscarLibroPorISBN(libroPrestamo);
                    
                    if (usuarioPrestamo != null && libroPrestado != null && libroPrestado.getDisponibilidad()==true) {
                        Date fechaInicio = new Date();
                        // -
                        Date fechaVencimiento = new Date(fechaInicio.getTime() + 7 * 24 * 60 * 60 * 1000);

                        Prestamo prestamo = new Prestamo(usuarioPrestamo, libroPrestado, fechaInicio, fechaVencimiento);
                        biblioteca.registrarPrestamo(prestamo);
                        int flag = 0;
                        prestamo.realizarTransaccion(flag);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no disponible");
                    }
                    break;
                case 3:

                    String idLibroDevolucion = JOptionPane.showInputDialog("Ingresar el código del libro a ser devuelto");
                    Libro libroDevolucion = biblioteca.buscarLibroPorISBN(idLibroDevolucion);
                    Prestamo prestamoDevolucion = biblioteca.buscarPrestamoPorLibro(libroDevolucion);

                    if (libroDevolucion != null && prestamoDevolucion != null) {
                        biblioteca.registrarDevolucion(prestamoDevolucion);
                        libroDevolucion.setDisponibilidad(true);
                        JOptionPane.showMessageDialog(null, "Devolucion registrada");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar la devolucion");
                    }
                    break;
                    
                case 4:
                    int exit = JOptionPane.showConfirmDialog(null, "¿DESEA SALIR?", "SALIR", JOptionPane.YES_OPTION);
                    if (exit == 0){
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    
}
