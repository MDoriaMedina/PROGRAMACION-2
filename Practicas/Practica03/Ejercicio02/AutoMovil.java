public class AutoMovil extends VehiRodante{
    private String tipo_automovil;
    public AutoMovil(int num_ruedas, int num_pasajeros, String tipo_automovil){
        super(num_ruedas, num_pasajeros);
        this.tipo_automovil = tipo_automovil;
    }
    public String getTipo_automovil() {
        return tipo_automovil;
    }
    public void setTipo_automovil(String tipo_automovil) {
        this.tipo_automovil = tipo_automovil;
    }

    public String toString(){
        return super.toString() + "\n- Tipo automovil: " + getTipo_automovil();
    }
}
