package gestion.universidad;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de prueba con menú interactivo para gestionar el sistema universitario.
 */
public class PruebaUniversidad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SISTEMA DE GESTIÓN UNIVERSITARIA ===\n");

        // 1. Crear una universidad
        System.out.print("Ingrese el nombre de la universidad: ");
        String nombreUniversidad = scanner.nextLine();
        Universidad miUniversidad = new Universidad(nombreUniversidad);
        System.out.println("Universidad '" + miUniversidad.getNombre() + "' creada con éxito.\n");

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                switch (opcion) {
                    case 1:
                        agregarNuevoParticipante(scanner, miUniversidad, 1); // 1 para Estudiante
                        break;
                    case 2:
                        agregarNuevoParticipante(scanner, miUniversidad, 2); // 2 para Profesor
                        break;
                    case 3:
                        agregarNuevoParticipante(scanner, miUniversidad, 3); // 3 para Administrativo
                        break;
                    case 4:
                        registrarActividad(scanner, miUniversidad);
                        break;
                    case 5:
                        miUniversidad.mostrarInformacion();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println(">> Error: Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(">> Error: Debe ingresar un número. Intente de nuevo.");
                scanner.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
            System.out.println(); // Añadir un espacio para mejorar la legibilidad
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("--- MENÚ DE GESTIÓN ---");
        System.out.println("1. Agregar Estudiante");
        System.out.println("2. Agregar Profesor");
        System.out.println("3. Agregar Administrativo");
        System.out.println("4. Registrar Actividad para un Participante");
        System.out.println("5. Mostrar Información Completa de la Universidad");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarNuevoParticipante(Scanner scanner, Universidad universidad, int rol) {
        String tipoParticipante;
        switch (rol) {
            case 1:
                tipoParticipante = "Estudiante";
                break;
            case 2:
                tipoParticipante = "Profesor";
                break;
            case 3:
                tipoParticipante = "Administrativo";
                break;
            default:
                // Este caso no debería ocurrir si se llama correctamente desde el menú
                System.out.println(">> Error: Rol interno no válido.");
                return;
        }
        System.out.println("\n--- Agregar Nuevo " + tipoParticipante + " ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Fecha de Nacimiento:");
        System.out.print("Día: ");
        int dia = scanner.nextInt();
        System.out.print("Mes: ");
        int mes = scanner.nextInt();
        System.out.print("Año: ");
        int anio = scanner.nextInt();
        System.out.print("Dni: ");
        int dni = scanner.nextInt();
        scanner.nextLine();

        FechaNacimiento fechaNacimiento = new FechaNacimiento(dia, mes, anio);
        DniPersona dniPersona = new DniPersona(dni);
        Persona nuevaPersona = null;

        switch (rol) {
            case 1:
                nuevaPersona = new Estudiante(nombre, apellido, fechaNacimiento, dniPersona);
                break;
            case 2:
                nuevaPersona = new Profesor(nombre, apellido, fechaNacimiento, dniPersona);
                break;
            case 3:
                nuevaPersona = new Administrativo(nombre, apellido, fechaNacimiento, dniPersona);
                break;
        }

        if (nuevaPersona != null) {
            universidad.agregarParticipante(nuevaPersona);
        }
    }

    private static void registrarActividad(Scanner scanner, Universidad universidad) {
        System.out.println("\n--- Registrar Nueva Actividad ---");
        List<Persona> participantes = (List<Persona>) universidad.getParticipantes();

        if (participantes.isEmpty()) {
            System.out.println(">> No hay participantes registrados. Agregue uno primero.");
            return;
        }

        System.out.println("Seleccione el participante para la actividad:");
        for (int i = 0; i < participantes.size(); i++) {
            Persona p = participantes.get(i);
            System.out.println(i + ". " + p.getNombre() + " " + p.getApellido() + " (" + p.getRol() + ")");
        }

        System.out.print("Ingrese el número del participante: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        if (indice < 0 || indice >= participantes.size()) {
            System.out.println(">> Error: Selección de participante no válida.");
            return;
        }

        System.out.print("Ingrese la descripción de la actividad: ");
        String descripcion = scanner.nextLine();

        Persona participanteSeleccionado = participantes.get(indice);
        Actividad nuevaActividad = new Actividad(descripcion, participanteSeleccionado);
        universidad.registrarActividad(nuevaActividad);
    }
}
