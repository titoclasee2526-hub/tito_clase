package com.mycompany.es.iescanarias.tito.primerjavafx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    private int num;
    
    @FXML
    private Button btnTabla;

    @FXML
    private TextArea txa;

    @FXML
    private TextField txf;

    @FXML
    void mostarTabla(ActionEvent event) {
        
       /* String resultado = "";
           num = Integer.parseInt(txf.getText());
         
           for (int i = 1; i <= 10; i++) {
              
               
              resultado +=  num + " x " + i + " = "+ (num * i)  +"\n";
               
        }
           txa.setText(resultado); */
           
           
         num = Integer.parseInt(txf.getText());
        for (int i = 1; i <= 10; i++) {
          txa.appendText(num + "x" + i + " = " + (num * i) +"\n");
          
        }
       
       
    }

}

