package gestion.universidad;

/**
 * Clase para representar una fecha de nacimiento.
 */
public class FechaNacimiento {
    private int dia;
    private int mes;
    private int anio;

    public FechaNacimiento(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Getters
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnio() { return anio; }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, anio);
    }
}