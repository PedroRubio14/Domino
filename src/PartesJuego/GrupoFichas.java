package PartesJuego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GrupoFichas implements Serializable {

    private ArrayList<Ficha> fichas;

    public GrupoFichas(){
        this.fichas = new ArrayList<>();
    }

    public GrupoFichas(List<Ficha> fichas){
        this.fichas = new ArrayList<>(fichas);
    }

    public void agregarFicha(Ficha f){
        fichas.add(f);
    }
    public Ficha quitarFicha(int indice){
        return fichas.remove(indice);
    }

    public Ficha obtenerFicha(int indice){
        return fichas.get(indice);
    }

    public boolean estaVacio(){
        return fichas.isEmpty();
    }

    public int cantidadFichas(){
        return fichas.size();
    }

    public void limpiar(){
        fichas.clear();
    }

    public ArrayList<Ficha> obtenerTodasFichas(){
        return fichas;
    }


    public void agregarAlInicio(Ficha ficha) {
        fichas.add(0, ficha);
    }

    public void agregarAlFinal(Ficha ficha) {
        fichas.add(ficha);
    }








}
