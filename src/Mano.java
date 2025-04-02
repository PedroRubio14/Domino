import java.util.ArrayList;

public class Mano {
    private int fichaXjug;
    private ArrayList<Ficha> fichas_mano;

    public Mano(ArrayList<Ficha> fichasMano) {
        fichas_mano = fichasMano;
    }


    public void cogerFichas (Mazo m){
        ArrayList<Ficha> fichasMazo = m.getFichas();

        for(int i =0;i<fichaXjug;i++){
            int n = (int) Math.random() * m.getFichas().size();
            Ficha movida = fichasMazo.remove(n);
            fichas_mano.add(movida);

        }
    }


}
