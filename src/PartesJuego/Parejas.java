package PartesJuego;

public class Parejas {
    private Jugador jugador1;
    private Jugador jugador2;
    private int puntos;

    public Parejas(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void sumarPuntos(){
        int puntosTotales = (jugador1.getPuntuacion()+jugador2.getPuntuacion());

        jugador1.setPuntuacion(puntosTotales);
        jugador2.setPuntuacion(puntosTotales);

        setPuntos(puntosTotales);

    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
}
