## Icobrable
``` java
public interface ICobrable {
    
    public void cobrarTurno(Turno t) ;
}

````

## Turno

``` java

public class Turno {
     private LocalTime HoraEntrada ;
     private LocalTime HoraSalida;
     private String reponsable;
     private Cancha LaCacnha;
     

    public Turno(LocalTime HoraEntrada, LocalTime HoraSalida, String reponsable, Cancha LaCacnha) {
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
        this.reponsable = reponsable;
        this.LaCacnha = LaCacnha;
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

    public String getReponsable() {
        return reponsable;
    }

    public void setReponsable(String reponsable) {
        this.reponsable = reponsable;
    }

    public Cancha getLaCacnha() {
        return LaCacnha;
    }

    public void setLaCacnha(Cancha LaCacnha) {
        this.LaCacnha = LaCacnha;
    }
     
     public float calcularTotal(){
         if (HoraEntrada == null || HoraSalida == null) {
          return 0.0f ;
      }
      long minutosTotales = ChronoUnit.MINUTES.between(HoraEntrada, HoraSalida);
      float horasCalculadas = minutosTotales/60.0f;
      return horasCalculadas * LaCacnha.getTarifa();
     }
}

````
## Cliente

``` java 
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

````
## Cancha

```` java
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
````
## Main

```` java
public class ComplejoCancha implements ICobrable{
    
     
    public void cobrarTurno(Turno t) {
        System.out.println("====== PAGO ADELANTADO (AUTORIZADO) ======");
        System.out.println("Responsable: " + t.getReponsable());
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

        Turno turnoF5 = new Turno(LocalTime.of(20, 0), LocalTime.of(22, 0), "Marcos Paz", canchaTechada);

        complejo.cobrarTurno(turnoF5);//se cobra antes de jugar

    }
    
}
````