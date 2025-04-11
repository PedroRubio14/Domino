package Normas;
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

    public DominoGeneral(int numJugadores, Mazo mazo, ArrayList<Jugador> jugadores, Tablero tablero, int maxNumCara, int fichasPorJugador, int puntuacionGanadora, boolean parejas) {
        this.numJugadores = numJugadores;
        this.mazo = mazo;
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.maxNumCara = maxNumCara;
        this.fichasPorJugador = fichasPorJugador;
        this.puntuacionGanadora = puntuacionGanadora;
        this.parejas = parejas;

    }

    public abstract boolean victoriaRonda(Jugador j);
    public abstract boolean juegoTerminado();
    public abstract void ganador();
    public abstract int iniciarJuego(Tablero t);
    public abstract void contarPuntos(Jugador j);

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

    public void setFichasPorJugador(int fichasPorJugador) {
        this.fichasPorJugador = fichasPorJugador;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getPuntuacionGanadora() {
        return puntuacionGanadora;
    }

    public void setPuntuacionGanadora(int puntuacionGanadora) {
        this.puntuacionGanadora = puntuacionGanadora;
    }

    public boolean isParejas() {
        return parejas;
    }

    public void setParejas(boolean parejas) {
        this.parejas = parejas;
    }
}