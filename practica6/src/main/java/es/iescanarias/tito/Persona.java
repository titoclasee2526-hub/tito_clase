package es.iescanarias.tito;

import java.io.Serializable;

import es.iescanarias.DNI;

public class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private DNI dni;
    private int edad;

    public Persona(String nombre,String apellido , int edad, DNI dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", dni=").append(dni);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }



}
