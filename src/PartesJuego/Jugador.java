package PartesJuego;
import Normas.DominoGeneral;
import Normas.Latin;
import Normas.Ponce;
import Normas.Robar;
import Otros.Textos;

import java.io.Serializable;

public class Jugador  implements Serializable {
    private String nombre;
    private int puntuacion;
    private Mano mano;
    private Parejas pareja;

    final int  izuierda = 1;
    final int derecha = 2;
    final int noColocar = -1;

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

    public Parejas getPareja() {
        return pareja;
    }

    public void setPareja(Parejas pareja) {
        this.pareja = pareja;
    }

    public void colocar_ficha(Tablero t, DominoGeneral dom, Partida partida){


        boolean fichaColocada = false;

        while (!fichaColocada) {
            Textos.imprimir("ficha_para_colocar");
            int nF = Textos.llegirINT();
            if (nF < this.getMano().getFichas_mano().cantidadFichas() && nF >= 0) {
                Textos.imprimir("elegir_donde_colocar");
                int nP = Textos.llegirINT();
                if(nP == izuierda || nP == derecha) {
                    if (t.sePotColocar(this.getMano().getFichas_mano().obtenerFicha(nF), nP)) {
                        t.colocarFicha(this, nF, nP);
                        fichaColocada = true;
                    }
                }

            }
            if(nF == noColocar){
                if(dom instanceof Robar){
                    ((Robar) dom).robar(this, dom);
                }else {

                    Textos.imprimir("pasar_turno",this);
                }

                if(dom instanceof Ponce){
                    ((Ponce) dom).pasarTurnoPonce(partida);
                }

                if(dom instanceof Latin){
                    ((Latin) dom).pasarTurnoLatino(partida);
                }

                break;
            }
            if(!fichaColocada){
                Textos.imprimir("Error_colocar");
            }

        }



    }


    public int getPuntuacionEnMano() {
        int total=0;
        for(Ficha f: getMano().getFichas_mano().obtenerTodasFichas()){
            total += f.getLadoDe();
            total += f.getLadoIz();

        }
        return total;
    }
}
