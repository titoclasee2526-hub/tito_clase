package es.iescanarias.vm.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

//hay que poner en cada una de las clases que vamos a serializar como jaxb:
@XmlAccessorType(XmlAccessType.FIELD)

//en la clase raiz ponemos:
@XmlRootElement(name = "empresa")
public class Empresa implements Serializable {

    //Siempre tiene que estar el constructor vacio
    public Empresa() {

    }

    List<Empleado> empleados;

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
