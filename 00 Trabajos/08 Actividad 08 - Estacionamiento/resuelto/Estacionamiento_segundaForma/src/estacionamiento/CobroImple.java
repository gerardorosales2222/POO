/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author jogag
 */
public class CobroImple implements Cobro{

    @Override
    public double calcularCobro(Vehiculo vehiculo, int horas) {
     return vehiculo.getPrecioHora() * horas;
    }
    
}
