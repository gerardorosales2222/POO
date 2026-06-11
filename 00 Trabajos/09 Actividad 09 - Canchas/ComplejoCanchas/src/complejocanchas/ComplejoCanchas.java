
package complejocanchas;

import java.time.LocalTime;

/**
 *Un complejo de canchas de Fútbol 5 necesita un sistema de software 
 *para administrar el cobro de sus turnos. El negocio funciona de la siguiente manera:
 *El complejo cuenta con varias Canchas, cada una identificada por un número y 
 *con un precio de tarifa fija por hora (por ejemplo, las canchas techadas son más caras que las descubiertas).
 *Los Clientes reservan un turno dejando su nombre y DNI como responsable.
 *A diferencia del estacionamiento (donde se paga al salir según el tiempo transcurrido),
 *en el Complejo de Canchas el turno se abona por adelantado. Al momento de reservar, 
 *el cliente debe indicar la hora de inicio y la cantidad de horas (o fracciones) que desea 
 *utilizar la cancha. El sistema debe calcular el total a pagar de forma inmediata para autorizar el ingreso.
 */
public class ComplejoCanchas implements ICobrable{
        
    public static void main(String[] args) {
        ComplejoCanchas complejo = new ComplejoCanchas();
        
        Cancha canchaTechada = new Cancha(3, 8000.0f);
        Cliente responsable = new Cliente("Marcos Paz", "46666258");
        Turno turnoF5 = new Turno(responsable, canchaTechada, LocalTime.of(20,0), 90);

        complejo.cobrarturno(turnoF5);//se cobra antes de jugar
    }  

    @Override
    public void cobrarturno(Turno t) {
       System.out.println("====== PAGO ADELANTADO (AUTORIZADO) ======");
        System.out.println("Responsable: " + t.getCliente().getNombre());
        System.out.println("Cancha: Nro " + t.getCancha().getNro());
        System.out.println("Horario reservado: de " + t.getHorasalida().minusMinutes((long)(t.calcularTotal()/t.getCancha().getTarifa()*60)) + " a " + t.getHorasalida()); 
        System.out.println("Total pagado: $" + t.calcularTotal());
        System.out.println("==========================================");
   
    }
}
