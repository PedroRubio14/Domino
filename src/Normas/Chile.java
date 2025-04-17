package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class Chile extends DominoGeneral  implements Serializable {
    public Chile() {
        super(4, new Mazo(), new ArrayList<>(), new Tablero(), 6, 5, 100, jugarEnPareja(), true);
    }
}
