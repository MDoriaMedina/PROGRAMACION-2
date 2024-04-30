package Practicas.Practica03.Ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class RegistroBiblioteca {
    
    public List<Usuario> listaUsuarios;
    public List<Libro> listaLibros;
    public List<Prestamo> listaPrestamos;

    public RegistroBiblioteca() {
        listaUsuarios = new ArrayList<>();
        listaLibros = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public void registrarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
        prestamo.getLibro().setDisponibilidad(false);
    }

    public void registrarDevolucion(Prestamo prestamo) {
        listaPrestamos.remove(prestamo);
        prestamo.getLibro().setDisponibilidad(true);
    }

    public Usuario buscarPorCarnet(String ci) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCI() == ci) {
                return usuario;
            }
        }
        return null;
    }

    public Libro buscarLibroPorISBN(String codigo) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN() == codigo) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarLibroPorID(String id) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN() == id) {
                return libro;
            }
        }
        return null;
    }

    public Prestamo buscarPrestamoPorLibro(Libro libro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro() == libro) {
                return prestamo;
            }
        }
        return null;
    }
}
