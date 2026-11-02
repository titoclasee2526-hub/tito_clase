package es.iescanarias.vm.model;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

//hay que poner en cada una de las clases que vamos a serializar como jaxb:
@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado implements Serializable {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;

    }

    public Empleado() {

    }

    public Empleado(String nombre, int id, String cargo) {
        this.nombre = nombre;
        this.id = id;
        this.cargo = cargo;
    }

    String nombre;
    int id;
    String cargo;

    @Override
    public String toString() {
        return "Empleado{"
                + "nombre='" + nombre + '\''
                + ", id=" + id
                + ", cargo='" + cargo + '\''
                + '}';
    }
}

//POJO
