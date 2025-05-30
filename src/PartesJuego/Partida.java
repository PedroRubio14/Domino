package PartesJuego;
import Normas.*;
import Otros.PartidaSerializar;
import Otros.Textos;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Partida  implements Serializable {
    private DominoGeneral modoJuego;
    private ArrayList<Jugador> jugadores;
    private int turnoActual;
    private boolean partidaFinalizada;
    private final String id;

    public Partida() {
        this.id = PartidaSerializar.obtenerNuevoIDLibre();
    }



    public void juego() throws IOException {

        Tablero t = modoJuego.getTablero();
         jugadores = modoJuego.getJugadores();

        partidaFinalizada = false;


        while(!partidaFinalizada){



            boolean rondaFinalizada = modoJuego.juegoTerminado();

            while(!rondaFinalizada){
                for (int i = turnoActual; i<jugadores.size();i++) {
                    Textos.mostrar_mano(jugadores.get(i));
                    jugadores.get(i).colocar_ficha(t,modoJuego,this);
                    Textos.mostrar_tablero(t);
                    PartidaSerializar.guardar(this);
                    if(modoJuego.victoriaRonda(jugadores.get(i))){

                        rondaFinalizada= true;
                        t.borrarTablero();
                        break;
                    }
                }
                turnoActual= 0;


            }

            partidaFinalizada = modoJuego.juegoTerminado();

            modoJuego.getMazo().crear_fichas(modoJuego.getMaxNumCara());

            for(Jugador j: jugadores){
                j.getMano().vaciarMano();
                j.getMano().cogerFichas(modoJuego.getMazo());
            }

            turnoActual = modoJuego.iniciarJuego(t);
            turnoActual++;

        }







    }

    public DominoGeneral getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(DominoGeneral modoJuego) {
        this.modoJuego = modoJuego;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getId(){
        return  id;
    }


}
