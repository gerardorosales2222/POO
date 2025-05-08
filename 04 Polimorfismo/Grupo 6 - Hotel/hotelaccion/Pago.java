/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelaccion;

/**
 *
 * @author MP
 */
public class Pago extends AcionHotel {
    private final String metodopago;
    private final String monto;

    public Pago(String metodopago, String monto) {
        this.metodopago = metodopago;
        this.monto = monto;
    }
    
    

    @Override
    void ejecutarAcion() {
        System.out.println(this.metodopago + this.monto);
    }
    
}
