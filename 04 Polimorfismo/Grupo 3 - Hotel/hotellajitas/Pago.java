
package hotellajitas;

import java.util.Scanner;

/**
 *
 * @author ELI
 */
public class Pago extends AccionHotel{
    public String metodoPago;
    public float monto = 8000;
Scanner entrada = new Scanner(System.in);

    public Pago() {
    }

    
    public Pago(String metodoPago, float monto) {
        this.metodoPago = metodoPago;
        this.monto = monto;
    }

    @Override
    public void ejecutarAccion() {
        int op = 0;
        System.out.println("Ingrese el medio de pago a usar: \n"
                + "1) Efectivo \n"
                + "2) Tarjeta de credito \n"
                + "3) Tarjeta de debito");
        op = entrada.nextInt();
        switch(op) {
            case 1:
                if(op == 1) {
                    this.metodoPago = "Efectivo";
                }
            case 2: 
                if(op == 2) {
                    this.metodoPago = "Tarjeta de credito";
                }
            case 3:
                if(op== 3) {
                    this.metodoPago = "Tarjeta de debito";
                }
            
        }
              
        System.out.println("Pagado con "+ this.metodoPago);
        System.out.println("Monto " +this.monto);
        
    }
    
    
}
