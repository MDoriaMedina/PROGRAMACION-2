package Practicas.Practica03.Ejercicio05;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Curso {
    private String nombre;
    private int cantidadAlumnos;
    private int paralelo;
    private String siglaMateria;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Curso(String nombre,int cantidadAlumnos,int paralelo,String siglaMateria){
        this.nombre=nombre;
        this.cantidadAlumnos=cantidadAlumnos;
        this.paralelo=paralelo;
        this.siglaMateria=siglaMateria;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }
    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getParalelo() {
        return paralelo;
    }
    public void setParalelo(int paralelo) {
        this.paralelo = paralelo;
    }
    public String getSiglaMateria() {
        return siglaMateria;
    }
    public void setSiglaMateria(String siglaMateria) {
        this.siglaMateria = siglaMateria;
    }
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void MostrarEstudiantes(){
        String salida="";
        String tab="\t\t";
        String tab1 = "\t";
        salida+="Nombre"+tab1+tab1+"Parcial 1"+tab1+"Parcial 2"+tab1+"Parcial 3"+tab1+"NH"+tab1+tab1+"1T"+tab1+tab1+"2T"+tab1+tab1+"Nota final\n";
        for (int i=0;i<estudiantes.size();i++){
            estudiantes.get(i).llenarNotasParcial();
            estudiantes.get(i).CalcularNotasFinales();
            salida+=estudiantes.get(i).getNombre()+tab+
                    estudiantes.get(i).getNotas(0)+tab+
                    estudiantes.get(i).getNotas(1)+tab+
                    estudiantes.get(i).getNotas(2)+tab+
                    estudiantes.get(i).getNotaHabilitacion()+tab+
                    estudiantes.get(i).getNota1T()+tab+
                    estudiantes.get(i).getNota2T()+tab+
                    estudiantes.get(i).getNotaFinal()+"\n";
        }
        JOptionPane.showMessageDialog(null,"Tabla de notas de los estudiantes del curso\n"+salida);
        JOptionPane.showMessageDialog(null,"La tabla de estudiantes con susu notas se encuentra en la terminal para mejor orden");
        System.out.println(salida);
    }

    public String esp(int n){
        String salida="";
        for (int i=0;i<n;i++){
            salida+=" ";
        }
        return salida;
    }
}
