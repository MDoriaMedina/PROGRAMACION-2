package SimulacionFutbol;

public class Mediocampo extends NoDelantero{

    public Mediocampo(String nombre, int dorsal, String posicion, int tarjetasAmarillas, int tarjetasRojas, int remates, int despejes) {
        super(nombre, dorsal, posicion, tarjetasAmarillas, tarjetasRojas, remates, despejes);
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

    @Override
    public void setRemates(int remates) {
        this.remates = remates;
    }

    @Override
    public int getRemates() {
        return remates;
    }

    public void setDespejes(int despejes) {
        this.despejes = despejes;
    }

    public int getDespejes() {
        return despejes;
    }

    @Override
    public void SimularTarjetasAmarillas (int a, int b){
       super.SimularTarjetasAmarillas(a, b);
    }

    @Override
    public void SimularTarjetasRojas (int a, int b){
       super.SimularTarjetasRojas(a, b);
    }

    @Override
    public String toString() {
        
        return "\t"+nombre+"\t\n"+"\tDorsal: "+dorsal+"\t\n"+"\tPosicion: "+posicion+"\t\n"+"\tt. Amarillas: "+tarjetasAmarillas+"\t\n"+"\tt. Rojas: "+tarjetasRojas+"\t\n"+"\tDespejes: "+despejes+"\t\n"+"\tRemates: "+remates;
    }
}
