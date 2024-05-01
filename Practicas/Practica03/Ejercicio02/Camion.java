public class Camion extends VehiRodante{
    private int capacidad_carga;
    public Camion(int num_ruedas, int num_pasajeros, int capacidad_carga){
        super(num_ruedas, num_pasajeros);
        this.capacidad_carga = capacidad_carga;
    }
    public int getCapacidad_carga() {
        return capacidad_carga;
    }
    public void setCapacidad_carga(int capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }
    @Override
    public String toString(){
        return super.toString() + "\n- Capacidad de carga: " + getCapacidad_carga();
    }
}
