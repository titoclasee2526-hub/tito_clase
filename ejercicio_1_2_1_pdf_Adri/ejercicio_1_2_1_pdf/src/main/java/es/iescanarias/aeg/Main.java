package es.iescanarias.aeg;

public class Main {
    public static void main(String[] args) {
        Museo museo = new Museo();

        for (int i = 1; i <= 10; i++) {
            HiloEntrada entrada = new HiloEntrada(museo, "Visitante-Entrante: " + i);
            entrada.start();
        }

        for (int i = 1; i <= 15; i++) {
            HiloSalida salida = new HiloSalida(museo, "Visitante-Saliente: " + i);
            salida.start();
        }
    }
}