package es.iescanarias.aeg.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrimosDAO {

    public boolean guardarEnTexto(List<Integer> numeros, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Integer numero : numeros) {
                bw.write(numero.toString());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean guardarEnBinario(List<Integer> numeros, String ruta) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta))) {
            for (Integer numero : numeros) {
                dos.writeInt(numero); 
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public long obtenerTamanoArchivo(String ruta) {
        try {
            return Files.size(Paths.get(ruta));
        } catch (IOException e) {
            return -1;
        }
    }

    public List<Integer> leerBinario(String ruta, int limite) {
        List<Integer> leidos = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
            for (int i = 0; i < limite; i++) {
                leidos.add(dis.readInt());
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
        } catch (IOException e) {
            // Error de lectura no previsto
        }
        return leidos;
    }
}
