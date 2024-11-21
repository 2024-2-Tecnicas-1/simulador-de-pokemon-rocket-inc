package Persistence;

import java.io.*;

public class FileConect {

    // Método para guardar un objeto en un archivo
    public static void guardar(Object objeto, String nombreArchivo) {
        File directory = new File("datos");
        if (!directory.exists()) {
            directory.mkdirs(); // Crear la carpeta 'datos' si no existe
        }

        File file = new File("datos/" + nombreArchivo);

        try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(objeto);
            System.out.println("El objeto ha sido guardado en: datos/" + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Método para leer un objeto desde un archivo
    public static Object leer(String nombreArchivo) {
        Object objeto = null;
        File file = new File("datos/" + nombreArchivo);

        if (file.exists()) {
            try (FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                objeto = in.readObject();
                System.out.println("Objeto leído: " + objeto);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo " + nombreArchivo + " no existe.");
        }

        return objeto;
    }
}
