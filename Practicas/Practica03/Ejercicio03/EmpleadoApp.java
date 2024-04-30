package Practicas.Practica03.Ejercicio03;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmpleadoApp {
    public static void main(String[] args){

        String[] opciones = {"Docente", "Administrativo"};
        int tipoEmpleado = JOptionPane.showOptionDialog(null, "Seleccione el tipo de empleado:", "Seleccion de Empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);


        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del empleado:");
        String dependencia = JOptionPane.showInputDialog("Ingrese la dependencia del empleado:");

        Empleado empleado;
        if(tipoEmpleado == 0){

            String[] opcionesDocente = {"Profesor de Tiempo Completo", "Profesor de Hora Catedra"};
            int tipoDocente = JOptionPane.showOptionDialog(null, "Seleccione el tipo de docente:", "Seleccion de Docente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesDocente, opcionesDocente[0]);


            double calificacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificacion asignada del docente:"));
            if(tipoDocente == 0){
                String nivelEstudio = JOptionPane.showInputDialog("Ingrese el nivel de estudio (pregrado, maestría o doctorado):");
                empleado = new ProfesorTiempoCompleto(nombre, cedula, dependencia, calificacion, 0, nivelEstudio);
            }else{

                int horasAsignadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas de trabajo del profesor:"));
                empleado = new ProfesorHoraCatedra(nombre, cedula, dependencia, calificacion, 0, horasAsignadas);
            }
        }else{
            String[] opcionesAdministrativo = {"Recursos Humanos", "Mantenimiento"};
            int tipoAdministrativo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de administrativo:", "Seleccion de Administrativo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesAdministrativo, opcionesAdministrativo[0]);

            if(tipoAdministrativo == 0){
                String tesoreria = JOptionPane.showInputDialog("Es de tesoreria? (si/no):");
                boolean esTesoreria = tesoreria.equalsIgnoreCase("Si");
                empleado = new RecursosHumanos(nombre, cedula, dependencia, esTesoreria);
            }else{
                ArrayList<String> bloquesAsignados = new ArrayList<>();

                String bloque = JOptionPane.showInputDialog("Ingrese el bloque asignado:");
                while(!bloque.equalsIgnoreCase("chao :)")){
                    bloquesAsignados.add(bloque);
                    bloque = JOptionPane.showInputDialog("Ingrese el bloque asignado:");
                }
                int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas extras trabajadas:"));
                empleado = new Mantenimiento(nombre, cedula, dependencia, bloquesAsignados, horasExtra);
            }
        }

        int salario = empleado.calcularSalario();
        JOptionPane.showMessageDialog(null, "Salario del empleado: " + salario);
    }
}
