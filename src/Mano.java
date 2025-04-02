import java.util.ArrayList;

public class Mano {
    private int fichaXjug = 5;
    private ArrayList<Ficha> fichas_mano;

    public Mano(Partida p) {
        fichas_mano = new ArrayList<>();
        cogerFichas(p.getMazo());
        Textos.mostrar_mano(this);
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

    public ArrayList<Ficha> getFichas_mano() {
        return fichas_mano;
    }

    public void setFichas_mano(ArrayList<Ficha> fichas_mano) {
        this.fichas_mano = fichas_mano;
    }
}
