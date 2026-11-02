package es.iescanarias.tito;

public class Salida implements Runnable {

    Entrada e = new Entrada();

    @Override
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        for (int i = 0; i < 15; i++) {
            e.aforo--;
            System.out.println("Hilos" + nombreHilo + "---Esta saliendo un visitante---" + e.aforo
                    + "nº visitantes en el museo actualmente");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

            // Hacer las entrada y salidas el conteo en main con una condicion de si es un
            // hilo de entrada o de salida
        }

    }
}
