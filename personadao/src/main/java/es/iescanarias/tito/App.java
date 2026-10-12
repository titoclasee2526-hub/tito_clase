package es.iescanarias.tito;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", "López", "11111111A", 25));
        personas.add(new Persona("Luis", "Pérez", "22222222B", 30));
        personas.add(new Persona("Marta", "Gómez", "33333333C", 22));
        personas.add(new Persona("Pedro", "Díaz", "44444444D", 41));
        personas.add(new Persona("Lucía", "Ruiz", "55555555E", 19));

        System.out.print("Nombre del fichero: ");
        String ruta = sc.nextLine();

        PersonaFileDAO dao = new PersonaFileDAO(ruta);

        if (dao.reescribirTodo(personas)) {
            System.out.println("Personas guardadas correctamente.");
        } else {
            System.out.println("No se pudieron guardar las personas.");
        }

        // Comprobación: leerlas de vuelta
        List<Persona> leidas = dao.leerTodas();
        if (leidas.isEmpty()) {
            System.out.println("No hay personas o no se ha podido leer el fichero.");
        } else {
            for (Persona p : leidas) {
                System.out.println(p);
            }
        }
    }
}
