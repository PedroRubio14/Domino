package Normas;

import Otros.Textos;
import PartesJuego.Ficha;
import PartesJuego.Jugador;
import PartesJuego.Mazo;
import PartesJuego.Tablero;

import java.util.ArrayList;

public class Ponce extends DominoGeneral{
    public Ponce() {
        super(4, new Mazo(), new ArrayList<>(), new Tablero(), 9, 7, 200, jugarEnPareja(), true);
    }



    public static boolean jugarEnPareja(){
        Textos.imprimir("parejas_ex");
        return true;


    }

    @Override
    public void robar(Jugador j){
        ArrayList<Ficha> fichasMazo = mazo.getFichas();

        int n = (int) (Math.random() * fichasMazo.size());
        Ficha movida = fichasMazo.remove(n);
        j.getMano().getFichas_mano().add(movida);
    }




    @Override
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


