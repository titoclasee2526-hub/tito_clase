package es.iescanarias.tito;

import java.util.stream.DoubleStream;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    
    {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        int n = ejercicio1.getN();
        TareaSuma sumaobj = new TareaSuma();
        DoubleStream valores = DoubleStream.generate(() ->{
        return (double) (Math.random() * 1000);
        
    });

    double[] lista = valores.limit(n).toArray();

    long inicio = System.currentTimeMillis();
    double suma = sumaobj.sumaParalela(lista);
    long fin = System.currentTimeMillis();
      System.out.println("[i] La suma redondeada a dos decimales de " + n + " valores es: " + sumaobj.redondear(suma));
        System.out.println("[i] Número de procesadores implicados: " + Runtime.getRuntime().availableProcessors());
        System.out.println("--> EL tiempo empleado es de: " + (fin - inicio) + " milisegundos");
    }
}
