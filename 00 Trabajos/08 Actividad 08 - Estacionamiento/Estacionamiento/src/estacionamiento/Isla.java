/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author Usuario
 */
public class Isla {
    private int numero;
    private boolean estado;

    public Isla(int par) {
    }
    
    public Isla(int numero, boolean estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEstado() {
        return estado;
    }

}
