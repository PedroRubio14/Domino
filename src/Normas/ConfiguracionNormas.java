package Normas;

import Otros.Textos;
import PartesJuego.Ficha;
import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.util.ArrayList;

public class ConfiguracionNormas {
    protected int numJugadores;
    protected Mazo mazo;
    protected ArrayList<Jugador> jugadores;
    protected Tablero tablero;
    protected int maxNumCara;
    protected int fichasPorJugador;
    protected int puntuacionGanadora;
    protected boolean parejas;
    protected boolean robar;
    protected int maxRepeticionFicha;
    protected boolean tableroIndividual;

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


    public void robar(Jugador j){


        ArrayList<Ficha> fichasMazo = mazo.getFichas();

        if(fichasMazo.isEmpty()){
            Textos.imprimir("robar_n",j);
        }else {
            int n = (int) (Math.random() * fichasMazo.size());
            Ficha movida = fichasMazo.remove(n);
            j.getMano().getFichas_mano().add(movida);
            Textos.imprimir("robar_s",j);

            int lado = tablero.sePotColocar(movida, 1) ? 1 : (tablero.sePotColocar(movida, 2) ? 2 : 0);

            if (lado != 0) {
                tablero.colocarFicha(j, j.getMano().getFichas_mano().size() - 1, lado);
                Textos.imprimir("robada_colocada");
            }

        }


    }

    public static boolean jugarEnPareja_true(){
        Textos.imprimir("parejas_ex");
        return true;
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

    public boolean isRobar() {
        return robar;
    }

    public int getPuntuacionGanadora() {
        return puntuacionGanadora;
    }


    public int iniciarJuego(Tablero t) {
        int [] indexMax = {0,0};
        int max =0;
        for(int i = 0; i<jugadores.size();i++){
            for(int y = 0; y<jugadores.get(i).getMano().getFichas_mano().size(); y++){
                if(jugadores.get(i).getMano().getFichas_mano().get(y).isEsDoble() && jugadores.get(i).getMano().getFichas_mano().get(y).getLadoDe()>max){
                    max = jugadores.get(i).getMano().getFichas_mano().get(y).getLadoDe();
                    indexMax[0]= i;
                    indexMax[1]= y;

                }
            }

        }
        t.colocarFicha(jugadores.get(indexMax[0]),indexMax[1],1);
        Textos.imprimir("quien_empieza",jugadores.get(indexMax[0]));
        Textos.mostrar_tablero(t);
        return indexMax[0];
    }
}
