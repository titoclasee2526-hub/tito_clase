package es.iescanarias.tito;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App 
{
    public static void main( String[] args )
    {

        ExecutorService ejecutor = Executors.newCachedThreadPool();
        
        ExecutorService ejecutor2 = Executors.newCachedThreadPool();
        Salida s = new Salida();

        for (int i = 0; i < 10; i++) {
            
            ejecutor.execute(new Thread(new Entrada()));
         
        
        }
            
     ejecutor.shutdown();

        while (!ejecutor.isTerminated()) {}
        
       for (int j = 0; j < 15; j++) {
            ejecutor2.execute(new Thread(new Salida()));
        }
        ejecutor2.shutdown();

        while (!ejecutor2.isTerminated()) {}


    }
}
