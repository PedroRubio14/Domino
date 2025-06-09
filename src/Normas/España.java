package Normas;

import java.io.Serializable;

public class España extends DominoGeneral  implements Serializable {
    static int numJugadores = 4;
    static int maxNumCara = 6;
    static int fichasPorJugador = 7;
    static int puntuacionGanadora= 100;
    public España() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, jugarEnPareja());
    }


}
