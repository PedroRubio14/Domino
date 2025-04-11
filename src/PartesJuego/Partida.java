package PartesJuego;
import Normas.DominoGeneral;
import Normas.España;
import Otros.Textos;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

public class Partida {

    private DominoGeneral modoJuego;

    public static DominoGeneral crearPartida(){
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
        return juego;
    }

    public Partida() {
        this.modoJuego = crearPartida();

    }



    public void partida(){
        Tablero t = modoJuego.getTablero();

        ArrayList<Jugador> jugadores = modoJuego.getJugadores();

        for(int i = 0;i<modoJuego.getNumJugadores();i++){
            Textos.imprimir("iniciar_usuario",(Integer) i);
            String nombre = Textos.llegirString();
            jugadores.add( new Jugador(nombre, this));
        }
        modoJuego.setJugadores(jugadores);


        boolean partidaFinalizada = false;


        while(!partidaFinalizada){

            modoJuego.getMazo().crear_fichas(modoJuego.getMaxNumCara());

            for(Jugador j: jugadores){
                j.getMano().cogerFichas(modoJuego.getMazo());
            }

            modoJuego.setTablero(new Tablero());

            int indexPrimero = modoJuego.iniciarJuego(t);
            indexPrimero++;

            boolean rondaFinalizada = modoJuego.juegoTerminado();

            while(!rondaFinalizada){
                for (int i = indexPrimero; i<jugadores.size();i++) {
                    Textos.mostrar_mano(jugadores.get(i));
                    jugadores.get(i).colocar_ficha(t);
                    Textos.mostrar_tablero(t);
                    if(modoJuego.victoriaRonda(jugadores.get(i))){
                        Textos.imprimir("ganador_ronda", jugadores.get(i));
                        rondaFinalizada= true;
                        break;
                    }
                }
                indexPrimero= 0;


            }
            partidaFinalizada = modoJuego.juegoTerminado();

        }







    }

    public DominoGeneral getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(DominoGeneral modoJuego) {
        this.modoJuego = modoJuego;
    }


}
