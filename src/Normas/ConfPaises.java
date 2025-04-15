package Normas;

import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.util.ArrayList;

public class ConfPaises {
    public static ConfiguracionNormas españa(){
        ConfiguracionNormas c = normasComunes();
        c.puntuacionGanadora = 100;
        c.parejas = ConfiguracionNormas.jugarEnPareja();
        c.robar = false;
        c.maxRepeticionFicha = 6+1;
        c.tableroIndividual = false;
        c.maxNumCara = 6;
        c.fichasPorJugador = 7;

        return c;

    }
    public static ConfiguracionNormas chile(){
        ConfiguracionNormas c = normasComunes();
        c.maxNumCara = 6;
        c.fichasPorJugador = 5;
        c.puntuacionGanadora = 100;
        c.parejas = ConfiguracionNormas.jugarEnPareja();
        c.robar = true;
        c.maxRepeticionFicha = 7 +1;
        c.tableroIndividual = false;

        return c;

    }

    public static ConfiguracionNormas colombia(){
        ConfiguracionNormas c = normasComunes();
        c.puntuacionGanadora = 200;
        c.parejas = ConfiguracionNormas.jugarEnPareja_true();
        c.robar = false;
        c.maxRepeticionFicha = 6 +1;
        c.tableroIndividual = false;
        c.maxNumCara = 6;
        c.fichasPorJugador = 7;

        return c;

    }

    public static ConfiguracionNormas ponce(){
        ConfiguracionNormas c = normasComunes();
        c.puntuacionGanadora = 200;
        c.parejas = ConfiguracionNormas.jugarEnPareja_true();
        c.robar = true;
        c.maxRepeticionFicha = 9 +1;
        c.tableroIndividual = false;
        c.maxNumCara = 9;
        c.fichasPorJugador = 10;

        return c;

    }

    public static ConfiguracionNormas mexico(){
        ConfiguracionNormas c = normasComunes();
        c.puntuacionGanadora = 200;
        c.parejas = false;
        c.robar = true;
        c.maxRepeticionFicha =9 +1;
        c.tableroIndividual = true;
        c.maxNumCara = 9;
        c.fichasPorJugador = 7;

        return c;

    }

    public static ConfiguracionNormas latin(){
        ConfiguracionNormas c = normasComunes();
        c.puntuacionGanadora = 200;
        c.parejas = ConfiguracionNormas.jugarEnPareja_true();
        c.robar = false;
        c.maxRepeticionFicha = 9 +1;
        c.tableroIndividual = false;
        c.maxNumCara = 6;
        c.fichasPorJugador = 7;

        return c;

    }
    public static ConfiguracionNormas venezuela(){
        ConfiguracionNormas c = normasComunes();
        c.puntuacionGanadora = 100;
        c.parejas = ConfiguracionNormas.jugarEnPareja_true();
        c.robar = false;
        c.maxRepeticionFicha = 6 +1;
        c.tableroIndividual = false;
        c.maxNumCara = 6;
        c.fichasPorJugador = 7;

        return c;

    }

    public static ConfiguracionNormas normasComunes() {
        ConfiguracionNormas c = new ConfiguracionNormas();
        c.numJugadores = 4;
        c.mazo = new Mazo();
        c.jugadores = new ArrayList<>();
        c.tablero = new Tablero();


        return c;
    }
}
