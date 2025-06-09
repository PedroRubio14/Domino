package Normas;

import Otros.Textos;
import PartesJuego.Ficha;
import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Venezuela extends DominoGeneral  implements Serializable {

    static int numJugadores = 4;
    static int maxNumCara = 6;
    static int fichasPorJugador = 7;
    static int puntuacionGanadora= 100;

    public Venezuela() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, true);
    }

    @Override
    public boolean juegoTerminado() {
        int minPuntos = puntuacionGanadora;
        Jugador ganador = null;
        for(Jugador j: jugadores){
            if(j.getPuntuacion()>= puntuacionGanadora) {

                for(Jugador j2: jugadores){
                    if(j2.getPuntuacion() < minPuntos){
                        ganador = j2;
                        minPuntos = j2.getPuntuacion();
                    }
                }

                Textos.imprimir("ganador", ganador);
                return true;
            }
        }
        return false;

    }

    @Override
    public void contarPuntos(Jugador j){
        boolean parejas = (j.getPareja() != null);
        int puntos = 0;

        if(parejas){
            Jugador j1 = j.getPareja().getJugador1();
            Jugador j2 = j.getPareja().getJugador2();

            for (Ficha f : j1.getMano().getFichas_mano().obtenerTodasFichas()) {
                puntos += f.getLadoDe() + f.getLadoIz();
            }

            for (Ficha f : j2.getMano().getFichas_mano().obtenerTodasFichas()) {
                puntos += f.getLadoDe() + f.getLadoIz();
            }

            j.setPuntuacion(puntos);
            j.getPareja().sumarPuntos();

        } else {

            for (Ficha f : j.getMano().getFichas_mano().obtenerTodasFichas()) {
                puntos += f.getLadoDe() + f.getLadoIz();
            }

            j.setPuntuacion(puntos);
        }

    }



    @Override
    public String toString(){
        return "ESTAS SON LAS NORMAS DEL MODO DE JUEGO ELEJIDO: \n" +
                "Esta partida tendra "+numJugadores +" Jugadores. \n" +
                "Va a tener fichas del 0 al "+ maxNumCara +". \n" +
                "Se van a repartir "+fichasPorJugador+" fichas por jugador. \n" +
                "El primer jugador que tenga "+puntuacionGanadora+" puntos, acumulados en todas las rondas, pierde. \n" +
                "Para ganar sera necesario tener la menor cantidad de puntos posbiles en el momento en el que alguien pierda. \n" +
                "Cunado alquien se quede sin fichas el resto deberan sumarse los puntos de las fichas que tienen en las manos. \n"+
                "Se van a hacer rondas, hasta que algun jugador o pareja llegue a ese total de puntos, va a empezar el jugador con el doble mas alto. \n" +
                "MUCHA SUERTE!!";
    }



}
