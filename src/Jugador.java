public class Jugador {
    private String nombre;
    private int puntuacion;
    private Mano mano;

    public Jugador(String nombre, Partida p) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.mano = new Mano(p);
    }
}
