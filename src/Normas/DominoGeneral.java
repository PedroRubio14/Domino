package Normas;
import Otros.Textos;
import PartesJuego.*;

import java.util.ArrayList;

public abstract class DominoGeneral {
    protected int numJugadores;
    protected Mazo mazo;
    protected ArrayList<Jugador> jugadores;
    protected Tablero tablero;
    protected int maxNumCara;
    protected int fichasPorJugador;
    protected int puntuacionGanadora;
    protected boolean parejas;
    protected boolean robar;
    private int maxRepeticionFicha;

    public DominoGeneral(int numJugadores, Mazo mazo, ArrayList<Jugador> jugadores, Tablero tablero, int maxNumCara, int fichasPorJugador, int puntuacionGanadora, boolean parejas, boolean robar) {
        this.numJugadores = numJugadores;
        this.mazo = mazo;
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.maxNumCara = maxNumCara;
        this.fichasPorJugador = fichasPorJugador;
        this.puntuacionGanadora = puntuacionGanadora;
        this.parejas = parejas;
        this.robar = robar;
        this.maxRepeticionFicha = maxNumCara+1;

    }


    public abstract int iniciarJuego(Tablero t);

    public abstract void robar(Jugador j);

    public boolean victoriaRonda(Jugador j){
        if (j.getMano().getFichas_mano().isEmpty()) {
            contarPuntos(j);
            return true;
        }

        if (this.getTablero().tableroBloqueado(this.getMaxRepeticionFicha())) {
            int puntosJugador = j.getPuntuacionEnMano();

            for (Jugador otro : jugadores) {
                if (otro == j) continue;
                if (otro.getPuntuacionEnMano() < puntosJugador) {
                    return false;
                }
            }
            contarPuntos(j);
            return true;
        }

        return false;

    }
    public boolean juegoTerminado() {
        for(Jugador j: jugadores){
            if(j.getPuntuacion()>= puntuacionGanadora) {
                Textos.imprimir("ganador", j);
                return true;
            }
        }
        return false;

    }


    public void contarPuntos(Jugador j){
        boolean parejas = (j.getPareja() != null);
        int puntos = 0;

        if(parejas){
            Jugador j1 = j.getPareja().getJugador1();
            Jugador j2 = j.getPareja().getJugador2();

            for (Jugador jug : jugadores) {
                if (jug != j1 && jug != j2) {
                    for (Ficha f : jug.getMano().getFichas_mano()) {
                        puntos += f.getLadoDe() + f.getLadoIz();
                    }
                }
            }

            j.setPuntuacion(puntos);
            j.getPareja().sumarPuntos();

        } else {

            for (Jugador jug : jugadores) {
                if (jug != j) {
                    for (Ficha f : jug.getMano().getFichas_mano()) {
                        puntos += f.getLadoDe() + f.getLadoIz();
                    }
                }
            }
            j.setPuntuacion(puntos);
        }

    }


    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getMaxNumCara() {
        return maxNumCara;
    }

    public void setMaxNumCara(int maxNumCara) {
        this.maxNumCara = maxNumCara;
    }

    public int getFichasPorJugador() {
        return fichasPorJugador;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public boolean isParejas() {
        return parejas;
    }

    public void setParejas(boolean parejas) {
        this.parejas = parejas;
    }

    public int getMaxRepeticionFicha() {
        return maxRepeticionFicha;
    }

    public boolean isRobar() {
        return robar;
    }
}