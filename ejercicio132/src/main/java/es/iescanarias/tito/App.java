package es.iescanarias.tito;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Hello world!
 *
 */
public class App 
{
 private static Registro registro = new Registro(5);
    public static void main(String[] args) {
        // HILOS: un hilo para escribir y otro para leer
        ExecutorService ejecutor = Executors.newFixedThreadPool(2);
        ejecutor.execute(new Productor());
        ejecutor.execute(new Consumidor());
        ejecutor.shutdown();
    }
 
    public static class Productor implements Runnable {
        @Override 
        public void run() {
            int valor = 1;
            try {
                
                 for (valor = 1; valor <= 20; valor++) { registro.offer(valor); }
            } catch (InterruptedException ex) {
                System.out.println("[i] Productor interrumpido.");
            }
        }
    }
 
    public static class Consumidor implements Runnable {
        @Override 
        public void run() {
            try {
                 for (int i  = 0; i <= 20; i++) { registro.remove(); }
            } catch (InterruptedException ex) {
                System.out.println("[i] Consumidor interrumpido.");
            }
        }
    }
 
    public static class Registro {
        // HILOS: cola de bloqueo limitada (tamaño fijo). Es thread-safe: no necesita lock ni condiciones.
        private ArrayBlockingQueue<Integer> cola;
 
        public Registro(int capacidad) { cola = new ArrayBlockingQueue<>(capacidad); }
 
        public void offer(int valor) throws InterruptedException {
            // HILOS: put() inserta al final; si la cola está llena, el hilo se BLOQUEA aquí hasta que haya hueco
            cola.put(valor);
            System.out.println("| Se almacena |" + valor);
            Thread.sleep((int) (Math.random() * 1000));
        }
 
        public int remove() throws InterruptedException {
            // HILOS: take() saca la cabeza; si la cola está vacía, el hilo se BLOQUEA aquí hasta que llegue un dato
            int valor = cola.take();
            System.out.println("\t\t| Se extrae |" + valor);
            Thread.sleep((int) (Math.random() * 1000));
            return valor;
        }
    
    }
}
