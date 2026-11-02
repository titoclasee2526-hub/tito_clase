package es.iescanarias.tito;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TextoParpadeo extends Application {
    private String texto = "";

    @Override
    public void start(Stage escenario) {
        StackPane lienzo = new StackPane();
        Label etiqueta = new Label("HOLA CHANQUETES!!");
        lienzo.getChildren().add(etiqueta);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (etiqueta.getText().trim().length() == 0)
                            texto = "HOLA CHANQUETES!!";
                        else
                            texto = "";

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                etiqueta.setText(texto);
                            }
                        });
                        Thread.sleep(200);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }).start();

        Scene escena = new Scene(lienzo, 200, 50);
        escenario.setTitle("Texto Psicodélico");
        escenario.setScene(escena);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}