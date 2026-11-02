package es.iescanarias.vm.controller;

import java.nio.file.Files;
import java.util.ArrayList;

import es.iescanarias.vm.model.AlmacenEmpleadoFileDAO;
import es.iescanarias.vm.model.Empleado;
import es.iescanarias.vm.model.Empresa;
import jakarta.xml.bind.JAXBException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {
    

    private final Empresa empresa = new Empresa();
    private final ArrayList<Empleado> empleados = new ArrayList<>();
    private AlmacenEmpleadoFileDAO dao;

     @FXML private TextArea txArea;

    @FXML private Button btnAgregar;

    @FXML private Button btnLeer;

    @FXML private TextField txtFiedID;

    @FXML private TextField txtFieldCargo;

    @FXML private TextField txtFieldNombre;

    @FXML
    public void initialize(){

        try {
            dao = new AlmacenEmpleadoFileDAO("almacen.xml");
            empresa.setEmpleados(empleados);
            
            // Si ya hay datos guardados, los cargamos para no perderlos al agregar
            if(Files.exists(dao.getRutaAlmacen())){
                empleados.addAll(dao.leerEmpleados());
            }

        } catch (JAXBException e) {
            mostrarError("No se puedo inicializar el almacen:" + e.getMessage());
        }
    }


    @FXML
    void agregar(ActionEvent event) throws JAXBException {

        String nombre = txtFieldNombre.getText().trim();
        String cargo = txtFieldCargo.getText().trim();
        String idTexto = txtFiedID.getText().trim();

        if (nombre.isEmpty() || cargo.isEmpty() || idTexto.isEmpty()){
            mostrarError("Rellena todos los campos.");
            return;
        }
        int id;

        try {
            id = Integer.parseInt(idTexto);

        } catch (Exception e) {
            mostrarError("El ID tiene que ser un numero ");
            return;
        }

        try {
            empleados.add(new Empleado(nombre,id,cargo));
            empresa.setEmpleados(empleados);
            dao.guardar(empresa);

            txtFiedID.clear();
            txtFieldCargo.clear();
            txtFieldNombre.clear();
        
        } catch (JAXBException e) {
            mostrarError("No se pudo guardar:"+e.getMessage());
        }

    }

    @FXML
    void leer(ActionEvent event) throws JAXBException{

        try {
            ArrayList<Empleado> leidos = dao.leerEmpleados();

            StringBuilder sb = new StringBuilder();
            for(Empleado e : leidos){
                sb.append(e).append("\n");
                
            }

            txArea.setText(sb.toString());

        } catch (Exception e) {
            mostrarError("No se puedo leer el fichero:" + e.getMessage());
        }
    }
        private void mostrarError(String mensaje){
            new Alert(Alert.AlertType.ERROR, mensaje).showAndWait();
        }

    } 



