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



    public void añadirFinal(Ficha f){
        this.fichas_mesa.add(f);
    }

    public void añadirPrincipio(Ficha f){
        this.fichas_mesa.add(0,f);
    }



    public boolean sePotColocar(Ficha f, int pos){
        int lon = this.fichas_mesa.size();

        if(lon == 0){
            return true;
        }

        if(pos == 1 && this.fichas_mesa.get(0).getLadoIz() == f.getLadoDe()){
            return true;
        }
        if(pos == 1 && this.fichas_mesa.get(0).getLadoIz() == f.getLadoIz()){
            f.darLaVuelta();
            return true;
        }


        if(pos == 2 && this.fichas_mesa.get(lon-1).getLadoDe() == f.getLadoIz()){
            return true;
        }
        if(pos == 2 && this.fichas_mesa.get(lon-1).getLadoDe() == f.getLadoDe()){
            f.darLaVuelta();
            return true;
        }

        return false;

    }

    public void colocarFicha(Jugador j, int indexFicha, int posicion){
        Ficha f = j.getMano().getFichas_mano().remove(indexFicha);

        if(posicion == 1){
            añadirPrincipio(f);
        } else if ( posicion == 2){
            añadirFinal(f);
        }


    }



}
