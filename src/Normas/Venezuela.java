package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Venezuela extends DominoGeneral  implements Serializable {
    public Venezuela() {
        super(4, 6, 7, 100, true);
    }
}
