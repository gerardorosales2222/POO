/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author jogag
 */
class Vehiculo {

    private int id;
    private String patente;
    private String marca;
    private String tipo;
    private double precioHora;

    private Cliente cliente;

    public Vehiculo() {
    }

    public Vehiculo(int id, String patente, String marca, String tipo, double precioHora, Cliente cliente) {

        this.id = id;
        this.patente = patente;
        this.marca = marca;
        this.tipo = tipo;
        this.precioHora = precioHora;
        this.cliente = cliente;

    }

    public int getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
