package es.iescanarias.tito;

public class Ingles extends Thread {

    final private String texto = "Ingles: Welcome es de tipo Thread";

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.println(texto);
                Thread.sleep(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
