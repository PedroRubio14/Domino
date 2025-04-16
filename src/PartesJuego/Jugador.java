package PartesJuego;
import Normas.DominoGeneral;
import Otros.Textos;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private Mano mano;
    private Parejas pareja;

    public Jugador(String nombre, Partida p) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.mano = new Mano(p.getModoJuego());
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Parejas getPareja() {
        return pareja;
    }

    public void setPareja(Parejas pareja) {
        this.pareja = pareja;
    }

    public void colocar_ficha(Tablero t, DominoGeneral dom){
        boolean fichaColocada = false;

        while (!fichaColocada) {
            Textos.imprimir("ficha_para_colocar");
            int nF = Textos.llegirINT();
            if (nF < this.getMano().getFichas_mano().size() && nF >= 0) {
                Textos.imprimir("elegir_donde_colocar");
                int nP = Textos.llegirINT();
                if(nP == 1 || nP == 2) {
                    if (t.sePotColocar(this.getMano().getFichas_mano().get(nF), nP)) {
                        t.colocarFicha(this, nF, nP);
                        fichaColocada = true;
                    }
                }

            }
            if(nF == -1){
                if(dom.isRobar()){
                    dom.robar(this);
                }else {
                    Textos.imprimir("pasar_turno",this);
                }

                break;
            }
            if(!fichaColocada){
                Textos.imprimir("Error_colocar");
            }

        }



    }


    public int getPuntuacionEnMano() {
        int total=0;
        for(Ficha f: getMano().getFichas_mano()){
            total += f.getLadoDe();
            total += f.getLadoIz();

        }
        return total;
    }
}
