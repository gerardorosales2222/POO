/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complejocanchas;

/**
 *
 * @author jogag
 */
class Cancha {
 private int numero;
    private float tarifaPorHora;

    public Cancha(int numero, float tarifaPorHora) {
        this.numero = numero;
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getNumero() {
        return numero;
    }

    public float getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTarifaPorHora(float tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
  
}
