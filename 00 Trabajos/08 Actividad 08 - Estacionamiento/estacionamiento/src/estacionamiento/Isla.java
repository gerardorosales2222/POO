/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author De los angeles
 */
public class Isla {
    int nro;
    boolean estado;

    public Isla(int par) {
    }

    public Isla(int nro, boolean estado) {
        this.nro = nro;
        this.estado = estado;
    }

    public int getNro() {
        return nro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
