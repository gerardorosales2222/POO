/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionaria;

/**
 *
 * @author Marisol
 */
public class HidroAvion implements IVolador, IVehiculo{
   

    @Override
    public void volar() {
        System.out.println("Estoy volando");
    }

    @Override
    public void mover() {
        System.out.println("Estoy moviendome");
    }
    
    
}
