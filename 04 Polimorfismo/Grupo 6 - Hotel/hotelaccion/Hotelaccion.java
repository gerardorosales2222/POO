/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelaccion;

/**
 *
 * @author MP
 */
public class Hotelaccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        AcionHotel accion;
        accion = new Pago("tarjeta de credito", "5000");
        accion.ejecutarAcion();
          
        accion = new ReservacionHotel("habitacion 101", "");
        accion.ejecutarAcion();
      

    
    
}




    }
    

