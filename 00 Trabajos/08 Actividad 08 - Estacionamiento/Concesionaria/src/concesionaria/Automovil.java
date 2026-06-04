/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionaria;

/**
 *
 * @author Marisol
 */
public class Automovil implements IVehiculo  {
 private String patente;

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public void mover() {
        System.out.println("Estoy en movimiento");
    }
 
}
