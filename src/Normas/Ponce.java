package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Partida;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Ponce extends DominoGeneral  implements Serializable, Robar {

    static int numJugadores = 4;
    static int maxNumCara = 9;
    static int fichasPorJugador = 10;
    static int puntuacionGanadora= 200;
    static final int puntosPorBloquearAlSiguiente = 5;

    public Ponce() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, true);
    }




    public void pasarTurnoPonce(Partida p){

        int turno  = p.getTurnoActual();
        turno--;
        Jugador j = p.getJugadores().get(turno);
        int puntos = j.getPuntuacion() + puntosPorBloquearAlSiguiente;
        j.setPuntuacion(puntos);

    }

}
