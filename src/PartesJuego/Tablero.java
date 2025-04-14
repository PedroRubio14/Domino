package PartesJuego;

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
