
package hotellajitas;

/**
 *
 * @author ELI
 */
public class HotelLajitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccionHotel accion;
        
        accion = new ReservaHabitacion();
        accion.ejecutarAccion();
        
        accion = new Pago();
        accion.ejecutarAccion();
        
        
    }
    
}
