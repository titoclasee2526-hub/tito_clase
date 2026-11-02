package es.iescanarias.tito;

public class Italiano implements Runnable {

    final private String texto = "Italiano: benvenuto es tipo Runnable";

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 11; i++) {
                System.out.println(texto);
                Thread.sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
