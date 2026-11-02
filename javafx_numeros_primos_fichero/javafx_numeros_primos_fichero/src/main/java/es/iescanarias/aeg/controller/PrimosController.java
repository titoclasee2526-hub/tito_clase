package es.iescanarias.aeg.controller;

import es.iescanarias.aeg.model.*; // Se importa para poder hacer los privates
import es.iescanarias.aeg.view.*; // Se importa para poder hacer los privates

import java.util.List;

public class PrimosController {
    
    private CalculadoraPrimos calculadora; // Define para esta clase calculadora con la clase "CalculadoraPrimos"
    private PrimosDAO dao; // Define para esta clase dao con la clase "PrimosDAO"
    private VistaPrimos vista; // Define para esta clase vista con la clase "VistaPrimos"

    public PrimosController(CalculadoraPrimos calculadora, PrimosDAO dao, VistaPrimos vista) { //Constructor de "PrimosController"
        this.calculadora = calculadora; // Constructor de "calculadora"
        this.dao = dao; // Constructor de "dao"
        this.vista = vista; //Constructor de "vista"
    }

    public void ejecutarPractica() { // Clase que se llama desde el main para ejecutarla de arranque
        int cantidadPrimos = 10000; // Define la cantidad de primos que se van a guadar en el ".txt" y ".dad"
        String rutaTexto = "javafx_numeros_primos_fichero/primos.txt"; // Define la ruta en donde se va a guardar el ".txt" y su nombre
        String rutaBinario = "javafx_numeros_primos_fichero/primos.dat"; // Define la ruta en donde se va a guardar el ".dad" y su nombre


        vista.mostrarMensaje("Calculando los primeros " + cantidadPrimos + " números primos..."); // Define el mensaje que mostrará cuando ejecute
        List<Integer> primos = calculadora.calcular(cantidadPrimos); // Define la lista en la que se harán las operaciones de determinar si es un primo o no además de añadir el valor de "cantidadPrimos" para poder hacer que pare cuando debe

        // Guarda el valor en texto
        if (dao.guardarEnTexto(primos, rutaTexto)) { // Comprueba si en el void guardarEnTexto de la clase "PrimosDAO" no da error
            vista.mostrarMensaje("Archivo de texto guardado correctamente."); // Manda mensaje si logra guardar
        } else {
            vista.mostrarError("Error al guardar el archivo de texto."); // Manda mensaje si falla
        }

        // Guarda el valor en binario
        if (dao.guardarEnBinario(primos, rutaBinario)) { // Comprueba si en el void guardarEnBinario de la clase "PrimosDAO" no da error
            vista.mostrarMensaje("Archivo binario guardado correctamente."); // Manda mensaje si logra guardar
        } else {
            vista.mostrarError("Error al guardar el archivo binario."); // Manda mensaje si falla
        }

        // Comparas los tamaños del .txt y del .dad que obtienes de "VistaPrimos" y luego esta clase los obtiene para mostrarlo en la terminal
        long tamanoTxt = dao.obtenerTamanoArchivo(rutaTexto); // El del .txt
        long tamanoBin = dao.obtenerTamanoArchivo(rutaBinario); // El del .dad
        vista.mostrarComparacionTamanos(tamanoTxt, tamanoBin); // Se usa para el public void de "VistaPrimos" para que pueda trabajar "con tamanoTxt" y "tamanoBin"

        // Lee el binario
        int limiteMostrar = 100; // Define el limite de numeros primos a mostrar en terminal
        vista.mostrarMensaje("Leyendo los primeros " + limiteMostrar + " números primos:"); // Muestra el mensaje de que va a leer los primeros 100 primos
        List<Integer> primosLeidos = dao.leerBinario(rutaBinario, limiteMostrar); // Se envia la lista de valores primos a PrimosDAO con la ruta y el limite a mostrar de numeros primos
        vista.mostrarNumeros(primosLeidos);  // Envia el valor de primosLeidos a el void mostrarNumeros en la clase de "VistaPrimos"
    }
}
