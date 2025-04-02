import java.util.ArrayList;

public class Tablero {
    private ArrayList<Ficha> fichas_mesa;


    public Tablero() {
        this.fichas_mesa = new ArrayList<>();
    }

    public ArrayList<Ficha> getFichas_mesa() {
        return fichas_mesa;
    }

    public void setFichas_mesa(ArrayList<Ficha> fichas_mesa) {
        this.fichas_mesa = fichas_mesa;
    }



}
