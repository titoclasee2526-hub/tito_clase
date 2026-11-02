package es.iescanarias.tito;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App 
{
     public  static  Museo museo = new Museo();
    public static void main( String[] args )
    {
         // HILOS: pool que crea hilos nuevos según hagan falta y reutiliza los libres
        ExecutorService ejecutor = Executors.newCachedThreadPool();
 
        // HILOS: se lanzan 10 hilos "visitante que entra"...
       for (int i = 0; i < 15; i++) {
    if (i < 10) { 
        ejecutor.execute(new Entrada());
     }  // las 10 entradas, mezcladas con las salidas
    
     ejecutor.execute(new Salida());                    // las 15 salidas
}
        // HILOS: shutdown() NO para las tareas en marcha; solo avisa de que no se aceptarán más
        ejecutor.shutdown();
 
        // HILOS: espera activa hasta que TODAS las tareas hayan terminado (igual que en el ejemplo de la pág. 16).
        // Así el resumen final se imprime cuando ya nadie entra ni sale.
        while (!ejecutor.isTerminated()) {}
 
        System.out.println("\n[!] RESUMEN FINAL");
        System.out.println("Entradas totales : " + museo.getEntradas());
        System.out.println("Salidas totales  : " + museo.getSalidas());
        System.out.println("Visitantes dentro: " + museo.getVisitantes());
    

    }

public static class Entrada implements  Runnable{
    @Override 
    public void run(){museo.entrar();}

}
public static class Salida implements Runnable{
    @Override 
    public void run(){
        museo.salir();
    }
}

public static class Museo{

    private Lock bloqueo = new ReentrantLock();

    private int aforo = 100;
    private int entradas= 0;
    private int salidas = 0;

    public void entrar(){
        bloqueo.lock(); // HILOS: adquirir el lock (si lo tiene otro hilo, este espera aquí)
        try {
            aforo++;
            entradas++;

            System.out.println("[i]" + Thread.currentThread().getName() 
            + "<-- Entrada un visitante --> Inicia la visita.");
            System.out.println("  " + aforo + "nº visitantes en el museo");
            Thread.sleep(5);
        } catch (Exception e) {
        } finally{
            // HILOS: SIEMPRE en el finally; si no, una excepción dejaría el lock cogido y el resto de hilos se quedaría esperando para siempre
        bloqueo.unlock();
        }
    }

    public void salir(){
        bloqueo.lock();
        try {
            aforo--;
            salidas++;
            System.out.println("[i]" + Thread.currentThread().getName()
            +"--> Sale un visitante --> Abandona la visita");
            System.out.println("   " + aforo + "visitantes en el museo actualmente");
            Thread.sleep(5);

        } catch (InterruptedException e) {
        } finally{
            bloqueo.unlock();
        }
    }
         // Los getters también usan el lock para leer valores consistentes
        public int getVisitantes() {
            bloqueo.lock();
            try { return aforo; } finally { bloqueo.unlock(); }
        }
        public int getEntradas() {
            bloqueo.lock();
            try { return entradas; } finally { bloqueo.unlock(); }
        }
        public int getSalidas() {
            bloqueo.lock();
            try { return salidas; } finally { bloqueo.unlock(); }
        }
     }
    }


    