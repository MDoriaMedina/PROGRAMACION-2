package Laboratorios.Labo10;

public class NoArquero extends Jugador{

    public int remates;

    public NoArquero(String nombre, int dorsal, String posicion, int tarjetasAmarillas, int tarjetasRojas, int remates) {
        super(nombre, dorsal, posicion, tarjetasAmarillas, tarjetasRojas);
        this.remates = remates;
        
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setDorsal(int dorsal) {
        super.setDorsal(dorsal);
    }

    @Override
    public int getDorsal() {
        return super.getDorsal();
    }

    @Override
    public void setPosicion(String posicion) {
        super.setPosicion(posicion);
    }

    @Override
    public String getPosicion() {
        return super.getPosicion();
    }

    @Override
    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        super.setTarjetasAmarillas(tarjetasAmarillas);
    }

    @Override
    public int getTarjetasAmarillas() {
        return super.getTarjetasAmarillas();
    }

    @Override
    public void setTarjetasRojas(int tarjetasRojas) {
        super.setTarjetasRojas(tarjetasRojas);
    }
    
    @Override
    public int getTarjetasRojas() {
        return super.getTarjetasRojas();
    }

    public void setRemates(int remates) {
        this.remates = remates;
    }

    public int getRemates() {
        return remates;
    }

    @Override
    public void SimularTarjetasAmarillas (int a, int b){
       super.SimularTarjetasAmarillas(a, b);
    }

    @Override
    public void SimularTarjetasRojas (int a, int b){
       super.SimularTarjetasRojas(a, b);
    }

}
