module es.iescanarias.vm {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;

    opens es.iescanarias.vm to javafx.fxml;
    exports es.iescanarias.vm;
    exports es.iescanarias.vm.controller;
    opens es.iescanarias.vm.controller to javafx.fxml;
    opens es.iescanarias.vm.model to jakarta.xml.bind;
}
