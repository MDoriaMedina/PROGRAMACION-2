package Practicas.Practica02.Ejercicio03;

public class Empleado {
    
    public String nombre;
    public double ingresoMensual;
    public String horaEntrada;
    public String horaSalida;

    public Empleado (String nombre, double ingresoMensual, String horaEntrada, String horaSalida){
        this.nombre = nombre;
        this.ingresoMensual = ingresoMensual;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }
    
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int horarioEntrada(){
        int hora = 0, minutos = 0, totalMinutos = 0;
        String entrada = getHoraEntrada();
        for(int i = 0 ; i < getHoraEntrada().length() ; i++){
            char valor = entrada.charAt(i);
            if(Character.isDigit(valor)){
                if(i == 0){
                    hora = 10 * Character.getNumericValue(valor);
                    
                }else{
                    if(i==1){
                        hora = hora + Character.getNumericValue(valor);
                    }else{
                        if(i==3){
                            minutos = 10 * Character.getNumericValue(valor);
                        }else{
                            minutos = minutos + Character.getNumericValue(valor);
                        }
                    }
                }
            }   
        }
        totalMinutos = (hora*60) + minutos;
        return totalMinutos;
    }

    public int horarioSalida(){
        int hora = 0, minutos = 0, totalMinutos = 0;
        String entrada = getHoraSalida();
        for(int i = 0 ; i < getHoraSalida().length() ; i++){
            char valor = entrada.charAt(i);
            if(Character.isDigit(valor)){
                if(i == 0){
                    hora = 10 * Character.getNumericValue(valor);
                    
                }else{
                    if(i==1){
                        hora = hora + Character.getNumericValue(valor);
                    }else{
                        if(i==3){
                            minutos = 10 * Character.getNumericValue(valor);
                        }else{
                            minutos = minutos + Character.getNumericValue(valor);
                        }
                    }
                }
            }   
        }
        totalMinutos = ((hora+12)*60) + minutos;
        return totalMinutos;
    }

    public double calculoIngreso(){
        double ingreso = 0.00, ingresoDiario = 0.00;
        int minutosEntrada = 510, minutosSalida = 960;
        int penalizacionEntrada = 0, penalizacionSalida = 0;
        ingresoDiario = getIngresoMensual()/30;
        penalizacionEntrada = horarioEntrada() - minutosEntrada;
        penalizacionSalida = minutosSalida - horarioSalida(); 
        ingreso = getIngresoMensual()-((penalizacionEntrada+penalizacionSalida)*ingresoDiario);
        return ingreso;
    }
}


