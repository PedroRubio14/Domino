package Normas;

import Otros.Textos;
import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.*;

import java.util.ArrayList;

public class España extends DominoGeneral{

    public España() {
        super(4, new Mazo(), new ArrayList<>(),new Tablero(), 6, 7, 100,jugarEnPareja());
    }

    public static boolean jugarEnPareja(){
        Textos.imprimir("parejas_si_no");
        String i = Textos.llegirString();
        i= i.toLowerCase();
        switch (i){
            case "s":
                Textos.imprimir("parejas_ex");
                return true;
            case "n":
                return false;
        }
        return false;

    }

    @Override
    public boolean victoriaRonda(Jugador j) {
        if(j.getMano().getFichas_mano().isEmpty()){
            contarPuntos(j);
            return true;
        }
        return false;

    }

    @Override
    public boolean juegoTerminado() {
        for(Jugador j: jugadores){
            if(j.getPuntuacion()>= puntuacionGanadora){
                Textos.imprimir("ganador", j);
                return true;
            }
        }
        return false;

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
                    Textos.imprimir("quien_empieza",jugadores.get(i));
                    Textos.mostrar_tablero(t);
                    return i;
                }
            }
        }
        return 0;
    }

    @Override
    public void contarPuntos(Jugador j) {
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
}
