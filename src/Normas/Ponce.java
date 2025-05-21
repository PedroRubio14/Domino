package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Partida;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Ponce extends DominoGeneral  implements Serializable, Robar {
    public Ponce() {
        super(4, 9, 10, 200, true);
    }

    private final int puntosPorBloquearAlSiguiente = 5;


    public void pasarTurnoPonce(Partida p){

        int turno  = p.getTurnoActual();
        turno--;
        Jugador j = p.getJugadores().get(turno);
        int puntos = j.getPuntuacion() + puntosPorBloquearAlSiguiente;
        j.setPuntuacion(puntos);

    }

}
