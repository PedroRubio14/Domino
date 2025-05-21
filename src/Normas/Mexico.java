package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Mexico extends DominoGeneral  implements Serializable, Robar {
    public Mexico() {
        super(4, 9, 7, 200, false);
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
