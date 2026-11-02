package es.iescanarias.tito;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class App 
{
    public static CuentaCorriente cuenta = new CuentaCorriente();
    public static void main( String[] args )
    {

        ExecutorService ejecutor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            ejecutor.execute(new TareaPonerEuro(cuenta)); // Crear y lanza 100 subprocesos
        }

        ejecutor.shutdown();

        //ejecutor.awaitTermination(1, TimeUnit.MINUTES);
        while (!ejecutor.isTerminated()) { } //Espera a que todas las tareas terminen

        System.out.println("Cual es el balance final: " 
            + cuenta.obtenerBalance() + " $");

        }
}
