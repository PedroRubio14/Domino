package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Mexico extends DominoGeneral  implements Serializable, Robar {

    static int numJugadores = 4;
    static int maxNumCara = 9;
    static int fichasPorJugador = 7;
    static int puntuacionGanadora= 200;

    public Mexico() {
        super(numJugadores, maxNumCara,fichasPorJugador ,puntuacionGanadora, false);
    }


    @Override
    public boolean victoriaRonda(Jugador j){
        if (j.getMano().getFichas_mano().isEmpty()) {
            contarPuntos(j);
            return true;
        }

        if (this.getTablero().tableroBloqueado(this.getMaxRepeticionFicha())) {
            int puntosJugador = j.getPuntuacionEnMano();

            for (Jugador otro : jugadores) {
                if (otro == j) continue;
                if (otro.getPuntuacionEnMano() < puntosJugador) {
                    return false;
                }
            }
            return true;
        }

        return false;

    }
}
