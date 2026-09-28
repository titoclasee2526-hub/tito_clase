package es.iescanarias.tito;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

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

    @FXML
    void guardarContenido(ActionEvent event) {

        String contenidoGuardarFichero = txaContenidoGuardarFichero.getText();
        String nombreFichero = txtFieldFichero.getText();
        File f = new File(nombreFichero);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contenidoGuardarFichero);
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void leerContenido(ActionEvent event) {
        String nombreFichero = txtFieldFichero.getText();

        File fichero = new File(nombreFichero);
        Scanner sc = null;
        

        try {
            sc = new Scanner(fichero);
            //Leer fichero linea por linea
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                txaContenidoFichero.appendText(linea + "\r\n");
            }
            sc.close();
        } catch (Exception e) {
        }

    }
}
