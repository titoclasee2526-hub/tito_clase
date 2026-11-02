package es.iescanarias.tito;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import es.iescanarias.tito.App.Productor;

/**
 * Hello world!
 *
 */
public class App 
{
     // Registro compartido entre el hilo que escribe y el que lee (capacidad 5)
    private static Registro registro = new Registro(5);
 
    public static void main(String[] args) {
        // HILOS: pool de 2 hilos, uno para el productor y otro para el consumidor
        ExecutorService ejecutor = Executors.newFixedThreadPool(2);
        ejecutor.execute(new Productor());
        ejecutor.execute(new Consumidor());
        ejecutor.shutdown(); // no admite más tareas; las dos que ya corren siguen indefinidamente
    }
 
    // Hilo que AÑADE valores al registro: 1, 2, 3, 4...
    public static class Productor implements Runnable {
        @Override 
        public void run() {
            int valor;
            try {
                // HILOS: offer() puede lanzar InterruptedException (porque hace await() y sleep()),
            // así que hay que capturarla. El try está FUERA del for: si interrumpen el hilo
            // mientras duerme o espera, se sale del bucle entero y el hilo termina.
            // Si estuviera dentro, el for seguiría con el siguiente valor ignorando la interrupción.
                for ( valor = 1 ; valor <= 20; valor++) { registro.offer(valor); }
            } catch (InterruptedException ex) {
                System.out.println("[i] Productor interrumpido.");
            }
        }
    }
 
    // Hilo que LEE y elimina valores del registro
    public static class Consumidor implements Runnable {
        @Override 
        public void run() {
            try {
                for (int i = 0; i < 20; i++) { registro.remove(); }
            } catch (InterruptedException ex) {
                System.out.println("[i] Consumidor interrumpido.");
            }
        }
    }
 
    // Recurso compartido: registro de tamaño limitado sobre una lista enlazada
    public static class Registro {
        private LinkedList<Integer> lista = new LinkedList<>();
        private int capacidad;
 
        // HILOS: un único bloqueo con DOS condiciones asociadas (así lo pide el enunciado)
        private Lock obj_lock = new ReentrantLock();
        private Condition noVacio = obj_lock.newCondition(); // "el registro no está vacío"
        private Condition noLleno = obj_lock.newCondition(); // "el registro no está lleno"
 
        public Registro(int capacidad) { this.capacidad = capacidad; }
 
        // Añade un valor; si el registro está lleno, el hilo espera la condición noLleno
        public void offer(int valor) throws InterruptedException {
            obj_lock.lock(); // HILOS: hay que tener el lock ANTES de usar await()/signal()
            try {
                // HILOS: while y no if. Al despertar, otro hilo pudo haber cambiado el estado,
                // así que hay que volver a comprobar la condición 
                while (lista.size() == capacidad) {
                    System.out.println("[i] Esperar a que el registro no esté lleno.");
                    // HILOS: await() libera el lock automáticamente y duerme el hilo hasta recibir signal().
                    // Al despertar, recupera el lock solo antes de continuar.
                    noLleno.await();
                }
                lista.add(valor);
                System.out.println("| Se almacena |" + valor);
                Thread.sleep((int) (Math.random() * 1000)); // retardo aleatorio recomendado
                // HILOS: avisa al consumidor (si estaba esperando por vacío) de que ya hay datos
                noVacio.signalAll();
            } finally {
                obj_lock.unlock(); // HILOS: siempre se libera en el finally
            }
        }
 
        // Lee y elimina el primer valor; si el registro está vacío, el hilo espera la condición noVacio
        public int remove() throws InterruptedException {
            obj_lock.lock();
            try {
                while (lista.isEmpty()) {
                    System.out.println("\t\t[i] Esperar a que el registro no esté vacío.");
                    noVacio.await(); // HILOS: libera el lock y espera a que el productor añada algo
                }
                int valor = lista.remove(); // LinkedList.remove() sin argumentos: quita y devuelve la cabeza
                System.out.println("\t\t| Se extrae |" + valor);
                Thread.sleep((int) (Math.random() * 1000));
                // HILOS: avisa al productor (si estaba esperando por lleno) de que ya hay hueco
                noLleno.signalAll();
                return valor;
            } finally {
                obj_lock.unlock();
            }
        }
}
}
