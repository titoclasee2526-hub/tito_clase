package es.iescanarias.tito.view;

import java.util.List;

public class Vista {
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println(error);
    }

    public void mostrarComparacionTamanos(long tamanoTxt, long tamanoBin) {
        System.out.println("\n--- Comparación de Tamaños ---");
        System.out.println("Tamaño del archivo de texto: " + tamanoTxt + " bytes");
        System.out.println("Tamaño del archivo binario: " + tamanoBin + " bytes");
        System.out.println("------------------------------\n");
    }

    public void mostrarNumeros(List<Integer> numeros) {
        for (Integer num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    
}
