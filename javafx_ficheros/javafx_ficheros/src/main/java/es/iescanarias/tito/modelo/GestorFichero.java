package es.iescanarias.tito.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorFichero {
 public void guardar(String nombreFichero, String contenido) throws IOException {
        File f = new File(nombreFichero);
        FileWriter fw = new FileWriter(f);
        fw.write(contenido);
        fw.close();
    }

    public String leer(String nombreFichero) throws IOException {
        File fichero = new File(nombreFichero);
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(fichero);
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append("\r\n");
        }
        sc.close();

        return sb.toString();
    }
}
