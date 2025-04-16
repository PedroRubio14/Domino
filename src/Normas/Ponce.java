package Normas;

import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.util.ArrayList;

public class Ponce extends DominoGeneral {
    public Ponce() {
        super(4, new Mazo(), new ArrayList<>(), new Tablero(), 9, 10, 200, true, true);
    }
}
