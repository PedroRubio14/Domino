package PartesJuego;
import Normas.DominoGeneral;
import Otros.Textos;

import java.util.ArrayList;

public class Partida {

    public Partida(DominoGeneral modoJuego) {
        this.modoJuego = modoJuego;
    }

    private DominoGeneral modoJuego;

    public void partida(){
        Tablero t = modoJuego.getTablero();
        boolean partidaFinalizada = false;
        ArrayList<Jugador> jugadores = modoJuego.getJugadores();
        jugadores.add( new Jugador("Pedro",this));
        jugadores.add( new Jugador("Ale",this));
        jugadores.add(  new Jugador("Pau",this));
        jugadores.add( new Jugador("Paco",this));
        modoJuego.setJugadores(jugadores);




        int indexPrimero = modoJuego.iniciarJuego(t);
        indexPrimero++;



        while(!partidaFinalizada){
            for (int i = indexPrimero; i<jugadores.size();i++) {
                Textos.mostrar_mano(jugadores.get(i));
                jugadores.get(i).colocar_ficha(t);
                Textos.mostrar_tablero(t);
            }
            indexPrimero= 0;

        }
    }

    public DominoGeneral getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(DominoGeneral modoJuego) {
        this.modoJuego = modoJuego;
    }


}
