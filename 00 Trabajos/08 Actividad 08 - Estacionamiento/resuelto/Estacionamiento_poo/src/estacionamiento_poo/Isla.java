/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento_poo;

/**
 *
 * @author jogag
 */
public class Isla {

    private int nro;
    private boolean estado;

    public Isla(int nro) {

        this.nro = nro;
        this.estado = false;

    }

    public int getNro() {
        return nro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}