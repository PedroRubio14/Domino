package Normas;

import PartesJuego.Jugador;
import PartesJuego.Partida;

import java.io.Serializable;

public class Latin extends DominoGeneral  implements Serializable {
    static int numJugadores = 4;
    static int maxNumCara = 6;
    static int fichasPorJugador = 7;
    static int puntuacionGanadora= 200;
    static int penalizacionPasarTurno= 10;
    public Latin() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, true);
    }


    public void pasarTurnoLatino (Partida p){

        int turno = p.getTurnoActual();
        Jugador j = p.getJugadores().get(turno);

        int puntuacion = j.getPuntuacion() - penalizacionPasarTurno;
        j.setPuntuacion(puntuacion);

    }
}
