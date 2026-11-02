package es.iescanarias.aeg;

import es.iescanarias.aeg.controller.PrimosController;
import es.iescanarias.aeg.model.CalculadoraPrimos;
import es.iescanarias.aeg.model.PrimosDAO;
import es.iescanarias.aeg.view.VistaPrimos;

public class Main {
    public static void main(String[] args) {
        // Inicializar los componentes del MVC (nombres corregidos)
        CalculadoraPrimos calculadora = new CalculadoraPrimos(); // Se inicia "calculadora" de la clase "PrimosController"
        PrimosDAO dao = new PrimosDAO();  // Se inicia "dao" de la clase "PrimosController"
        VistaPrimos vista = new VistaPrimos(); // Se inicia "vista" de la clase "PrimosController"
        
        PrimosController controlador = new PrimosController(calculadora, dao, vista); // Pilla "calculadora", "dao", y "vista" de sus respectivas clases y las inyecta a la clase "PrimosController"
        
        controlador.ejecutarPractica(); // Ejecuta la aplicación llamando a "ejecutarPractica" la cual se encuentra en PrimosController y esta inicia todo el ejercicio
    }
}
