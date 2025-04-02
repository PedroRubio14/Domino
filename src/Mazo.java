import java.util.ArrayList;

public class Mazo {
    private ArrayList<Ficha> fichas;

    public Mazo(int n) {
        this.fichas = crear_fichas(n);

    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }
    public ArrayList<Ficha> crear_fichas(int num){
        ArrayList<Ficha> f = null;
        num++;

        for(int i = 0; i < num; i++){
            for(int y = 0; y <num; y++){
                f.add(new Ficha(i,y));
            }
        }

        return f;
    }


}
