package PartesJuego;


import Otros.Textos;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private Mano mano;

    public Jugador(String nombre, Partida p) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.mano = new Mano(p.getModoJuego());
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }


    public void colocar_ficha(Tablero t){
        Textos.imprimir("ficha_para_colocar");
        int nF = Textos.llegirINT();
        if(nF != -1){
            Textos.imprimir("elegir_donde_colocar");
            int nP = Textos.llegirINT();
            if(t.sePotColocar(this.getMano().getFichas_mano().get(nF),nP)){
                t.colocarFicha(this,nF,nP);
            }

        }



    }



}
