
package hotellajitas;

import java.util.Scanner;

/**
 *
 * @author ELI
 */
public class ReservaHabitacion extends AccionHotel {
    
    Scanner entrada = new Scanner(System.in);
    private String nroHabitacion;
    private String nombreCliente;

    public ReservaHabitacion() {
    }
    
    

    public ReservaHabitacion(String nroHabitacion, String nombreCliente) {
        this.nroHabitacion = nroHabitacion;
        this.nombreCliente = nombreCliente;
        
    }

    @Override
    public void ejecutarAccion() {
        
        System.out.println("Ingrese el numero de habitación que desea reservar: ");
        this.nroHabitacion = entrada.next();
        System.out.println("Ingrese su nombre");
        this.nombreCliente = entrada.next();
        System.out.println("Se reservó la habitacion " + this.nroHabitacion);
        System.out.println("A nombre del cliente: " + this.nombreCliente);
    }
    

    
        
    
}    

