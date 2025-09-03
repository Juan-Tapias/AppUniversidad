package gestion.universidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase principal que gestiona los miembros y actividades de la universidad.
 */
public class Universidad {
    private String nombre;
    private Map<String, Persona> participantes;
    private List<Actividad> actividades;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.participantes = new HashMap<>();
        this.actividades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public boolean existeParticipante(String dni) {
    return participantes.containsKey(dni);
    }


    public Map<String, Persona> getParticipantes() {
        return participantes;
    }

    public void agregarParticipante(Persona persona) {
        participantes.put(persona.getDni().toString(), persona);
        System.out.println("Se ha agregado a " + persona.getNombre() + " " + persona.getApellido() + " como " + persona.getRol() + " a la universidad.");
    }

    public void registrarActividad(Actividad actividad) {
        actividades.add(actividad);
        System.out.println("Se ha registrado la actividad: '" + actividad.getDescripcion() + "'.");
    }

    public void mostrarInformacion() {
        System.out.println("\n--- Información de la Universidad: " + nombre + " ---");
        
        System.out.println("\n=== MIEMBROS DE LA UNIVERSIDAD ===");
        for (Persona persona : participantes.values()) {
            System.out.println("- " + persona);
        }

        System.out.println("\n=== ACTIVIDADES REGISTRADAS ===");
        for (Actividad actividad : actividades) {
            System.out.println("- " + actividad);
        }
        System.out.println("\n-------------------------------------------------");
    }
}
