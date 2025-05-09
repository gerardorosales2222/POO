/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopoo;

/**
 *
 * @author emely
 */
public class ReservarHabitacion extends AccionHotel {
    private String nombre;
    private String numeroAbitacion;

    public ReservarHabitacion(String nombre, String numeroAbitacion) {
        this.nombre = nombre;
        this.numeroAbitacion = numeroAbitacion;
    }
    
    public void EjecutarAccion(String nombre,String numeroAbitacion){
      
        System.out.println("ABITACCION ALQUILADA ");
        
    }
    
    
}
