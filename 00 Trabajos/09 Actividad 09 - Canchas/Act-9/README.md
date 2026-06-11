# ACTIVIDAD 9
## Clase ComplejoCancha
```java
public class ComplejoCancha implements ICobrable{
     @Override
    public void cobrarTurno(Turno t) {
        System.out.println("====== PAGO ADELANTADO (AUTORIZADO) ======");
        System.out.println("Responsable: " + t.getResponsable()+" "+"DNI"+ t.getDni());
        System.out.println("Cancha: Nro " + t.getLaCancha().getNumero());
        System.out.println("Horario reservado: de " + t.getHoraEntrada().minusMinutes((long)(t.calcularTotal()/t.getLaCancha().getTarifa()*60)) + " a " + t.getHoraSalida()); 
        System.out.println("Total pagado: $" + t.calcularTotal());
        System.out.println("==========================================");
    }

    
    public static void main(String[] args) {
         ComplejoCancha complejo = new ComplejoCancha();
        
        Cancha canchaTechada = new Cancha(3, 8000.0f);
        Cliente responsable = new Cliente("Marcos Paz", 43762756);

        Turno turnoF5 = new Turno(LocalTime.of(20, 43762756), LocalTime.of(21, 0), "Marco Paz", 0, canchaTechada);

        complejo.cobrarTurno(turnoF5);//se cobra antes de jugar
        
       
    }
    
}
```
## Interfaz ICobrable
```java
public interface ICobrable {
    public void cobrarTurno(Turno t);
    
}

```
## Clase Turno
``` java
public class Turno {
    private LocalTime HoraEntrada;
    private LocalTime HoraSalida;
    private String responsable;
    private int dni;
    private Cancha LaCancha;

    public Turno(LocalTime HoraEntrada, LocalTime HoraSalida, String responsable, int dni, Cancha LaCancha) {
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
        this.responsable = responsable;
        this.dni = dni;
        this.LaCancha = LaCancha;
    }

    public LocalTime getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(LocalTime HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public LocalTime getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(LocalTime HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Cancha getLaCancha() {
        return LaCancha;
    }

    public void setLaCancha(Cancha LaCancha) {
        this.LaCancha = LaCancha;
    }
    public float calcularTotal(){
        if (HoraEntrada == null || HoraSalida == null ){
         return 0.0f;
    }
        long minutosTotales = ChronoUnit.MINUTES.between(HoraSalida, HoraSalida);
        float horasCalculadas = minutosTotales/ 60.0f;
        return horasCalculadas * LaCancha.getTarifa();
        
    }
    
}
``` 
## Clase Cliente
```java
public class Cliente {
    private String nombre;
    private int dni;

    public Cliente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
}
``` 
## Clase Cancha
```java
public class Cancha {
    private int numero;
    private float tarifa;

    public Cancha(int numero, float tarifa) {
        this.numero = numero;
        this.tarifa = tarifa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    
}
```
