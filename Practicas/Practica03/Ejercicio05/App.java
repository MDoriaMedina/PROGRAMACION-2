package Practicas.Practica03.Ejercicio05;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Menu();
    }

    public static int EntradaEntero(String mensaje){
        int num=0;
        while (true) {
            try {
                num=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                return num;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Ingrese unicamente valores numericos Enteros");
            }
        }
    }

    public static void Menu(){
        String nombreCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso:");
        int cantidadAlumnos = EntradaEntero("Ingrese la cantidad de alumnos en el curso");
        int paraleloCurso = EntradaEntero("Ingrese el numero de paralelo del curso");
        String siglaMateria = JOptionPane.showInputDialog("Ingrese la sigla de la materia");
        Curso curso = new Curso(nombreCurso, cantidadAlumnos, paraleloCurso, siglaMateria);
        String nombreEstudiante;
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        for (int i=0;i<cantidadAlumnos;i++){
            nombreEstudiante=JOptionPane.showInputDialog("Ingrese el nombre del estudiante "+(i+1));
            Estudiante estudiante = new Estudiante(nombreEstudiante);
            estudiantes.add(estudiante);
        }
        curso.setEstudiantes(estudiantes);
        curso.MostrarEstudiantes();
    }
}
