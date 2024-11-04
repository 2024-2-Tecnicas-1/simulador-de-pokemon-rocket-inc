package BusinessLogic;

import Persistence.FileConect;

public class FileControl {

    public void guardar(Object objeto, String nombreArchivo) {
        FileConect.guardar(objeto, nombreArchivo);
    }

    public Object leer(String nombreArchivo) {
        return FileConect.leer(nombreArchivo);
    }
}
