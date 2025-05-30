package PartesJuego;

import Normas.*;
import Otros.PartidaSerializar;
import Otros.Textos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InicioJuego {

    final static int nuevaPartida = 1;
    final static int recuperarPartida = 2;


    public static void empezar_recuperar() throws IOException, ClassNotFoundException {
        boolean empezar = true;
        while (empezar) {
            Textos.imprimir("empezar o recuperar");
            int eleccion = Textos.llegirINT();
            if (eleccion == nuevaPartida || eleccion == recuperarPartida) {
                switch (eleccion) {
                    case nuevaPartida:
                        Partida p = new Partida();
                        crearPartida(p);
                        p.juego();
                        empezar = false;
                        break;

                    case recuperarPartida:
                        mostrarPartidasGuardadas();
                        Textos.imprimir("ElegirPartida");
                        String id = Textos.llegirString();
                        Partida partidaCargada = PartidaSerializar.cargar(id);
                        if (partidaCargada != null) {
                            Textos.mostrar_tablero(partidaCargada.getModoJuego().getTablero());
                            partidaCargada.juego();
                            empezar = false;
                        } else {
                            Textos.imprimir("Error Recuperar");
                        }
                        break;
                }
            }
        }
    }

    private static void mostrarPartidasGuardadas() {
        File carpeta = new File(".");
        File[] archivos = carpeta.listFiles((dir, name) -> name.startsWith("partida_") && name.endsWith(".ser"));

        List<String> ids = new ArrayList<>();
        if (archivos != null) {
            for (File archivo : archivos) {
                String nombre = archivo.getName();
                String id = nombre.substring("partida_".length(), nombre.length() - ".ser".length());
                ids.add(id);
            }
        }

        Textos.imprimir("mostrar_partidas_guardadas", ids);
    }




    public static void crearPartida(Partida p){
        DominoGeneral juego = null;
        while(true) {
            Textos.imprimir("Elegir_modo_juego");
            int modo_juego = Textos.llegirINT();

            switch (modo_juego) {
                case 1:
                    juego = new España();
                    break;
                case 2:
                    juego =  new Mexico();
                    break;
                case 3:
                    juego = new Chile();
                    break;
                case 4:
                    juego = new Latin();
                    break;
                case 5:
                    juego = new Ponce();
                    break;
                case 6:
                    juego = new Venezuela();
                    break;
                case 7:
                    juego =  new Colombia();
                    break;

            }
            if(modo_juego>0 && modo_juego<8){
                Textos.imprimirTexto(juego.toString());
                break;
            }
            Textos.imprimir("numero_no_valido");

        }
        p.setModoJuego(juego);

        if(p.getModoJuego().isParejas()){
            Textos.imprimir("parejas_ex");
        }

        Tablero t = p.getModoJuego().getTablero();

        ArrayList<Jugador> jugadores = p.getModoJuego().getJugadores();

        p.setJugadores(jugadores);

        DominoGeneral modoJuego = p.getModoJuego();

        for(int i = 0;i<modoJuego.getNumJugadores();i++){
            Textos.imprimir("iniciar_usuario",(Integer) i);
            String nombre = Textos.llegirString();
            Jugador j= new Jugador(nombre, p);
            jugadores.add(j);
        }

        modoJuego.getMazo().crear_fichas(modoJuego.getMaxNumCara());
        for(Jugador j : jugadores){
            j.getMano().cogerFichas(modoJuego.getMazo());
        }

        modoJuego.setJugadores(jugadores);

        if(modoJuego.isParejas()){
            Parejas p1 = new Parejas(jugadores.get(0),jugadores.get(2));
            Parejas p2 = new Parejas(jugadores.get(1),jugadores.get(3));

        }

        p.setTurnoActual(modoJuego.iniciarJuego(t)+1);


    }
}
