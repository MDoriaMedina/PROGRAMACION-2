package SimulacionFutbol;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Aplicacion {

    public static ArrayList<Integer> stats1 = new ArrayList<>();
    public static ArrayList<Integer> stats2 = new ArrayList<>();
    public static void main(String[] args) {
        String[] partido = new String[2];
        ArrayList<Jugador> equipoLocal= new ArrayList<>();
        ArrayList<Jugador> equipoVisitante= new ArrayList<>();


        String strMenu = "\n1.Registro del equipo local y visitante";
        strMenu += "\n2.Simulacion del partido";
        strMenu += "\n3.Estadisticas";
        strMenu += "\n4.Salir";



        while (true){
            int op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion:"+strMenu));
            menu (op, partido, equipoLocal, equipoVisitante);
        }
    }

    public static void menu (int opcion, String[] partido, ArrayList<Jugador> equipo1, ArrayList<Jugador> equipo2){
        switch (opcion) {
            case 1:
                int tipo = Integer.parseInt(JOptionPane.showInputDialog("1.Local\n2.Visitante:"));
                if (tipo == 1){
                    partido = registrarEquipo(partido, tipo);
                    equipo1 = registrarJugadores(equipo1);
                }else{
                    if (tipo == 2){
                        partido = registrarEquipo(partido, tipo);
                        equipo2 = registrarJugadores(equipo2);
                    }else{
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    }
                }
                break;
            case 2:
                stats1.clear();
                stats2.clear();

                simulacionTarjetas(equipo1);
                simulacionTarjetas(equipo2);

                simulacionHabilidades(equipo1);
                simulacionHabilidades(equipo2);

                simulacionStats(equipo1, equipo2);
                JOptionPane.showMessageDialog(null, "Partido simulado");
                break;
            case 3:
                int seleccion = 0;
                
                while(seleccion!=2){
                    Object[] opciones = {"Del partido","De un jugador","Atrás"};
                    seleccion = JOptionPane.showOptionDialog(null, "ESTADISTICAS", "Selecciona una opción:", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                    estadisticas(seleccion,partido, equipo1, equipo2,stats1,stats2);
                }
                
                break;
            case 4:
                System.exit(0);
                break;
            default:

                break;
        }
    }

    private static void estadisticas(int seleccion, String[] partido, ArrayList<Jugador> equipo1, ArrayList<Jugador> equipo2, ArrayList<Integer> stats1, ArrayList<Integer> stats2) {
        switch(seleccion){
            case 0:
                String estadisticas1 = "\tESTADISTICAS\t\n";
                estadisticas1 += "equipo Local: "+ partido[0] +" vs "+ "equipo Visitante: " + partido[1]+"\n";
                estadisticas1 += stats1.get(0) + "\tposesion\t" + stats2.get(0) + "\n";
                estadisticas1 += stats1.get(1) + "\tparadas\t" + stats2.get(1) + "\n";
                estadisticas1 += stats1.get(2) + "\tremates\t" + stats2.get(2) + "\n";
                estadisticas1 += stats1.get(3) + "\tt amarillas\t" + stats2.get(3) + "\n";
                estadisticas1 += stats1.get(4) + "\t t rojas\t" + stats2.get(4) + "\n";
                estadisticas1 += stats1.get(5) + "\tgoles\t" + stats2.get(5) + "\n";

                JTextArea ob = new JTextArea(20,30);
                ob.setText(estadisticas1);
                JScrollPane ob1 = new JScrollPane(ob);
                JOptionPane.showMessageDialog(null, ob1);

                String estadisticasTexto = "\tESTADISTICAS\t\n";
                estadisticasTexto += "\t"+partido[0]+" VS " + partido[1] + "\n";
                int ganadorGoles = 0;
                ganadorGoles = ganador(stats1,stats2);
                if(ganadorGoles == 0){
                    estadisticasTexto += "El partido se jugó los 90 mins, " + partido[0] + " ganó " + stats1.get(5) + " a " + stats2.get(5) + " frente a " + partido[1] +"\n";
                }else{
                    if(ganadorGoles == 1){
                        estadisticasTexto += "El partido se jugó los 90 mins, " + partido[1] + " ganó " + stats2.get(5) + " a " + stats1.get(5) + " frente a " + partido[0]+"\n";
                    }else{
                        if(ganadorGoles == 2){
                            estadisticasTexto += "El partido se jugó los 90 mins, " + partido[1] + " empató frente a " + partido[0]+"\n";    
                        }
                    }
                }
                estadisticasTexto += "Total de tarjetas fueron: " + (stats1.get(3)+stats2.get(3)+stats1.get(4)+stats2.get(4)) + "\n" + "Total de tarjetas amarillas fueron: " + (stats1.get(3)+stats2.get(3)) + "\n" + "Total de tarjetas rojas fueron:" + (stats1.get(4)+stats2.get(4));
                JTextArea ob3 = new JTextArea(20,30);
                ob3.setText(estadisticasTexto);
                JScrollPane ob4 = new JScrollPane(ob3);
                JOptionPane.showMessageDialog(null, ob4);

                break;
            case 1:
                int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
                for (int i=0; i<11; i++){
                    String estadisticas2 = "\tESTADISTICAS\t\n";
                    estadisticas2 += "\tEquipo Local : "+partido[0]+"\t\n";
                    switch (tipoJugador[i]) {
                        case 0:
                            Jugador arq = equipo1.get(i);
                            estadisticas2 +=((Arquero)arq).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                        case 1:
                            Jugador def = equipo1.get(i);
                            estadisticas2 +=((Defensa)def).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                        case 2:
                            Jugador med = equipo1.get(i);
                            estadisticas2 += ((Mediocampo)med).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                        case 3:
                            Jugador del = equipo1.get(i);
                            estadisticas2 += ((Delantero)del).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                    }
                }
                for (int i=0; i<11; i++){
                    String estadisticas2 = "\tESTADISTICAS\t\n";
                    estadisticas2 += "\tEquipo Visitante : "+partido[1]+"\t\n";
                    switch (tipoJugador[i]) {
                        case 0:
                            Jugador arq = equipo2.get(i);
                            estadisticas2 +=((Arquero)arq).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                        case 1:
                            Jugador def = equipo2.get(i);
                            estadisticas2 +=((Defensa)def).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                        case 2:
                            Jugador med = equipo2.get(i);
                            estadisticas2 += ((Mediocampo)med).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                        case 3:
                            Jugador del = equipo2.get(i);
                            estadisticas2 += ((Delantero)del).toString();
                            JOptionPane.showMessageDialog(null,estadisticas2);
                            break;
                    }
                }
            case 2:
                break;
        }
    }

    private static int ganador(ArrayList<Integer> stats1, ArrayList<Integer> stats2) {
        int EquipoGanador = 0;
        int goles1 = stats1.get(5);
        int goles2 = stats2.get(5);
        if(goles1>goles2){
            return EquipoGanador;    
        }else{
            if(goles2>goles1){
                EquipoGanador = 1;
                return EquipoGanador;  
            }else{
                EquipoGanador = 2;
                return EquipoGanador;
            }
        }
        
    }

    public static String[] registrarEquipo (String[]partido, int tipoEquipo){
        String localia = tipoEquipo == 1 ? "LOCAL":"VISITANTE";
        String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo "+localia);
        partido[tipoEquipo-1] = nombreEquipo;
        return partido;
    }

    public static ArrayList<Jugador> registrarJugadores (ArrayList<Jugador> equipo){
        //equipo = null;
        Jugador jugador = null;
        int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
        int[] dorsales = new int[11];
        String[] strTipoJugador = {"ARQUERO", "DEFENSA", "MEDIOCAMPISTA", "DELANTERO"};
        String nombre = "";
        int dorsal = 0;

        for (int i=0; i<11; i++){
            switch (tipoJugador[i]) {
                case 0:
                    /*String prueba = "";
                    for (int a = 0; a < 11; a++) {
                        prueba += dorsales[a] + ";";
                        JOptionPane.showMessageDialog(null, prueba);
                    }*/
                    nombre  = JOptionPane.showInputDialog("Ingrese el nombre del "+ strTipoJugador[tipoJugador[i]]);                   
                    dorsal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal"));
                    dorsales[i] = dorsal;
                    jugador = new Arquero(nombre, dorsal, "Arquero", 0, 0, 0);
                    break;
                case 1:
                    nombre  = JOptionPane.showInputDialog("Ingrese el nombre del "+ strTipoJugador[tipoJugador[i]]);
                    boolean control = false;
                    while(control == false){
                        try{
                            dorsal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal"));
                            if(dorsal>0 && dorsal < 100){ 
                                for(int j = 0;j<i;j++){
                                    System.out.println(dorsales[j]);
                                    if(dorsales[j] == dorsal){
                                        JOptionPane.showMessageDialog(null, "El número de dorsal ya fue asignado anteriormente");  
                                        j = i;
                                    }else{
                                        dorsales[i] = dorsal;
                                        control = true;
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Debe ser un número entre 1 y 99");
                            }
                        }catch (Exception e){
                            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico del 1 al 99");
                        }
                    }
                    jugador = new Defensa(nombre, dorsal, "Defensa", 0, 0, 0, 0);
                    break;
                case 2:
                    nombre  = JOptionPane.showInputDialog("Ingrese el nombre del "+ strTipoJugador[tipoJugador[i]]);
                    control = false;
                    while(control == false){
                        try{
                            dorsal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal"));
                            if(dorsal>0 && dorsal < 100){ 
                                for(int j = 0;j<i;j++){
                                    System.out.println(dorsales[j]);
                                    if(dorsales[j] == dorsal){
                                        JOptionPane.showMessageDialog(null, "El número de dorsal ya fue asignado anteriormente");  
                                        j = i;
                                    }else{
                                        dorsales[i] = dorsal;
                                        control = true;
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Debe ser un número entre 1 y 99");
                            }
                        }catch (Exception e){
                            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico del 1 al 99");
                        }
                    }
                    jugador = new Mediocampo(nombre, dorsal, "Mediocampista", 0, 0, 0, 0);
                    break;
                case 3:
                    nombre  = JOptionPane.showInputDialog("Ingrese el nombre del "+ strTipoJugador[tipoJugador[i]]);
                    control = false;
                    while(control == false){
                        try{
                            dorsal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal"));
                            if(dorsal>0 && dorsal < 100){ 
                                for(int j = 0;j<i;j++){
                                    System.out.println(dorsales[j]);
                                    if(dorsales[j] == dorsal){
                                        JOptionPane.showMessageDialog(null, "El número de dorsal ya fue asignado anteriormente");  
                                        j = i;
                                    }else{
                                        dorsales[i] = dorsal;
                                        control = true;
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Debe ser un número entre 1 y 99");
                            }
                        }catch (Exception e){
                            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico del 1 al 99");
                        }
                    }
                    jugador = new Delantero(nombre, dorsal, "Delantero", 0, 0, 0);
                    break;
            }
            equipo.add(jugador);
        }
        return equipo;
    }

    public static void simulacionTarjetas (ArrayList<Jugador> equipo){
        int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
        for (int i=0; i<11; i++){
            switch (tipoJugador[i]) {
                case 0:
                    Jugador arq = equipo.get(i);
                    ((Arquero)arq).SimularTarjetasAmarillas(0,1);
                    ((Arquero)arq).SimularTarjetasRojas(0,1);
                    break;
                case 1:
                    Jugador def = equipo.get(i);
                    ((Defensa)def).SimularTarjetasAmarillas(0,1);
                    ((Defensa)def).SimularTarjetasRojas(0,1);
                    break;
                case 2:
                    Jugador med = equipo.get(i);
                    ((Mediocampo)med).SimularTarjetasAmarillas(0,1);
                    ((Mediocampo)med).SimularTarjetasRojas(0,1);
                    break;
                case 3:
                    Jugador del = equipo.get(i);
                    ((Delantero)del).SimularTarjetasAmarillas(0,1);
                    ((Delantero)del).SimularTarjetasRojas(0,1);
                    break;
            }
        }
    }

    public static void simulacionHabilidades (ArrayList<Jugador> equipo){
        int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
        for (int i=0; i<11; i++){
            switch (tipoJugador[i]) {
                case 0:
                    Jugador arq = equipo.get(i);
                    ((Arquero)arq).setParadas(numerosRandom(0,20));
                    break;
                case 1:
                    Jugador def = equipo.get(i);
                    ((Defensa)def).setDespejes(numerosRandom(0, 2));
                    ((Defensa)def).setRemates(numerosRandom(0, 1));
                    break;
                case 2:
                    Jugador med = equipo.get(i);
                    ((Mediocampo)med).setDespejes(numerosRandom(0, 1));
                    ((Mediocampo)med).setRemates(numerosRandom(0, 2));
                    break;
                case 3:
                    Jugador del = equipo.get(i);
                    ((Delantero)del).setRemates(numerosRandom(0, 2));
                    break;
            }
        }
    }

    public static int numerosRandom (int a, int b){
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }

    public static ArrayList<Integer> simulacionStats (ArrayList<Jugador> equipo1, ArrayList<Jugador> equipo2){

        // para la posesion
        int posesion1 = numerosRandom(1, 100);
        int posesion2 = 100 - posesion1;
        stats1.add(posesion1);
        stats2.add(posesion2);

        //para las paradas
        int paradas1 = contadorParadas(equipo1);
        int paradas2 = contadorParadas(equipo2);
        stats1.add(paradas1);
        stats2.add(paradas2);

        // para los remates
        int remates1 = contadorRemates(equipo1);
        int remates2 = contadorRemates(equipo2);
        stats1.add(remates1);
        stats2.add(remates2);

        //para las tarjetas amarillas
        int tarjetasAmarillas1 = contadorTarjetasAmarillas(equipo1);
        int tarjetasAmarillas2 = contadorTarjetasAmarillas(equipo2);
        stats1.add(tarjetasAmarillas1);
        stats2.add(tarjetasAmarillas2);

        //para las tarjetas rojas
        int tarjetasRojas1 = contadorTarjetasRojas(equipo1);
        int tarjetasRojas2 = contadorTarjetasRojas(equipo2);
        stats1.add(tarjetasRojas1);
        stats2.add(tarjetasRojas2);


        // para los goles
        int goles1 = numerosRandom(0, remates1);
        int goles2 = numerosRandom(0, remates2);
        stats1.add(goles1);
        stats2.add(goles2);

        return null;
    }

    private static int contadorTarjetasRojas(ArrayList<Jugador> equipo) {
        int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
        int contadorTarjetasRojas = 0;
        for (int i=0; i<11; i++){
            switch (tipoJugador[i]) {
                case 0:
                    Jugador arq = equipo.get(i);
                    contadorTarjetasRojas +=((Arquero)arq).getTarjetasRojas();
                    break;
                case 1:
                    Jugador def = equipo.get(i);
                    contadorTarjetasRojas += ((Defensa)def).getTarjetasRojas();
                    break;
                case 2:
                    Jugador med = equipo.get(i);
                    contadorTarjetasRojas += ((Mediocampo)med).getTarjetasRojas();
                    break;
                case 3:
                    Jugador del = equipo.get(i);
                    contadorTarjetasRojas += ((Delantero)del).getTarjetasRojas();
                    break;
            }
        }
        return contadorTarjetasRojas;
    }

    private static int contadorTarjetasAmarillas(ArrayList<Jugador> equipo) {
        int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
        int contadorTarjetasAmarillas = 0;
        for (int i=0; i<11; i++){
            switch (tipoJugador[i]) {
                case 0:
                    Jugador arq = equipo.get(i);
                    contadorTarjetasAmarillas +=((Arquero)arq).getTarjetasAmarillas();
                    break;
                case 1:
                    Jugador def = equipo.get(i);
                    contadorTarjetasAmarillas += ((Defensa)def).getTarjetasAmarillas();
                    break;
                case 2:
                    Jugador med = equipo.get(i);
                    contadorTarjetasAmarillas += ((Mediocampo)med).getTarjetasAmarillas();
                    break;
                case 3:
                    Jugador del = equipo.get(i);
                    contadorTarjetasAmarillas += ((Delantero)del).getTarjetasAmarillas();
                    break;
            }
        }
        return contadorTarjetasAmarillas;
    }

    private static int contadorParadas(ArrayList<Jugador> equipo) {
        int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
        int contadorParadas = 0;
        for (int i=0; i<11; i++){
            switch (tipoJugador[i]) {
                case 0:
                    Jugador arq = equipo.get(i);
                    ((Arquero)arq).setParadas(numerosRandom(0,20));;
                    break;
                case 1:
                    Jugador def = equipo.get(i);
                    contadorParadas += ((Defensa)def).getRemates();
                    break;
                case 2:
                    Jugador med = equipo.get(i);
                    contadorParadas += ((Mediocampo)med).getRemates();
                    break;
                case 3:
                    Jugador del = equipo.get(i);
                    contadorParadas += ((Delantero)del).getRemates();
                    break;
            }
        }
        return contadorParadas;
    }

    public static int contadorRemates(ArrayList<Jugador> equipo){
        int[] tipoJugador = {0,1,1,1,2,2,2,2,3,3,3};
        int contadorRemates = 0;
        for (int i=0; i<11; i++){
            switch (tipoJugador[i]) {
                case 0:
                    Jugador arq = equipo.get(i);
                    ((Arquero)arq).setParadas(numerosRandom(0,20));;
                    break;
                case 1:
                    Jugador def = equipo.get(i);
                    contadorRemates += ((Defensa)def).getRemates();
                    break;
                case 2:
                    Jugador med = equipo.get(i);
                    contadorRemates += ((Mediocampo)med).getRemates();
                    break;
                case 3:
                    Jugador del = equipo.get(i);
                    contadorRemates += ((Delantero)del).getRemates();
                    break;
            }
        }
        return contadorRemates;
    }
}
