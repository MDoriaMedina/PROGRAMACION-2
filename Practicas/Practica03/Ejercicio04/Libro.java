package Practicas.Practica03.Ejercicio04;

public class Libro {
    
    public String titulo;
    public String autor;
    public String ISBN;
    public String genero;
    public boolean disponibilidad;

    public Libro(String titulo, String autor, String ISBN, String genero, boolean disponibilidad){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutores(String[] autores) {
        this.autor = autor;
    }

    public String getAutores() {
        return autor;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }


}
