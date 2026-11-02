package es.iescanarias.tito;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        /*
         * Thread hilo = new Thread(() -> {
         * System.out.println("Aleman: wilkomen es de tipo proceso");
         * }).start();
         * };
         */

        // Italiano implementa Runnable
        Thread hiloItlThread = new Thread(new Italiano());
        hiloItlThread.setPriority(Thread.MIN_PRIORITY);
        // Ingles extiende de Threads

        Thread ingThread = new Ingles();
        ingThread.setPriority(Thread.NORM_PRIORITY);
        // Aleman se crea aqui pero no necesita crear la clase Aleman como hice yo
        /*
         * new Thread(() -> {
         * try {
         * for (int i = 0; i <= 10 ; i++) {
         * System.out.println("Aleman");
         * 
         * //Si usas sleep tiene que usar un try catch porque el método Thread.sleep()
         * lanza una excepción verificada llamada InterruptedException
         * 
         * Thread.sleep(500);
         * }
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * }).start();
         */

        Thread alemanThread = new Thread(() -> {
            for (int i = 0; i <= 13; i++) {
                System.out.println("Aleman: wilkomen es de tipo proceso");
            }
        });

        ingThread.start();
        alemanThread.start();
        hiloItlThread.start();

    }
}