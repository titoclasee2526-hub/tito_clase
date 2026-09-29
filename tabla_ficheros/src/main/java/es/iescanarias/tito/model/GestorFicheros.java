package es.iescanarias.tito.model;

import java.io.*;

public class GestorFicheros {

    public void guardar(String txtArea) throws FileNotFoundException {

        try {
            FileOutputStream f = new FileOutputStream("tabla.txt", true);
            // OutputStreamWriter sirve como traductor ya que FileOutPutStream solo entiende
            // byes
            OutputStreamWriter w = new OutputStreamWriter(f);
            BufferedWriter bf = new BufferedWriter(w);
            PrintWriter pw = new PrintWriter(bf);
            pw.append(txtArea+"\n");
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String multiplicar(String txtField) {
        StringBuilder resultado = new StringBuilder();
        int num = Integer.parseInt(txtField);
        for (int i = 1; i <= 10; i++) {
            resultado.append(num + "x" + i + " = " + (num * i) + "\n");
        }
        return resultado.toString();
    }

    public String leer() throws IOException {
        StringBuilder contenidoFichero = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("tabla.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
               contenidoFichero.append(linea).append("\n");
                
            }
            
        }
        return contenidoFichero.toString();
    }

}
