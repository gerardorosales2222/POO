/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopoo;

/**
 *
 * @author emely
 */
public class EjercicioPoo {

    
    public static void main(String[] args) {
      AccionHotel Accion;
     Accion = new ReservarHabitacion("hola","hola");
     Accion.EjecutarAccion();
      
      Accion = new Pago("hols",4);
      Accion.EjecutarAccion();
 
      
    }
    
}
