package gestion.universidad;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa a un Profesor, que es un tipo de Persona.
 */
public class Profesor extends Persona {
    private Set<String> asignaturas;
    
    public Profesor(String nombre, String apellido, FechaNacimiento fechaNacimiento, DniPersona dni) {
        super(nombre, apellido, fechaNacimiento, dni);
        this.asignaturas = new HashSet<>();
    }

    @Override
    public String getRol() {
        return "Profesor";
    }
    
    public boolean agregarAsignatura(String asignatura) {
        return asignaturas.add(asignatura); 
    }

    public boolean eliminarAsignatura(String asignatura) {
        return asignaturas.remove(asignatura);
    }
    
     public Set<String> getAsignaturas() {
        return asignaturas;
    }
     
   @Override
    public String toString() {
        return super.toString() + " | Rol: " + getRol() + " | Asignaturas: " + asignaturas;
    }
}