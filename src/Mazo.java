import java.util.ArrayList;

public class Mazo {
    private ArrayList<Ficha> fichas;

    public Mazo(Partida p) {
        this.fichas = new ArrayList<>();
        crear_fichas(p);

    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }


    public void crear_fichas(Partida p){
        ArrayList<Ficha> f = new ArrayList<>();
        int num = p.getNumFicha()+1;

        for(int i = 0; i < num; i++){
            for(int y = i; y <num; y++){
                f.add(new Ficha(i,y));
            }
        }

        setFichas(f);
    }


}
