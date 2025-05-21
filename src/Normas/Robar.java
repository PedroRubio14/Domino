package Normas;

import Otros.Textos;
import PartesJuego.Ficha;
import PartesJuego.Jugador;
import PartesJuego.Tablero;

import java.util.ArrayList;

public interface Robar {

    default void robar(Jugador j,DominoGeneral dom){


        ArrayList<Ficha> fichasMazo = dom.getMazo().getFichas();

        Tablero tablero = dom.getTablero();

        if(fichasMazo.isEmpty()){
            Textos.imprimir("robar_n",j);
        }else {
            int n = (int) (Math.random() * fichasMazo.size());
            Ficha movida = fichasMazo.remove(n);
            j.getMano().getFichas_mano().add(movida);
            Textos.imprimir("robar_s",j);

            int lado = tablero.sePotColocar(movida, 1) ? 1 : (tablero.sePotColocar(movida, 2) ? 2 : 0);

            if (lado != 0) {
                tablero.colocarFicha(j, j.getMano().getFichas_mano().size() - 1, lado);
                Textos.imprimir("robada_colocada");
            }

        }


    }
}
