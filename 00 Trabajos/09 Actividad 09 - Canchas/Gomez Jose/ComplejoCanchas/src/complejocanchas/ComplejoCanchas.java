/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package complejocanchas;

import java.time.LocalTime;

/**
 *
 * @author jogag
 */
public class ComplejoCanchas implements ICobrable {
 
    @Override
    public void cobrarTurno(Turno t) {
        System.out.println("====== PAGO ADELANTADO (AUTORIZADO) ======");
        System.out.println("Responsable: " + t.getCliente().getNombre());
        System.out.println("Cancha: Nro " + t.getCancha().getNumero());
        System.out.println("Horario reservado: de " + t.getHoraFin().minusMinutes((long)(t.calcularTotal()/t.getCancha().getTarifaPorHora()*60)) + " a " + t.getHoraFin()); 
        System.out.println("Total pagado: $" + t.calcularTotal());
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        ComplejoCanchas complejo = new ComplejoCanchas();
        
        Cancha canchaTechada = new Cancha(3, 8000.0f);
        Cliente responsable = new Cliente("Marcos Paz");

        Turno turnoF5 = new Turno(LocalTime.of(20, 0), 90, responsable, canchaTechada);

        complejo.cobrarTurno(turnoF5);//se cobra antes de jugar
    }    
    
}
