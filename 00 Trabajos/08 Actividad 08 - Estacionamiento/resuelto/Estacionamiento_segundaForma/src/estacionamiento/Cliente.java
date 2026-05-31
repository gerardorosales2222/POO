/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author jogag
 */
public class Cliente {
   private int id;
    private String nombre;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

   
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }  
}
