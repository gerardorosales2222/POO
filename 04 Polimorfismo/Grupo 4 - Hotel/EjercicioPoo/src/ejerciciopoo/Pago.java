/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopoo;

/**
 *
 * @author emely
 */
public class Pago extends AccionHotel{
   private String medioPago;
    private double  monto;

    public Pago(String medioPago, double monto) {
        this.medioPago = medioPago;
        this.monto = monto;
    }
    
      public void EjecutarAccion(String medioPago,double monto){
        System.out.println("el pago esta hecho");
          
    }
  
}
