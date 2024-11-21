package Persistence;

public class FileControl {

    // Delegar la acción de guardar
    public void guardar(Object objeto, String nombreArchivo) {
        FileConect.guardar(objeto, nombreArchivo);
    }

    // Delegar la acción de leer
    public Object leer(String nombreArchivo) {
        return FileConect.leer(nombreArchivo);
    }
}
