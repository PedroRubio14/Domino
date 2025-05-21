package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Ponce extends DominoGeneral  implements Serializable, Robar {
    public Ponce() {
        super(4, 9, 10, 200, true);
    }
}
