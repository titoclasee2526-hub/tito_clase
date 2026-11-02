module es.iescanarias.aeg {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.iescanarias.aeg to javafx.fxml;
    exports es.iescanarias.aeg;

    opens es.iescanarias.aeg.controller to javafx.fxml;
    exports es.iescanarias.aeg.controller;

    exports es.iescanarias.aeg.model;
}
