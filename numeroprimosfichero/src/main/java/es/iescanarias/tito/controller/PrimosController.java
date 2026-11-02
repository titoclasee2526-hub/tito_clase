package es.iescanarias.tito.controller;

import java.util.List;

import es.iescanarias.tito.model.Calculadora;
import es.iescanarias.tito.model.PrimosDAO;
import es.iescanarias.tito.view.Vista;

public class PrimosController {

  private static final int CANTIDAD_PRIMOS = 10000;
    private static final int LIMITE_MOSTRAR = 100;
    private static final String RUTA_TEXTO = "javafx_numeros_primos_fichero/primos.txt";
    private static final String RUTA_BINARIO = "javafx_numeros_primos_fichero/primos.dat";

    private final CalculadoraPrimos calculadora;
    private final PrimosDAO dao;
    private final VistaPrimos vista;

    public PrimosController(CalculadoraPrimos calculadora, PrimosDAO dao, VistaPrimos vista) {
        this.calculadora = calculadora;
        this.dao = dao;
        this.vista = vista;
    }

    /** Punto de entrada: se llama desde el main. */
    public void ejecutarPractica() {
        vista.mostrarMensaje("Calculando los primeros " + CANTIDAD_PRIMOS + " números primos...");
        List<Integer> primos = calculadora.calcular(CANTIDAD_PRIMOS);

        boolean guardadoOk = guardarTexto(primos) & guardarBinario(primos);
        if (!guardadoOk) {
            return; // sin archivos válidos no tiene sentido comparar ni leer
        }

        compararTamanos();
        mostrarPrimerosPrimos();
    }

    private boolean guardarTexto(List<Integer> primos) {
        return guardarYInformar(dao.guardarEnTexto(primos, RUTA_TEXTO), "texto");
    }

    private boolean guardarBinario(List<Integer> primos) {
        return guardarYInformar(dao.guardarEnBinario(primos, RUTA_BINARIO), "binario");
    }

    private boolean guardarYInformar(boolean exito, String tipo) {
        if (exito) {
            vista.mostrarMensaje("Archivo " + tipo + " guardado correctamente.");
        } else {
            vista.mostrarError("Error al guardar el archivo " + tipo + ".");
        }
        return exito;
    }

    private void compararTamanos() {
        long tamanoTxt = dao.obtenerTamanoArchivo(RUTA_TEXTO);
        long tamanoBin = dao.obtenerTamanoArchivo(RUTA_BINARIO);
        vista.mostrarComparacionTamanos(tamanoTxt, tamanoBin);
    }

    private void mostrarPrimerosPrimos() {
        vista.mostrarMensaje("Leyendo los primeros " + LIMITE_MOSTRAR + " números primos:");
        List<Integer> leidos = dao.leerBinario(RUTA_BINARIO, LIMITE_MOSTRAR);
        vista.mostrarNumeros(leidos);
    }



}
