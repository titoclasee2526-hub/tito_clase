package es.iescanarias.tito.model;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    private int divisor = 2;

    public List<Integer> calculo(int num) {
        ArrayList<Integer> listaPrimos = new ArrayList(); 
        // Esto crearia una lista cada vez que se use el metodo de
        // calculo ¿eso es bueno?
        if (num <= 0)
            return listaPrimos;

        listaPrimos.add(2);

        for (int i = 3; listaPrimos.size() < num; i += 2) {

            if (esPrimo(i)) {
                listaPrimos.add(i);
            }

        }
        return listaPrimos;
    }

    private boolean esPrimo(int num) {
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
