public class Pais {
    private int puntosMax = 100;
    private int numJugadores = 4;
    private int fichasJugador = (28/4);
    private boolean parejas;
  // todo esto es provisional, se modificara segun el modo de juego o pais


    public enum paises {
        españa, mexico, llati, colombia, chile, venezuela, ponce
    }

    public int getPuntosMax() {
        return puntosMax;
    }

    public void setPuntosMax(int puntosMax) {
        this.puntosMax = puntosMax;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getFichasJugador() {
        return fichasJugador;
    }

    public void setFichasJugador(int fichasJugador) {
        this.fichasJugador = fichasJugador;
    }

    public boolean isParejas() {
        return parejas;
    }

    public void setParejas(boolean parejas) {
        this.parejas = parejas;
    }
}
