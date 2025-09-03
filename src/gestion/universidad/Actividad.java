package gestion.universidad;

/**
 * Representa una actividad realizada en la universidad.
 */
public class Actividad {
    private String descripcion;
    private Persona participante;

    public Actividad(String descripcion, Persona participante) {
        this.descripcion = descripcion;
        this.participante = participante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Actividad: '" + descripcion + 
               "', Participante: " + participante.getNombre() + " " + participante.getApellido() +
               " (" + participante.getRol() + ")";
    }
}