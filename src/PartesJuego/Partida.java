package PartesJuego;
import Normas.DominoGeneral;
import Normas.España;
import Otros.Textos;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

public class Partida {

    public Partida() {
        Textos.imprimir("Elegir_modo_juego");
        int modo_juego = Textos.llegirINT();
        DominoGeneral juego = null;

        switch(modo_juego){
            case 1:
                juego = new España();
                break;
           /* case 2:
                juego = new Mexico();
                break;
            case 3:
                juego = new Chileno();
                break;
            case 4:
                juego = new Latino();
                break;
            case 5:
                juego = new Ponce();
                break;
            case 6:
                juego = new Venezolano();
                break;
            case 1:
                juego = new Colombiano();
                break;*/

        }
        this.modoJuego = juego;
    }

    private DominoGeneral modoJuego;

    public void partida(){
        Tablero t = modoJuego.getTablero();

        ArrayList<Jugador> jugadores = modoJuego.getJugadores();
        jugadores.add( new Jugador("Pedro",this));
        jugadores.add( new Jugador("Ale",this));
        jugadores.add(  new Jugador("Pau",this));
        jugadores.add( new Jugador("Paco",this));
        modoJuego.setJugadores(jugadores);




        int indexPrimero = modoJuego.iniciarJuego(t);
        indexPrimero++;


        boolean partidaFinalizada = false;
        boolean rondaFinalizada = false;

        while(!partidaFinalizada){

            while(!rondaFinalizada){
                for (int i = indexPrimero; i<jugadores.size();i++) {
                    Textos.mostrar_mano(jugadores.get(i));
                    jugadores.get(i).colocar_ficha(t);
                    Textos.mostrar_tablero(t);
                    if(modoJuego.victoriaRonda(jugadores.get(i))){
                        Textos.imprimir("ganador_ronda", jugadores.get(i));
                        rondaFinalizada = true;
                        break;
                    }
                }
                indexPrimero= 0;

            }



        }

    }

    public DominoGeneral getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(DominoGeneral modoJuego) {
        this.modoJuego = modoJuego;
    }


}
