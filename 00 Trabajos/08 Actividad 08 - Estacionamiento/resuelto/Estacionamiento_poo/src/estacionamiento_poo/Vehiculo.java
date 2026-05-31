/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento_poo;

/**
 *
 * @author jogag
 */
public class Vehiculo {

    private String patente;
    private float tarifa;

    public Vehiculo() {
    }

    public Vehiculo(String patente, float tarifa) {

        this.patente = patente;
        this.tarifa = tarifa;

    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

}