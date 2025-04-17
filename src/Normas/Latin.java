package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Latin extends DominoGeneral  implements Serializable {
    public Latin() {
        super(4, new Mazo(), new ArrayList<>(), new Tablero(), 6, 7, 200, true, false);
    }
}
