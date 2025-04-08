package Normas;
import PartesJuego.*;

import java.util.ArrayList;

public abstract class DominoGeneral {
    protected Mazo mazo;
    protected ArrayList<Jugador> jugadores;
    protected Tablero tablero;
    protected int maxNumCara;
    protected int fichasPorJugador;


    public abstract void victoriaRonda();
    public abstract void juegoTerminado();
    public abstract void ganador();
    public abstract int iniciarJuego(Tablero t);

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
}