package Otros;

import Normas.ConfiguracionNormas;
import Normas.DominoGeneral;
import PartesJuego.Ficha;
import PartesJuego.Jugador;
import PartesJuego.Parejas;
import PartesJuego.Tablero;

import java.util.*;
import java.util.function.Function;

public class Textos {
    static Scanner sc = new Scanner(System.in);

    public static int llegirINT(){
        while (true) {
            try {
                int i = sc.nextInt();
                sc.nextLine(); // limpiar el salto de línea
                return i;
            } catch (InputMismatchException e) {
                System.out.println("No se ha introducido un número válido. Inténtalo de nuevo:");
                sc.nextLine();
            }
        }
    }

    public static String llegirString (){
        return sc.nextLine();
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

    private static final Map<String, Function<Object[], String>> mensajes = new HashMap<>();

    static {
        mensajes.put("ficha_para_colocar", args ->
                "Indica la posición de la ficha que quieres colocar: si no puedes colocar ninguna, pon -1."
        );

        mensajes.put("elegir_donde_colocar", args ->
                "¿Dónde quieres colocar tu ficha? Al principio: 1 ; Al final: 2"
        );

        mensajes.put("turno", args ->
                "Turno de " + ((Jugador) args[0]).getNombre()
        );

        mensajes.put("quien_empieza", args ->
                "Ha empezado " + ((Jugador) args[0]).getNombre() + " porque tenía el doble mas alto."
        );

        mensajes.put("Elegir_modo_juego", args ->
                "Español: 1  \n" +
                        "Mexicano: 2   \n" +
                        "Chileno: 3    \n" +
                        "Latino: 4     \n" +
                        "Ponce: 5      \n" +
                        "Venezolano: 6 \n" +
                        "Colombiano: 7 \n"
        );

        mensajes.put("ganador_ronda", args ->
                "ENHORABUENA " + ((Jugador) args[0]).getNombre()+" HA GANADO ESTA RONDA!! \n" +
                        "Ahora tiene "+ ((Jugador) args[0]).getPuntuacion()+" puntos."
        );

        mensajes.put("ganador_ronda_parejas", args ->
                "ENHORABUENA " + ((Parejas) args[0]).toString()+" HAN GANADO ESTA RONDA!! \n" +
                        "Ahora tiene "+ ((Parejas) args[0]).getPuntos()+" puntos."
        );

        mensajes.put("iniciar_usuario", args ->
                "Indica el nombre del jugador numero " + ((Integer) args[0]).toString()+": "
        );
        mensajes.put("mensaje_no_definido", args ->
                "mensaje no definido "
        );

        mensajes.put("Error_colocar", args ->
                "Ha ocurrido un error al colocar la ficha, intentalo de nuevo. "
        );

        mensajes.put("pasar_turno", args ->
                "El jugador " + ((Jugador) args[0]).getNombre()+" pasa de turno."
        );

        mensajes.put("ganador", args ->
                "El jugador " + ((Jugador) args[0]).getNombre()+" HA GANADO LA PARTIDA!!! \n" +
                        "TIENEN "+((Jugador) args[0]).getPuntuacion()+" PUNTOS"
        );

        mensajes.put("parejas_si_no", args ->
                "Queres jugar la partida en parejas? si: s   no: n"
        );
        mensajes.put("parejas_ex", args ->
                "Las parejas estaran formadas por los jugadores 0 i 2, y por los jugadores 1 y 3"
        );

        mensajes.put("robar_s", args ->
                "El jugador "+ ((Jugador) args[0]).getNombre()+" ha robado una ficha porque no podia poner ninguna."
        );

        mensajes.put("robar_n", args ->
                "El jugador "+ ((Jugador) args[0]).getNombre()+" no ha robado ficha porque no quedan en el mazo."
        );

        mensajes.put("robar_colocada", args ->
                "La ficha que has robado se podia colocar, y se ha colocado"
        );

        mensajes.put("numero_no_valido", args ->
                "Introduzca un numero valido"
        );

        mensajes.put("normas_juego", args ->
                "ESTAS SON LAS NORMAS DEL MODO DE JUEGO ELEJIDO: \n" +
                        "Esta partida tendra "+((ConfiguracionNormas) args[0]).getNumJugadores() +"Jugadores. \n" +
                        "Va a tener fichas del 0 al "+((ConfiguracionNormas) args[0]).getMaxNumCara()+". \n" +
                        "Se van a repartir "+((ConfiguracionNormas) args[0]).getFichasPorJugador()+" fichas por jugador. \n" +
                        "Para ganar, vas a necesitar acumular un total de "+((ConfiguracionNormas) args[0]).getPuntuacionGanadora()+" puntos, acumulados en todas las rondas. \n" +
                        "Se van a hacer rondas, hasta que algun jugador o pareja llegue a ese total de puntos, va a empezar el jugador con el doble mas alto. \n" +
                        "MUCHA SUERTE!!"
        );












    }

    public static void imprimir(String clave, Object... args) {
        Function<Object[], String> generador = mensajes.get(clave);
        if (generador != null) {
            System.out.println();
            System.out.println(generador.apply(args));
        } else {
            mensajes.get("mensaje_no_definido").apply(new Object[]{clave});
        }
    }


}
