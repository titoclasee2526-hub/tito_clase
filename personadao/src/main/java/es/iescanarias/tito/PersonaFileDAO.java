package es.iescanarias.tito;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class PersonaFileDAO {

private String ruta;


    public PersonaFileDAO(String ruta) {
    this.ruta = ruta;
}

    List<Persona> listaPersonas = new ArrayList<>();

    public String leer(int posicion) {

        try (BufferedReader br = new BufferedReader(new FileReader("persona.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {

        }
        return null;
    }

    public List<Persona> leerTodas() {

        try (BufferedReader br = new BufferedReader(new FileReader("persona.csv"))) {
            if (listaPersonas.isEmpty()) {
                return new ArrayList<>();
            } // Devuelve una lista vacia si la original esta vacia
            listaPersonas.forEach(System.out::println);
            return listaPersonas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPersonas;
    }

    public boolean agregar(Persona p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("persona.csv",true))) {
            
                bw.write(p.toString() + ";");

            
        } catch (Exception e) {
            return false;
        }
        // Se puede hacer con return listaPersonas.add(p);
        // Porque esto ya devuelve true o false
        return false;
    }

    public boolean reescribirTodo(List<Persona> personas) {

        try (BufferedWriter bw = // Crea el fichero
                new BufferedWriter(new FileWriter("persona.csv", false))) {

            for (Persona persona /* persona se usa como si fuera [i] */ : personas) {
                bw.write(persona.toString());
                bw.newLine();
            }
            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
