/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author Usuario
 */
public class Vehiculo {
    private String tipo;
    private String color;
    private String marcamodelo;
    private String patente;
    private float tarifa;
    
    
    public Vehiculo(String tipo, String color, String marcamodelo, String patente, float tarifa) {
        this.tipo = tipo;
        this.color = color;
        this.marcamodelo = marcamodelo;
        this.patente = patente;
        this.tarifa = tarifa;
    }

    public Vehiculo() {
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public String getPatente() {
        return patente;
    }

    public float getTarifa() {
        return tarifa;
    }

}
