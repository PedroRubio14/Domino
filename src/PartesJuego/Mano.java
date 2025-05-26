package PartesJuego;
import Normas.DominoGeneral;

import java.io.Serializable;
import java.util.ArrayList;

public class Mano  implements Serializable {
    private int fichaXjug;
    private GrupoFichas fichas_mano;

    public Mano(DominoGeneral d) {
        this.fichaXjug = d.getFichasPorJugador();
        fichas_mano = new GrupoFichas();
    }


    public void cogerFichas (Mazo m){
        GrupoFichas fichasMazo = new GrupoFichas(m.getFichas().obtenerTodasFichas());
        GrupoFichas fichasMano = new GrupoFichas();

        for(int i =0;i<fichaXjug;i++){
            int n = (int) (Math.random() * fichasMazo.cantidadFichas());
            Ficha movida = fichasMazo.quitarFicha(n);
            fichasMano.agregarFicha(movida);

        }
        m.setFichas(fichasMazo);
        this.setFichas_mano(fichasMano);
    }

    public void vaciarMano(){
        fichas_mano.limpiar();
    }

    public GrupoFichas getFichas_mano() {
        return fichas_mano;
    }

    public void setFichas_mano(GrupoFichas fichas_mano) {
        this.fichas_mano = fichas_mano;
    }
}
