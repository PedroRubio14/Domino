package Normas;
import Otros.Textos;
import PartesJuego.*;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class DominoGeneral  implements Serializable {
    protected int numJugadores;
    protected Mazo mazo;
    protected ArrayList<Jugador> jugadores;
    protected Tablero tablero;
    protected int maxNumCara;
    protected int fichasPorJugador;
    protected int puntuacionGanadora;
    protected boolean parejas;
    protected int maxRepeticionFicha;

    public DominoGeneral(int numJugadores, int maxNumCara, int fichasPorJugador, int puntuacionGanadora, boolean parejas) {
        this.numJugadores = numJugadores;
        this.mazo = new Mazo();
        this.jugadores = new ArrayList<>();
        this.tablero = new Tablero();
        this.maxNumCara = maxNumCara;
        this.fichasPorJugador = fichasPorJugador;
        this.puntuacionGanadora = puntuacionGanadora;
        this.parejas = parejas;
        this.maxRepeticionFicha = maxNumCara+1;

    }


    public int iniciarJuego(Tablero t){
        int indexJug = 0;
        int indexFicha = 0;
        int max =0;
        for(int i = 0; i<jugadores.size();i++){
            for(int y = 0; y<jugadores.get(i).getMano().getFichas_mano().size(); y++){
                if(jugadores.get(i).getMano().getFichas_mano().get(y).isEsDoble() && jugadores.get(i).getMano().getFichas_mano().get(y).getLadoDe()>max){
                    max = jugadores.get(i).getMano().getFichas_mano().get(y).getLadoDe();
                    indexJug= i;
                    indexFicha= y;

                }
            }

        }
        t.colocarFicha(jugadores.get(indexJug),indexFicha,1);
        Textos.imprimir("quien_empieza",jugadores.get(indexJug));
        Textos.mostrar_tablero(t);
        return indexJug;
    }

    public static boolean jugarEnPareja(){
        Textos.imprimir("parejas_si_no");
        String i = Textos.llegirString();
        i= i.toLowerCase();
        switch (i){
            case "s":
                return true;
            case "n":
                return false;
        }
        return false;

    }


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

    public int getMaxRepeticionFicha() {
        return maxRepeticionFicha;
    }

    public int getPuntuacionGanadora() {
        return puntuacionGanadora;
    }
}
