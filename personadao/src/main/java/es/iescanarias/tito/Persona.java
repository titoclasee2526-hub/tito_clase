package es.iescanarias.tito;

public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
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
