package PartesJuego;

import Normas.DominoGeneral;

import java.util.ArrayList;

public class Mano {
    private int fichaXjug;
    private ArrayList<Ficha> fichas_mano;

    public Mano(DominoGeneral d) {
        this.fichaXjug = d.getFichasPorJugador();
        fichas_mano = new ArrayList<>();
    }


    public void cogerFichas (Mazo m){
        ArrayList<Ficha> fichasMazo = m.getFichas();
        ArrayList<Ficha> fichasMano = new ArrayList<>();

        for(int i =0;i<fichaXjug;i++){
            int n = (int) (Math.random() * fichasMazo.size());
            Ficha movida = fichasMazo.remove(n);
            fichasMano.add(movida);

        }
        m.setFichas(fichasMazo);
        this.setFichas_mano(fichasMano);
    }

    public void vaciarMano(){
        fichas_mano.clear();
    }

    public ArrayList<Ficha> getFichas_mano() {
        return fichas_mano;
    }

    public void setFichas_mano(ArrayList<Ficha> fichas_mano) {
        this.fichas_mano = fichas_mano;
    }
}
