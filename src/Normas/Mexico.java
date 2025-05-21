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
}
