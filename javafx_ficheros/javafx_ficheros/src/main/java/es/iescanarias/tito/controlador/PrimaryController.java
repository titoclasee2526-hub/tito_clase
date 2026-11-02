package es.iescanarias.tito.controlador;
import java.io.IOException;

import es.iescanarias.tito.modelo.GestorFichero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLeer;

    @FXML
    private TextArea txaContenidoFichero;

    @FXML
    private TextArea txaContenidoGuardarFichero;

    @FXML
    private TextField txtFieldFichero;

    private GestorFichero gestor = new GestorFichero();

    @FXML
    void guardarContenido(ActionEvent event) {
        String nombreFichero = txtFieldFichero.getText();
        String contenido = txaContenidoGuardarFichero.getText();

        try {
            gestor.guardar(nombreFichero, contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void leerContenido(ActionEvent event) {
        String nombreFichero = txtFieldFichero.getText();

        try {
            String contenido = gestor.leer(nombreFichero);
            txaContenidoFichero.setText(contenido);
        } catch (IOException e) {
            txaContenidoFichero.setText("No se pudo leer el fichero: " + e.getMessage());
        }
    }
}
