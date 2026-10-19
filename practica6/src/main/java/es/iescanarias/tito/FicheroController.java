package es.iescanarias.tito;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FicheroController {

    public void guardar(ArrayList<Persona> p, Fichero ficheroFile) {

        try (
                FileOutputStream fos = new FileOutputStream(ficheroFile.toString());
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oss = new ObjectOutputStream(bos)) {

            oss.writeObject(p);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Persona> leerFichero(Fichero f) {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        try (
                FileInputStream fis = new FileInputStream(f.toString());
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);

        ) {
            
            personas = (ArrayList<Persona>) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return personas;
    }

}
