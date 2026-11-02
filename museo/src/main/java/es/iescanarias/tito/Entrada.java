package es.iescanarias.tito;

public class Entrada implements Runnable {

    public int aforo=100;
    
    

    @Override
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            aforo++;
            System.out.println("Hilos" + nombreHilo + "---Esta entrando un visitante---" + aforo 
            + "nº visitantes en el museo actualmente");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //Hacer las entrada y salidas el conteo en main con una condicion de si es un hilo de entrada o de salida
        }
    

    }
    
}
