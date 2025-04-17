package Normas;

import Otros.Textos;
import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.io.Serializable;
import java.util.ArrayList;

public class España extends DominoGeneral  implements Serializable {
    public España() {
        super(4, new Mazo(), new ArrayList<>(), new Tablero(), 6, 7, 100, jugarEnPareja(), false);
    }


}
