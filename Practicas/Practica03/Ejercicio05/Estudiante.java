package Practicas.Practica03.Ejercicio05;

public class Estudiante implements NotasFinales,NotasParciales{
    private String nombre;
    private double[] notas = new double[3];
    private double notaHabilitacion;
    private double nota1T = 0;
    private double nota2T = 0;
    private double notaFinal = 0;

    public Estudiante(String nombre){
        this.nombre=nombre;
    }

    // Inicio - getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getNotaHabilitacion() {
        return notaHabilitacion;
    }
    public void setNotaHabilitacion(double notaHabilitacion) {
        this.notaHabilitacion = notaHabilitacion;
    }
    public double[] getNotas() {
        return notas;
    }
    public double getNotas(int i){
        return notas[i];
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    public void setNotas(int i,double nota){
        this.notas[i]=nota;
    }
    public double getNota1T() {
        return nota1T;
    }
    public void setNota1T(double nota1t) {
        nota1T = nota1t;
    }
    public double getNota2T() {
        return nota2T;
    }
    public void setNota2T(double nota2t) {
        nota2T = nota2t;
    }
    public double getNotaFinal() {
        return notaFinal;
    }
    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
    // Fin - getters y setters

    public void llenarNotasParcial(){
        double sumaNotas=0;
        double notaAsistencia,notaPracticas,notaExamenes,notalaboratorios;
        for (int i=0;i<3;i++){
            notaAsistencia=randInt(0, 10)+0.00;
            notaPracticas=randInt(0, 25)+0.00;
            notaExamenes=randInt(0, 40)+0.00;
            notalaboratorios=randInt(0, 25)+0.00;
            sumaNotas+=notaAsistencia+notaPracticas+notaExamenes+notalaboratorios;
            setNotas(i,notaAsistencia+notaPracticas+notaExamenes+notalaboratorios);
        }
        setNotaHabilitacion(redondear(sumaNotas/3.00,1));
    }

    public void CalcularNotasFinales(){
        int op=0;
        if (getNotaHabilitacion()>=60.00){
            setNota1T(randInt(0, 100)+0.00);
            op=randInt(1,2);
            if (op==1){
                setNotaFinal(redondear(((getNotaHabilitacion()+getNota1T())/2.00),1));
            }else if (op==2){
                setNota2T(randInt(0,100)+0.00);
                setNotaFinal(redondear(((getNotaHabilitacion()+getNota2T())/2.00),1));
            }
        }
    }

    public double redondear(double numero,int n){
        double factor = Math.pow(10, n);
        return Math.round(numero * factor) / factor;
    }

    public int randInt(int a,int b){
        return a + (int) (Math.random() * (b - a + 1));
    }
}
