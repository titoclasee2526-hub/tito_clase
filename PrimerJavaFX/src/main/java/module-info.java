module com.mycompany.es.iescanarias.tito.primerjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.es.iescanarias.tito.primerjavafx to javafx.fxml;
    exports com.mycompany.es.iescanarias.tito.primerjavafx;
}
