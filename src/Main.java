public class Main {
    public static void main(String[] args){
        Pais pa = new Pais();
        Partida p = new Partida(pa,1);

        Mano m = new Mano(p);
    }

}
