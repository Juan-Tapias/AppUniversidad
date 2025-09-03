package gestion.universidad;

/**
 * Clase abstracta que representa una persona en la universidad.
 */
public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected FechaNacimiento fechaNacimiento;

    public Persona(String nombre, String apellido, FechaNacimiento fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public FechaNacimiento getFechaNacimiento() { return fechaNacimiento; }

    public abstract String getRol();

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + 
               ", Rol: " + getRol() + 
               ", Fecha de Nacimiento: " + fechaNacimiento;
    }
}