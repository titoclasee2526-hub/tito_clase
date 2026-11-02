package es.iescanarias.tito;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService ejecutor = Executors.newFixedThreadPool(3);

        ejecutor.execute(new ImprimeChar('a', 10));
        ejecutor.execute(new ImprimeChar('b', 20));
        ejecutor.execute(new ImprimeNumero(30));

        ejecutor.shutdown();

    }
}
