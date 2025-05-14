/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelaccion;

/**
 *
 * @author MP
 */
public class ReservacionHotel extends AcionHotel {

    private final  String Habitacion;
    private final String cliente;

    public ReservacionHotel(String Habitacion, String cliente) {
        this.Habitacion = Habitacion;
        this.cliente = cliente;
    }
    
    
    @Override
    void ejecutarAcion() {
        System.out.println(this.Habitacion + this.cliente);    }
    
}
