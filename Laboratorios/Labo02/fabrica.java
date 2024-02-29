package Laboratorios.Labo02;

public class fabrica {
    
    //vamos a instanciar 
    public static void main(String[] args){
        auto petaAuto = new auto(); //se creo el objeto de tipo auto, que es una peta
        auto lamboAuto = new auto();
        auto quantumAuto = new auto();//ya tenemos 3 autos, los tres tienen las mismas capacidades
    
        System.out.println("-------PARA LA PETA: -----");
    //como hacemos acelerar a la peta? llamamos al mÃ©todo 
        petaAuto.acelerar("Herbie");
    //ahora quiero q frene. Las funciones estan en la clase, no en el Main
        petaAuto.frenar("Herbie");
        System.out.println("-------PARA EL LAMBO: -----");
        lamboAuto.acelerar("Jhonny");
        lamboAuto.tocarBocina(2);
        System.out.println("-------PARA EL QUANTUM: -----");
        quantumAuto.tocarBocina(1);

    }

}
