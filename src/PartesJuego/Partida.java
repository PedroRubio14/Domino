package PartesJuego;
import Normas.*;
import Otros.Textos;

import java.util.ArrayList;

public class Partida {

    private ConfiguracionNormas modoJuego;

    public static ConfiguracionNormas crearPartida(){
        ConfiguracionNormas juego = null;
        while(true) {
            Textos.imprimir("Elegir_modo_juego");
            int modo_juego = Textos.llegirINT();

            switch (modo_juego) {
                case 1:
                    juego = ConfPaises.españa();
                    break;
                case 2:
                    juego = ConfPaises.mexico();
                    break;
                case 3:
                    juego = ConfPaises.chile();
                    break;
                case 4:
                    juego = ConfPaises.latin();
                    break;
                case 5:
                    juego = ConfPaises.ponce();
                    break;
                case 6:
                    juego = ConfPaises.venezuela();
                    break;
                case 7:
                    juego = ConfPaises.colombia();
                    break;

            }
            if(modo_juego>0 && modo_juego<7){
                Textos.imprimir("normas_juego",juego);
                break;
            }
            Textos.imprimir("numero_no_valido");

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

        if(modoJuego.isParejas()){
            Parejas p1 = new Parejas(jugadores.get(0),jugadores.get(2));
            Parejas p2 = new Parejas(jugadores.get(1),jugadores.get(3));

        }


        boolean partidaFinalizada = false;


        while(!partidaFinalizada){

            modoJuego.getMazo().crear_fichas(modoJuego.getMaxNumCara());

            for(Jugador j: jugadores){
                j.getMano().vaciarMano();
                j.getMano().cogerFichas(modoJuego.getMazo());
            }

            int indexPrimero = modoJuego.iniciarJuego(t);
            indexPrimero++;

            boolean rondaFinalizada = modoJuego.juegoTerminado();

            while(!rondaFinalizada){
                for (int i = indexPrimero; i<jugadores.size();i++) {
                    Textos.mostrar_mano(jugadores.get(i));
                    jugadores.get(i).colocar_ficha(t,modoJuego);
                    Textos.mostrar_tablero(t);
                    if(modoJuego.victoriaRonda(jugadores.get(i))){

                        if(modoJuego.isParejas()){
                            Textos.imprimir("ganador_ronda_parejas", jugadores.get(i).getPareja());

                        } else {
                            Textos.imprimir("ganador_ronda", jugadores.get(i));
                        }

                        rondaFinalizada= true;
                        t.borrarTablero();
                        break;
                    }
                }
                indexPrimero= 0;


            }
            partidaFinalizada = modoJuego.juegoTerminado();

        }







    }

    public ConfiguracionNormas getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(ConfiguracionNormas modoJuego) {
        this.modoJuego = modoJuego;
    }


}
