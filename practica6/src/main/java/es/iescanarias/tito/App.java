package es.iescanarias.tito;

import java.util.ArrayList;

import es.iescanarias.DNI;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        FicheroController fController = new FicheroController();
        
        Fichero f = new Fichero("persona.csv");
        ArrayList<Persona> p =  new ArrayList<>();
        Persona persona1 = new Persona("Knekro", "Garcia", 40, new DNI("79354638S"));
        Persona persona2 = new Persona("Knekro", "Garcia", 40, new DNI("79354638S"));

        p.add(persona1);
        p.add(persona2);
        fController.guardar(p, f);
        fController.leerFichero(f).forEach(System.out::println);
        

    }
}
