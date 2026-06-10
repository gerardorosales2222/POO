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
public class ComplejoCanchas implements ICobrable{

     @Override
    public void cobrarTurno(Turno t) {
      System.out.println("====== PAGO ADELANTADO (AUTORIZADO) ======");
        System.out.println("Responsable: " + t.getCliente().getNombre());
        System.out.println("Cancha: Nro " + t.getCancha().getNumero());
        System.out.println("Horario reservado: de " + t.getCantidadHora().minusMinutes((long)(t.calcularTotal()/t.getCancha().getTarifa()*60)) + " a " + t.getCantidadHora()); 
        System.out.println("Total pagado: $" + t.calcularTotal());
        System.out.println("==========================================");
    }
    public static void main(String[] args) {
        ComplejoCanchas complejo = new ComplejoCanchas();
        
        Cancha canchaTechada = new Cancha(3, 8000.0f);
        Cliente responsable= new Cliente("Marcos Paz");

        Turno turnoF5 = new Turno(LocalTime.of(20, 0), LocalTime.of(22, 0), responsable, canchaTechada);

        complejo.cobrarTurno(turnoF5);//se cobra antes de jugare
    }

   

   
    
}
```
### clase Turno
```java
public class Turno {
    LocalTime horaInicio;
    LocalTime cantidadHora;
    Cliente cliente;
    Cancha cancha;
    public Turno() {
    }

    public Turno(LocalTime horaInicio, LocalTime cantidadHora, Cliente cliente, Cancha cancha) {
        this.horaInicio = horaInicio;
        this.cantidadHora = cantidadHora;
        this.cliente = cliente;
        this.cancha = cancha;
    }

   

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getCantidadHora() {
        return cantidadHora;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public Cliente getCliente() {
        return cliente;
    }
   public float calcularTotal() {
        if (horaInicio == null || cantidadHora == null){
        return 0.0f;
        }
       long minutosTotales = ChronoUnit.MINUTES.between(horaInicio,cantidadHora);
       float horasCalculadas = minutosTotales / 60.0f;
       return horasCalculadas * cancha.getTarifa();
       
    }
}
```
### Clase Cliente
```java
public class Cliente {
    String Nombre;
    String DNI;

    public Cliente() {
    }

    public Cliente(String Nombre) {
        this.Nombre = Nombre;
        
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
}
```
### intergace Icobrable
```java
public interface ICobrable {
    public void cobrarTurno(Turno t);
}
```
### clase Cancha
```java
public class Cancha {
   
    int Numero;
    Float Tarifa;

    public Cancha() {
    }

    public Cancha(int Numero, Float Tarifa) {
        this.Numero = Numero;
        this.Tarifa = Tarifa;
    }

    public int getNumero() {
        return Numero;
    }

    public Float getTarifa() {
        return Tarifa;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public void setTarifa(Float Tarifa) {
        this.Tarifa = Tarifa;
    }

  
    
}
```