module es.iescanarias.tito {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.iescanarias.tito to javafx.fxml;
    exports es.iescanarias.tito;
}
