# Actividad 09 - Canchas Orientadas a Objetos

Crear un Diagrama de Clases UML y programar la solución completa para un complejo de Canchas de Fútbol 5 en lenguaje Java asegurando el correcto funcionamiento y la adecuación a los siguientes requisitos.

## Contexto del problema
Un complejo de canchas de Fútbol 5 necesita un sistema de software para administrar el cobro de sus turnos. El negocio funciona de la siguiente manera:

1. El complejo cuenta con varias Canchas, cada una identificada por un número y con un precio de tarifa fija por hora (por ejemplo, las canchas techadas son más caras que las descubiertas).

2. Los Clientes reservan un turno dejando su nombre y DNI como responsable.

3. A diferencia del estacionamiento (donde se paga al salir según el tiempo transcurrido), en el Complejo de Canchas el turno se abona por adelantado. Al momento de reservar, el cliente debe indicar la hora de inicio y la cantidad de horas (o fracciones) que desea utilizar la cancha. El sistema debe calcular el total a pagar de forma inmediata para autorizar el ingreso.


A continuación el main que servirá como ayuda:

```java
package canchafutbol5;
import java.time.LocalTime;
/**
 * @author Profe
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
```