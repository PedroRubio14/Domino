package PartesJuego;

import java.io.Serializable;
import java.util.ArrayList;

public class Tablero  implements Serializable {
    private ArrayList<Ficha> fichas_mesa;
    final int  izuierda = 1;
    final int derecha = 2;



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

        if(pos == izuierda && this.fichas_mesa.get(0).getLadoIz() == f.getLadoDe()){
            return true;
        }
        if(pos == izuierda && this.fichas_mesa.get(0).getLadoIz() == f.getLadoIz()){
            f.darLaVuelta();
            return true;
        }


        if(pos == derecha && this.fichas_mesa.get(lon-1).getLadoDe() == f.getLadoIz()){
            return true;
        }
        if(pos == derecha && this.fichas_mesa.get(lon-1).getLadoDe() == f.getLadoDe()){
            f.darLaVuelta();
            return true;
        }

        return false;

    }

    public void colocarFicha(Jugador j, int indexFicha, int posicion){
        Ficha f = j.getMano().getFichas_mano().remove(indexFicha);

        if(posicion == izuierda){
            añadirPrincipio(f);
        } else if ( posicion == derecha){
            añadirFinal(f);
        }


    }

    public void borrarTablero(){
        fichas_mesa.clear();
    }

    public boolean tableroBloqueado(int maxReps){

        int tableroLado2 = fichas_mesa.get((fichas_mesa.size())-1).getLadoDe();
        int tableroLado1 = fichas_mesa.get(0).getLadoIz();
        int nlado1 = 0;
        int nlado2 = 0;

        for(Ficha f: fichas_mesa){
            if(f.getLadoIz() == tableroLado1 || f.getLadoDe() == tableroLado1){
                nlado1++;
            }
            if(f.getLadoIz() == tableroLado2 || f.getLadoDe() == tableroLado2){
                nlado2++;
            }


        }
        if(nlado1 == maxReps && nlado2 == maxReps){
            return true;
        }

        return false;
    }



}
