module es.iescanarias.tito {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.iescanarias.tito to javafx.fxml;
    opens es.iescanarias.tito.controller to javafx.fxml , javafx.base;
    exports es.iescanarias.tito;
}
