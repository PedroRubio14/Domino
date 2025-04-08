package Normas;

import Otros.Textos;
import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.*;

import java.util.ArrayList;

public class España extends DominoGeneral{
    protected int maxNumCara = 6;
    protected int fichasPorJugador = 7;
    protected Mazo mazo = new Mazo(this);
    protected ArrayList<Jugador> jugadores = new ArrayList<>();
    protected Tablero tablero = new Tablero();


    @Override
    public void victoriaRonda() {

    }

    @Override
    public void juegoTerminado() {

    }

    @Override
    public void ganador() {

    }

    @Override
    public int iniciarJuego(Tablero t) {
        for(int i = 0; i<jugadores.size();i++){
            ArrayList<Ficha> tempMano = jugadores.get(i).getMano().getFichas_mano();
            for(int y = 0; y<tempMano.size();y++){
                if(tempMano.get(y).isEsDoble() && tempMano.get(y).getLadoDe() == 6){
                    t.colocarFicha(jugadores.get(i),y,1);
                    Textos.imprimir("Quien empieza",jugadores.get(i));
                    Textos.mostrar_tablero(t);
                    return i;
                }
            }
        }
        return 0;
    }

    @Override
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public Mazo getMazo() {
        return mazo;
    }

    @Override
    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    @Override
    public Tablero getTablero() {
        return tablero;
    }

    @Override
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public int getMaxNumCara() {
        return maxNumCara;
    }

    @Override
    public void setMaxNumCara(int maxNumCara) {
        this.maxNumCara = maxNumCara;
    }

    @Override
    public int getFichasPorJugador() {
        return fichasPorJugador;
    }

    @Override
    public void setFichasPorJugador(int fichasPorJugador) {
        this.fichasPorJugador = fichasPorJugador;
    }
}
