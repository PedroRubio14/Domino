package Otros;

import PartesJuego.Ficha;
import PartesJuego.Jugador;
import PartesJuego.Tablero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Textos {
    static Scanner sc = new Scanner(System.in);

    public static int llegirINT(){
        return sc.nextInt();
    }



    public static void mostrar_mano(Jugador j){
        ArrayList<Ficha> f = j.getMano().getFichas_mano();
        System.out.println();
        System.out.println(j.getNombre());

        for (Ficha ficha : f) {
            System.out.println(ficha.toString());


        }

    }

    public static void mostrar_tablero(Tablero t){
        ArrayList<Ficha> f = t.getFichas_mesa();

        for (Ficha ficha : f) {
            System.out.print(ficha.toString());


        }
    }

    public static void imprimir(String index,Object...args){
        String[][] textos = {
                {"ficha para colocar","Indica la posicion de la ficha que quieres colocar: Si no puedes colocar ninguna, pon -1"},
                {"elegir donde colocar", "Donde quieres colocar tu ficha? Al principio: 1 ; Al final: 2 ?"},
                {"turno de","Turno de"},
                {"Quien empieza","ha empezado x porque tenia el doble seis."} // arreglar esto
        };

        for(int i = 0; i<textos.length;i++){
            if(Objects.equals(index, textos[i][0])){
                System.out.println();
                System.out.println(textos[i][1]);
                break;
            }
        }
    }


}
