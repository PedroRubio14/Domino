package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.util.ArrayList;

public class Colombia extends DominoGeneral {
    public Colombia() {
        super(4, new Mazo(), new ArrayList<>(), new Tablero(), 6, 7, 100, true , false);
    }
}
