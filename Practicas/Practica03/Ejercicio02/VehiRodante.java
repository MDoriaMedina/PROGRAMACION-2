public class VehiRodante {
    private int num_ruedas, num_pasajeros;
    public VehiRodante(int num_ruedas, int num_pasajeros){
        this.num_ruedas = num_ruedas;
        this.num_pasajeros = num_pasajeros;
    }
    public int getNum_ruedas() {
        return num_ruedas;
    }
    public int getNum_pasajeros() {
        return num_pasajeros;
    }
    public void setNum_ruedas(int num_ruedas) {
        this.num_ruedas = num_ruedas;
    }
    public void setNum_pasajeros(int num_pasajeros) {
        this.num_pasajeros = num_pasajeros;
    }

    @Override
    public String toString() {
        return "DATOS DE VEHICULO RODANTE:\n-Numero de ruedas: " + getNum_ruedas() + "\n-Numero de Pasajeros: " + getNum_pasajeros();
    }
}
