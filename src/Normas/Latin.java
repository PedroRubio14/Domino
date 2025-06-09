package Normas;

import java.io.Serializable;

public class Latin extends DominoGeneral  implements Serializable {
    static int numJugadores = 4;
    static int maxNumCara = 6;
    static int fichasPorJugador = 7;
    static int puntuacionGanadora= 200;
    public Latin() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, true);
    }
}
