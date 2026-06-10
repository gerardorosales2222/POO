/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package complejocancha;

import java.time.LocalTime;

/**
 *
 * @author marquitos
 */
public class ComplejoCancha implements ICobrable{
    
     
    public void cobrarTurno(Turno t) {
        System.out.println("====== PAGO ADELANTADO (AUTORIZADO) ======");
        System.out.println("Responsable: " + t.getReponsable() +" "+ "DNI: " + t.getDni());
        System.out.println("Cancha: Nro " + t.getLaCacnha().getNumero());
        System.out.println("Horario reservado: de " + t.getHoraEntrada().minusMinutes((long)(t.calcularTotal()/t.getLaCacnha().getTarifa()*60)) + " a " + t.getHoraSalida()); 
        System.out.println("Total pagado: $" + t.calcularTotal());
        System.out.println("==========================================");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
           ComplejoCancha complejo = new ComplejoCancha();
        
        Cancha canchaTechada = new Cancha(3, 8000.0f);
        Cliente responsable = new Cliente("Marcos Paz", 45262145);

        Turno turnoF5 = new Turno(LocalTime.of(20, 0), LocalTime.of(22, 0), "Marcos Paz",45262145, canchaTechada);

        complejo.cobrarTurno(turnoF5);//se cobra antes de jugar

    }
    
}
 