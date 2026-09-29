package es.iescanarias.tito.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import es.iescanarias.tito.model.GestorFicheros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    private GestorFicheros gf;

    @FXML
    public void initialize() {
        gf = new GestorFicheros();
    }

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    @FXML
    private Button btnLeer;

    @FXML
    private Button btnMultiplicar;

    @FXML
    private Button btnguardar;

    @FXML
    void guardarFichero(ActionEvent event) throws FileNotFoundException {
        String txa = txtArea.getText();
        gf.guardar(txa);
    }

    @FXML
    void leerFichero(ActionEvent event) throws IOException {
        txtArea.setText(gf.leer());
        gf.leer();
    }

    @FXML
    void multiplicar(ActionEvent event) {
        String txField = txtField.getText();
        gf.multiplicar(txField);
        String resultado = gf.multiplicar(txtField.getText());
        txtArea.setText(resultado);

    }

}
