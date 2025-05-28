package PartesJuego;

import Normas.*;
import Otros.PartidaSerializar;
import Otros.Textos;

import java.io.IOException;
import java.util.ArrayList;

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
                        Partida partidaCargada = PartidaSerializar.cargar("partida_test");
                        if(partidaCargada != null){
                            Textos.mostrar_tablero(partidaCargada.getModoJuego().getTablero());
                            partidaCargada.juego();
                            empezar = false;
                        }

                        break;
                }


            }
        }
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
            if(modo_juego>0 && modo_juego<7){
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
