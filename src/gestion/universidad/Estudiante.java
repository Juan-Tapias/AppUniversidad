package gestion.universidad;

/**
 * Representa a un Estudiante, que es un tipo de Persona.
 */
public class Estudiante extends Persona {

    public Estudiante(String nombre, String apellido, FechaNacimiento fechaNacimiento, DniPersona dni) {
        super(nombre, apellido, fechaNacimiento, dni);
    }

    @Override 
    public String getRol() {
        return "Estudiante";
    }
}