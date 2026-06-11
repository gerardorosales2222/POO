# buenas profe le adjunto mi trabajo de la actividad 9 

## este es el codigo de la clase main
```java
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
```

## este es el codigo de la clase Cliente 

```java 
package complejocanchas;
public class Cliente {
    private String nombre;
    private String DNI;

    public Cliente() {
    }

    public Cliente(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }  
}
```

## este es el codigo de la clase Cancha

```java
package complejocanchas;
public class Cancha {
    private int tarifa;
    private float nro;

    public Cancha() {
    }

    public Cancha(int tarifa, float nro) {
        this.tarifa = tarifa;
        this.nro = nro;
    }

    public int getTarifa() {
        return tarifa;
    }

    public float getNro() {
        return nro;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public void setNro(float nro) {
        this.nro = nro;
    }  
}
```
## este es el codigo de la interfaz Icobrable

```java
package complejocanchas;
public interface ICobrable {
    void cobrarturno(Turno t);
}
```

## este es el codigo de la interfaz Icobrable

```java
package complejocanchas;
import java.time.LocalTime;

public class Turno {
    private Cliente cliente;
    private Cancha cancha;
    private LocalTime horaEntrada, horasalida;
    private int minutos;

    //los parametros que van en el constructor son los que el usuario o administrador va a agregar a mano 
    public Turno(Cliente cliente, Cancha cancha, LocalTime horaEntrada, int minutos) {
        this.cliente = cliente;
        this.cancha = cancha;
        this.horaEntrada = horaEntrada;
        this.minutos = minutos;
        this.horasalida = horaEntrada.plusMinutes(minutos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHorasalida() {
        return horasalida;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHorasalida(LocalTime horasalida) {
        this.horasalida = horasalida;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public float calcularTotal (){
        return (minutos/60.0f)*cancha.getTarifa();
    }
}
```