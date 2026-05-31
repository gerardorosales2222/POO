/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author jogag
 */
public class Isla {

    private int id;
    private int numero;
    private boolean disponible;

    public Isla() {
    }

    public Isla(int id, int numero, boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    
}
