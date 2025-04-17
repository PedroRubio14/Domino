package PartesJuego;

import java.io.Serializable;
import java.util.ArrayList;

public class Mazo  implements Serializable {
    private ArrayList<Ficha> fichas;

    public Mazo() {
        this.fichas = new ArrayList<>();

    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }


    public void crear_fichas(int n){
        ArrayList<Ficha> f = new ArrayList<>();
        int num = n;

        for(int i = 0; i <= num; i++){
            for(int y = i; y <= num; y++){
                f.add(new Ficha(i,y));
            }
        }

        setFichas(f);
    }


}
