package PartesJuego;

import java.io.Serializable;
import java.util.ArrayList;

public class Mazo  implements Serializable {
    private GrupoFichas fichas;

    public Mazo() {
        this.fichas = new GrupoFichas();

    }

    public GrupoFichas getFichas() {
        return fichas;
    }

    public void setFichas(GrupoFichas fichas) {
        this.fichas = fichas;
    }


    public void crear_fichas(int n){
        GrupoFichas f = new GrupoFichas();
        int num = n;

        for(int i = 0; i <= num; i++){
            for(int y = i; y <= num; y++){
                f.agregarFicha(new Ficha(i,y));
            }
        }

        setFichas(f);
    }


}
