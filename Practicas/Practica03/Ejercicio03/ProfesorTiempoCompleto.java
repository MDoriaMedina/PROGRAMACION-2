package Practicas.Practica03.Ejercicio03;

public class ProfesorTiempoCompleto extends Docente {

    public String nivelEstudio = "";

    public ProfesorTiempoCompleto(String nombre, String cedula, String dependencia, double calificacionAsignada, int salario, String nivelEstudio){
        super(nombre, cedula, dependencia, calificacionAsignada, salario);
        this.nivelEstudio = nivelEstudio;
    }

    public int calcularSalario(){
        if(nivelEstudio.equals("pregrado")){
            salario += 10000;
        }else if(nivelEstudio.equals("maestria")){
            salario += 18000;
        }else if(nivelEstudio.equals("doctorado")){
            salario += 25000;
        }
        return salario;
    }

    public String getNivelEstudio(){
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio){
        this.nivelEstudio = nivelEstudio;
    }
}
