package es.iescanarias.tito;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Tarea que devuelve un valor -> RecursiveTask<Double>

public class TareaSuma extends RecursiveTask<Double> {

    private static final int UMBRAL = 100;
    private final double[] lista;
    private final int inicio,fin;

    public TareaSuma(int fin, int inicio, double[] lista) {
        this.fin = fin;
        this.inicio = inicio;
        this.lista = lista;
    }
    public TareaSuma() {
        this.fin = 0;
        this.inicio = 0;
        this.lista = null;
    }
    

    @Override
    protected Double compute() {

        if(fin - inicio < UMBRAL) {
            double suma = 0;
            for(int i = inicio; i < fin; i++) {
                suma += lista[i];
            }
            return suma;
        } 

            int mitad = (inicio + fin) / 2;
            TareaSuma IZQ = new TareaSuma(mitad, inicio, lista);
            TareaSuma DER = new TareaSuma(fin, mitad, lista);
            IZQ.fork();
            double resDer = DER.compute();
            double resIzq = IZQ.join();
            return resIzq + resDer;
            
        
    }
    public static double sumaParalela(double[] lista) {
        
        ForkJoinPool pool = new ForkJoinPool(); // Usa todos los procesadores disponibles
        
        try {
            return pool.invoke(new TareaSuma(lista.length, 0, lista));
        } finally {
            pool.shutdown();
        }
    }
    public static double redondear(double promedio){
        return Math.round(promedio * 100.0) / 100.0;
    }

    

}
