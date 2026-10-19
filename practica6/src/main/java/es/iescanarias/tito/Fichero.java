package es.iescanarias.tito;

import java.io.File;

public class Fichero {

    private File fichero;

    public Fichero(String ruta) {
        this.fichero = new File(ruta);
    }

    @Override
    public String toString() {
        return fichero.getPath();
    }
    

  
 
}
