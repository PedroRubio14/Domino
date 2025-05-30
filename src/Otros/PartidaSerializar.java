package Otros;

import PartesJuego.Partida;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PartidaSerializar {

    public static String obtenerNuevoIDLibre() {
        File carpeta = new File(".");
        File[] archivos = carpeta.listFiles((dir, name) -> name.startsWith("partida_") && name.endsWith(".ser"));

        Set<Integer> idsExistentes = getIntegers(archivos);

        int nuevoID = 1;
        while (idsExistentes.contains(nuevoID)) {
            nuevoID++;
        }

        return String.valueOf(nuevoID);
    }

    private static Set<Integer> getIntegers(File[] archivos) {
        Set<Integer> idsExistentes = new HashSet<>();
        if (archivos != null) {
            for (File archivo : archivos) {
                String nombre = archivo.getName();
                String idStr = nombre.substring("partida_".length(), nombre.length() - ".ser".length());
                try {
                    idsExistentes.add(Integer.parseInt(idStr));
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return idsExistentes;
    }


    public static void guardar(Partida partida) throws IOException {
        String filename = "partida_" + partida.getId() + ".ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(partida);
        }
    }

    public static Partida cargar(String id) {
        String filename = "partida_" + id + ".ser";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Partida) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Textos.imprimir("Error Recuperar");
            return null;
        }
    }
}
