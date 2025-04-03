import java.util.ArrayList;

public class Partida {
    private Pais modoJuego;
    private int numJugadores;
    private Mazo mazo;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private int numFicha = 6;

    public Partida(Pais modoJuego, int numJugadores) {
        this.modoJuego = modoJuego;
        this.numJugadores = numJugadores;
        this.mazo = new Mazo(this);
        this.tablero = new Tablero();
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }


    public void partida(){
        Tablero t = new Tablero();
        boolean partidaFinalizada = false;
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add( new Jugador("Pedro",this));
        jugadores.add( new Jugador("Ale",this));
        jugadores.add(  new Jugador("Pau",this));
        jugadores.add( new Jugador("Paco",this));




        while(!partidaFinalizada){
            for (Jugador jugadore : jugadores) {
                Textos.mostrar_mano(jugadore);
                jugadore.colocar_ficha(t);
                Textos.mostrar_tablero(t);
            }

        }
    }
}
