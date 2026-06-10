## Código del ejercicio de cancha

### Clase Main.

```java
package canchafutbol5;
import java.time.LocalTime;

public class ComplejoCanchas implements ICobrable {
    
    @Override
    public void cobrarTurno(Turno t) {
        System.out.println("====== PAGO ADELANTADO (AUTORIZADO) ======");
        System.out.println("Responsable: " + t.getCliente().getNombre());
        System.out.println("Cancha: Nro " + t.getCancha().getNumero());
        System.out.println("Horario reservado: de " + t.getHoraSalida().minusMinutes((long)(t.calcularTotal()/t.getCancha().getTarifaPorHora()*60)) + " a " + t.getHoraSalida()); 
        System.out.println("Total pagado: $" + t.calcularTotal());
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        ComplejoCanchas complejo = new ComplejoCanchas();
        
        Cancha canchaTechada = new Cancha(3, 8000.0f);
        Cliente responsable = new Cliente("Marcos Paz");

        Turno turnoF5 = new Turno(LocalTime.of(20, 0), LocalTime.of(22, 0), responsable, canchaTechada);

        complejo.cobrarTurno(turnoF5);//se cobra antes de jugar
    }    
}
```

### Interfaz ICobrable

```java
package canchafutbol5;

public interface ICobrable {
    void cobrarTurno(Turno t);
}

```

### Clase Turno

```java
package canchafutbol5;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Turno {
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private Cliente cliente;
    private Cancha cancha;

    public Turno() {
    }

    public Turno(LocalTime horaEntrada, LocalTime horaSalida, Cliente cliente, Cancha cancha) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cliente = cliente;
        this.cancha = cancha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
    public void registrarSalida(LocalTime horaSalida) {
    this.horaSalida = horaSalida;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }
     float calcularTotal(){
     if (horaEntrada == null || horaSalida == null) {
            return 0.0f;
        }
        long minusMinutes = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        float horasCalculadas = minusMinutes /60.0f;
        return  horasCalculadas * cancha.getTarifaPorHora();
    }
   
}

```

## Clase Cliente

```java
package canchafutbol5;

public class Cliente {
    private String nombre;
    private String dni;

    public Cliente() {
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}

```

### Clase Cancha

```java
package canchafutbol5;

public class Cancha {
    private int numero;
    private float TarifaPorHora;

    public Cancha() {
    }

    public Cancha(int numero, float TarifaPorHora) {
        this.numero = numero;
        this.TarifaPorHora = TarifaPorHora;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getTarifaPorHora() {
        return TarifaPorHora;
    }

    public void setTarifaPorHora(float TarifaPorHora) {
        this.TarifaPorHora = TarifaPorHora;
    }

    
    
}

```

![captura de pantalla del uml](https://github.com/agus-guti/POO2/blob/feature/gutierrez/00%20Trabajos/09%20Actividad%2009%20-%20Canchas/Trabajo-Cancha/UML.drawio.png?raw=true)
