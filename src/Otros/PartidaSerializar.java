package Otros;

import PartesJuego.Partida;

import java.io.*;

public class PartidaSerializar {


    public static void guardar(Partida partida, String nomFitxer) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFitxer + ".ser"))) {
            oos.writeObject(partida);
        }
    }


    public static Partida cargar(String nomFitxer) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFitxer + ".ser"))) {
            return (Partida) ois.readObject();
        }
    }
}
