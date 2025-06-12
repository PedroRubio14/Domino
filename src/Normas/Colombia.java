package Normas;

import PartesJuego.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Colombia extends DominoGeneral  implements Serializable {
    static int numJugadores = 4;
    static int maxNumCara = 6;
    static int fichasPorJugador = 7;
    static int puntuacionGanadora= 100;
    public Colombia() {
        super(numJugadores, maxNumCara, fichasPorJugador, puntuacionGanadora, true);
    }

    public boolean puedePasar(Jugador j){
        GrupoFichas manoJugador = j.getMano().getFichas_mano();

        for(int i = 0; i < manoJugador.cantidadFichas(); i++){
            if((this.tablero.sePotColocar(manoJugador.obtenerFicha(i),1))
                    || (this.tablero.sePotColocar(manoJugador.obtenerFicha(i),2))){

                return false;

            }
        }
        return true;
    }


}
