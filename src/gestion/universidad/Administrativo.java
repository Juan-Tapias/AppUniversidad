package gestion.universidad;

/**
 * Representa a un Administrativo, que es un tipo de Persona.
 */
public class Administrativo extends Persona {

    public Administrativo(String nombre, String apellido, FechaNacimiento fechaNacimiento, DniPersona dni) {
        super(nombre, apellido, fechaNacimiento, dni);
    }

    @Override
    public String getRol() {
        return "Administrativo";
    }
}