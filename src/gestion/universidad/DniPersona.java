/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.universidad;

/**
 *
 * @author juansmartinez
 */
public class DniPersona {
     private int dni;
     private char letra;

    public DniPersona(int dni) {
        this.dni = dni;
        this.letra = CalcularLetra(dni);
    }
    
    private char CalcularLetra(int dni){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(dni %  23);
    }

    public int getDni() {
        return dni;
    }

    public char getLetra() {
        return letra;
    }
    
    @Override
    public String toString() {
        return dni + "-" + letra;
    }
}
