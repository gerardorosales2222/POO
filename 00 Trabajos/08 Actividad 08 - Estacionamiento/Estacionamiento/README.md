## Solución del tp estacionamiento

### Clase main
```java
package estacionamiento;

import java.time.LocalTime;
import java.util.ArrayList;

public class Estacionamiento implements ICobrable {

    private String nombre;
    private ArrayList<Isla> islas = new ArrayList<>();
    
    public Estacionamiento(){}

    public Estacionamiento(String nombre) {
        this.nombre = nombre;
        
        this.islas.add(new Isla(1));
        this.islas.add(new Isla(2));
        this.islas.add(new Isla(3));
    }

    @Override
    public void cobrar(Alquiler transaccion) {
        float total = transaccion.calcularSaldo();
        System.out.println("\n--- TICKET DE COBRO ---");
        System.out.println("Vehículo Patente: " + transaccion.getVehiculo().getPatente());
        System.out.println("Isla usada: " + transaccion.getIsla().getNro());
        System.out.println("Total a pagar: $" + total);
        transaccion.registrarPago(); 
        System.out.println("Estado del alquiler: ¡PAGADO!");
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Estacionamiento predioCentro = new Estacionamiento("Estacionamiento Central");

        Vehiculo auto = new Vehiculo();
        auto.setPatente("AF123JK");
        auto.setTarifa(1200.0f);

        Isla islaAsignada = predioCentro.islas.get(0);
        islaAsignada.setEstado(true);
        
        LocalTime entrada = LocalTime.of(8, 0); 
        Alquiler alquilerAuto = new Alquiler(entrada, auto, islaAsignada);

        //El vehículo se retira a las 10:30 hs (Se queda 2 horas y media)
        LocalTime salida = LocalTime.of(10, 30);
        alquilerAuto.registrarSalida(salida);
        islaAsignada.setEstado(false);

        predioCentro.cobrar(alquilerAuto);
    }
}
```

### Clase Alquiler

```java

package estacionamiento;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class Alquiler {
    
    private LocalTime horaEntrada;
     private Vehiculo vehiculo;
    private Isla isla;
    private LocalTime horaSalida;
   private  boolean pagado=false;

    public Alquiler() {
    }
   

    public Alquiler(LocalTime entrada, Vehiculo auto, Isla laAsignada) {
        this.horaEntrada = entrada;
        this.vehiculo =auto;
        this.isla=laAsignada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public boolean isPagado() {
        return pagado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Isla getIsla() {
        return isla;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setIsla(Isla isla) {
        this.isla = isla;
    }
    public void registrarSalida(LocalTime horaSalida) {
    this.horaSalida = horaSalida;
    }
    public void registrarPago() {
        this.pagado = true;
    }
    public float calcularSaldo() {
        if (horaEntrada == null || horaSalida == null){
        return 0.0f;
        }
       long minutosTotales = ChronoUnit.MINUTES.between(horaEntrada,horaSalida);
       float horasCalculadas = minutosTotales / 60.0f;
       return horasCalculadas * vehiculo.getTarifa();
       
    }
}

```

### Clase Vehiculo 

```java

package estacionamiento;

public class Vehiculo {
    private String tipo;
    private String color;
    private String marcaModelo;
    private String patente;
    private float tarifa;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    
    
}

```

### Clase Isla.

```java

package estacionamiento;

public class Isla {
    private int nro;
    private boolean estado;
    
    public Isla(int par) {
    }
    public Isla(int nro, boolean estado) {
        this.nro = nro;
        this.estado = false;
    }
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

```

### Interfaz ICobrable. 

```java

package estacionamiento;

public interface ICobrable {
    void cobrar (Alquiler transaccion);
}

```