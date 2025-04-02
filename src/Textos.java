import java.util.ArrayList;

public class Textos {



    public static void mostrar_mano(Mano m){
        ArrayList<Ficha> f = m.getFichas_mano();

        for(int i = 0; i <  f.size();i++){
            System.out.println( f.get(i).toString());


        }

    }


}
