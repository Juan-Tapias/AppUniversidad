package gestion.universidad;

/**
 * Representa a un Profesor, que es un tipo de Persona.
 */
public class Profesor extends Persona {

    public Profesor(String nombre, String apellido, FechaNacimiento fechaNacimiento, DniPersona dni) {
        super(nombre, apellido, fechaNacimiento, dni);
    }

    @Override
    public String getRol() {
        return "Profesor";
    }
}