package PartesJuego;

import Normas.DominoGeneral;

import java.util.ArrayList;

public class Mazo {
    private ArrayList<Ficha> fichas;

    public Mazo(DominoGeneral p) {
        this.fichas = new ArrayList<>();
        crear_fichas(p);

    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }


    public void crear_fichas(DominoGeneral p){
        ArrayList<Ficha> f = new ArrayList<>();
        int num = p.getMaxNumCara();

        for(int i = 0; i <= num; i++){
            for(int y = i; y <= num; y++){
                f.add(new Ficha(i,y));
            }
        }

        setFichas(f);
    }


}
