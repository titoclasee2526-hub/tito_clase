package es.iescanarias.aeg.controller;

import es.iescanarias.aeg.model.Hilos;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private ImageView asta;

    @FXML
    private ImageView bandera;

    @FXML
    public void initialize() {
        System.out.println("1. Controlador iniciado.");
        
        Hilos hilosModel = new Hilos();

        double topeDelAsta = 65.0; 
        double posicionInicialBandera = 350.0; 
        
        hilosModel.animarBandera(topeDelAsta, posicionInicialBandera, nuevaPosicionY -> {
            bandera.setLayoutY(nuevaPosicionY);
        });
    }

}
