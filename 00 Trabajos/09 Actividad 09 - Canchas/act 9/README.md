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