package Practicas.Practica03.Ejercicio04;

public class Libro {
    
    public String titulo;
    public String[] autores;
    public String ISBN;
    public String genero;
    public String editorial;
    public int anhoPublicacion;
    
    public boolean disponibilidad;

    public Libro(String titulo, String[] autores, String ISBN, String genero, String editorial, int anhoPublicacion, boolean disponibilidad){
        this.titulo = titulo;
        this.autores = autores;
        this.ISBN = ISBN;
        this.genero = genero;
        this.editorial = editorial;
        this.anhoPublicacion = anhoPublicacion;
        this.disponibilidad = disponibilidad;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String[] getAutores() {
        return autores;
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

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setAnhoPublicacion(int anhoPublicacion) {
        this.anhoPublicacion = anhoPublicacion;
    }

    public int getAnhoPublicacion() {
        return anhoPublicacion;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }


}
