package  es.iescanarias.tito.model;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrimosDAO {

/**
     * Guarda una lista de enteros en un archivo de TEXTO,
     * un número por línea (se puede abrir con cualquier editor).
     */
    public void guardar(List<Integer> num, String path) {
        // try-with-resources: abre el archivo y lo cierra solo al terminar.
        // FileWriter escribe caracteres en el archivo (lo crea o lo sobrescribe).
        // BufferedWriter añade un búfer en memoria, así escribe más rápido
        // porque agrupa los datos en vez de escribir uno a uno en disco.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            // Recorre cada número de la lista
            for (Integer integer : num) {
                // Convierte el número a String y lo escribe en el archivo
                bw.write(integer.toString());
                // Escribe un salto de línea, así cada número queda en su propia línea
                bw.newLine();
            }

        } catch (Exception e) {
            // Si algo falla (ruta inválida, sin permisos...) muestra el error por consola
            e.printStackTrace();
        }
    }

    
     // Guarda una lista de enteros en un archivo BINARIO.
     // Cada número ocupa exactamente 4 bytes, sin separadores.
     // El archivo no se puede leer con un editor de texto;
     // se lee de vuelta con DataInputStream.readInt().
     
    
     
    public void guardarEnBinario(List<Integer> num, String path) {
        // FileOutputStream abre el archivo para escribir bytes crudos (lo crea o lo sobrescribe).
        // DataOutputStream permite escribir tipos de Java (int, long...) directamente.
        // El try-with-resources lo cierra automáticamente al terminar.
        try (DataOutputStream data = new DataOutputStream(new FileOutputStream(path))) {

            // Recorre cada número de la lista
            for (Integer integer : num) {
                // Escribe el entero como 4 bytes (big-endian)
                data.writeInt(integer);
            }

        } catch (Exception e) {
            // Si algo falla, muestra el error por consola
            e.printStackTrace();
        }
    }

   
    public int tamanoArchivo(String path) throws IOException {
        // Paths.get(path): convierte el String en un objeto Path (ruta)
        // Files.size(...): obtiene el tamaño del archivo en bytes (devuelve long)
        // (int): convierte el long a int; se desborda si el archivo supera ~2 GB
        return (int) Files.size(Paths.get(path));
    }




   public List<Integer> leerBinario(String ruta) {
    // Lista donde se van a guardar los enteros que lea
    List<Integer> leidos = new ArrayList<>();

    // try-with-resources: abre el archivo y lo cierra solo al terminar
    // FileInputStream abre el archivo como bytes crudos
    // DataInputStream permite leer tipos de Java (int, long...) directamente hace como un traduccion para java
    try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {

        // Bucle infinito: solo se sale cuando se acaba el archivo (EOFException)
        while (true) {
            // Lee 4 bytes, los convierte en un int y lo añade a la lista
            leidos.add(dis.readInt());
        }

    } catch (EOFException e) {
        // Se llegó al final del archivo: es la forma normal de terminar,
        // así que no hacemos nada y pasamos al return
    } catch (IOException e) {
        // Cualquier otro error de lectura (archivo inexistente, sin permisos...)
        // Lo mostramos para no esconder el fallo
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }

    // Devuelve todos los enteros leídos (lista vacía si no había ninguno)
    return leidos;
   
}
}

