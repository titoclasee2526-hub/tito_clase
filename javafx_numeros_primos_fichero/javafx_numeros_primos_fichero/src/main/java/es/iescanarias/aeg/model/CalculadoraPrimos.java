package es.iescanarias.aeg.model;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraPrimos {
    
    public List<Integer> calcular(int cantidad) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(2);

        for (int posiblePrimo = 3; lista.size() < cantidad; posiblePrimo += 2) {
            int divisor = 2; 
            boolean finalizar = false;
            boolean numeroPrimo = true;
            
            do {
                if (posiblePrimo % divisor == 0) {
                    finalizar = true;
                    numeroPrimo = false;
                }
                divisor++; // Sumara 1 cada vez que no sea un primo
                if (divisor >= posiblePrimo) {
                    finalizar = true;
                }
            } while (!finalizar);
            
            if (numeroPrimo) {
                lista.add(posiblePrimo);
            }
        }
        return lista;
    }
}
