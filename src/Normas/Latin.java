package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Latin extends DominoGeneral  implements Serializable {
    static int numJugadores = 4;
    static int maxNumCara = 6;
    static int fichasPorJugador = 7;
    static int puntuacionGanadora= 200;
    public Latin() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, true);
    }
}
