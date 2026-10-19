package es.iescanarias.tito;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import es.iescanarias.DNI;

public class FicheroControllerTest {

    @Rule
    public TemporaryFolder carpeta = new TemporaryFolder();

    private FicheroController controller;
    private Fichero fichero;
    private File archivo;

    @Before
    public void setUp() throws IOException {
        controller = new FicheroController();
        archivo = new File(carpeta.getRoot(), "personas.dat");
        fichero = new Fichero(archivo.getPath());
    }

    private ArrayList<Persona> listaDe(int cantidad) {
        ArrayList<Persona> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            lista.add(new Persona("Nombre" + i, "Apellido" + i, 20 + i, new DNI("79354638S")));
        }
        return lista;
    }

    @Test
    public void guardarCreaElFichero() {
        controller.guardar(listaDe(1), fichero);

        assertTrue(archivo.exists());
        assertTrue(archivo.length() > 0);
    }

    @Test
    public void guardarYLeerDevuelveLosMismosDatos() {
        ArrayList<Persona> original = listaDe(3);

        controller.guardar(original, fichero);
        ArrayList<Persona> leidas = controller.leerFichero(fichero);

        assertEquals(original.size(), leidas.size());
        for (int i = 0; i < original.size(); i++) {
            // Se compara por toString; si Persona tiene equals(), usa assertEquals directo
            assertEquals(original.get(i).toString(), leidas.get(i).toString());
        }
    }

    @Test
    public void guardarListaVaciaDevuelveListaVacia() {
        controller.guardar(new ArrayList<>(), fichero);

        assertTrue(controller.leerFichero(fichero).isEmpty());
    }

    @Test
    public void guardarDosVecesSobrescribeSinCorromper() {
        controller.guardar(listaDe(2), fichero);
        controller.guardar(listaDe(5), fichero);

        ArrayList<Persona> leidas = controller.leerFichero(fichero);

        assertEquals(5, leidas.size());
    }

    @Test
    public void leerFicheroInexistenteDevuelveListaVacia() {
        Fichero noExiste = new Fichero(new File(carpeta.getRoot(), "noExiste.dat").getPath());

        ArrayList<Persona> leidas = controller.leerFichero(noExiste);

        assertTrue(leidas.isEmpty());
    }

    @Test
    public void leerFicheroConContenidoInvalidoDevuelveListaVacia() throws IOException {
        java.nio.file.Files.write(archivo.toPath(), "esto no es un objeto".getBytes());

        ArrayList<Persona> leidas = controller.leerFichero(fichero);

        assertTrue(leidas.isEmpty());
    }
    @Test
    public void dniValidoSeCrea() {
        DNI dni = new DNI("79354638S");
        assertEquals("DNI [numeroDNI=79354638S]", dni.toString());
    }

    @Test
    public void letraEnMinusculaSeAceptaYSePasaAMayuscula() {
        DNI dni = new DNI("79354638s");
        assertEquals("DNI [numeroDNI=79354638S]", dni.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void letraIncorrectaLanzaExcepcion() {
        new DNI("79354638A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void pocosDigitosLanzaExcepcion() {
        new DNI("1234567S");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sinLetraLanzaExcepcion() {
        new DNI("79354638");
    }

    @Test(expected = IllegalArgumentException.class)
    public void letrasEnElNumeroLanzaExcepcion() {
        new DNI("7935463XS");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nuloLanzaExcepcion() {
        new DNI(null);
    }
}
