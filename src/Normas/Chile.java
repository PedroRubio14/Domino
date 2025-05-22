package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Chile extends DominoGeneral  implements Serializable, Robar {
    static int numJugadores = 4;
    static int maxNumCara = 6;
    static int fichasPorJugador = 5;
    static int puntuacionGanadora= 100;
    public Chile() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, jugarEnPareja());
    }
}
