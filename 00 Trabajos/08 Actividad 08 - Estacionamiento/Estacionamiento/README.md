## Main 

```java
 
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author marquitos
 */
public class Estacionamiento implements ICobrable{

    
    private String nombre;
    private ArrayList <Isla> islas = new ArrayList<>();
    
    public Estacionamiento(){}

    public Estacionamiento(String nombre) {
        this.nombre = nombre;
        
        this.islas.add(new Isla(1, true));
        this.islas.add(new Isla(2, true));
        this.islas.add(new Isla(3, true));
    }

    public void cobrar(Alquiler transaccion) {
        float total = transaccion.CalcularSaldo();
        System.out.println("\n--- TICKET DE COBRO ---");
        System.out.println("Vehículo Patente: " + transaccion.getVehiculo().getPatente());
        System.out.println("Isla usada: " + transaccion.getIsla().getNumero());
        System.out.println("Total a pagar: $" + total);
        transaccion.RegistrarPago();
        System.out.println("Estado del alquiler: ¡PAGADO!");
        System.out.println("-----------------------");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Estacionamiento predioCentro = new Estacionamiento("Estacionamiento Central");

        Vehiculo auto = new Vehiculo("AutoMovil", "2018", "Wolskvawen","123JKF", 1200.0f);
        auto.setPatente("AF123JK");
        auto.setTarifa(1200.0f);

        Isla islaAsignada = predioCentro.islas.get(0);
        islaAsignada.setEstado(true);
        
        LocalTime entrada = LocalTime.of(8, 0);
        LocalTime salida = LocalTime.of(10, 30);
        Alquiler alquilerAuto = new Alquiler(entrada, salida, true, auto, islaAsignada);

        //El vehículo se retira a las 10:30 hs (Se queda 2 horas y media)
      
        alquilerAuto.RegistrarSalida(salida);
        islaAsignada.setEstado(false);

        predioCentro.cobrar(alquilerAuto);
    }
}
```
## ICobrable 

```` java
public interface ICobrable {
    
    void cobrar (Alquiler transaccion);
}
````
## Vehiculo
```` java
 */
public class Vehiculo {
    
    String tipo;
    String modelo;
    String marca;
    String patente;
    float tarifa;

    public Vehiculo(String tipo, String modelo, String marca, String patente, float tarifa) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
        this.patente = patente;
        this.tarifa = tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

````
## Isla
````java

public class Isla {
    
    private int numero;
    private boolean estado;

    public Isla(int numero, boolean estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
````
## Alquiler

```` java 
public class Alquiler {
    
  private LocalTime horaDeEntrada;
  private LocalTime horaDeSalida;
  private boolean pagado;
  private Vehiculo vehiculo;
  private Isla isla;

    public Alquiler(LocalTime horaDeEntrada, LocalTime horaDeSalida, boolean pagado, Vehiculo vehiculo, Isla isla) {
        this.horaDeEntrada = horaDeEntrada;
        this.horaDeSalida = horaDeSalida;
        this.pagado = pagado;
        this.vehiculo = vehiculo;
        this.isla = isla;
    }

    public LocalTime getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public void setHoraDeEntrada(LocalTime horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }

    public LocalTime getHoraDeSalida() {
        return horaDeSalida;
    }

    public void setHoraDeSalida(LocalTime horaDeSalida) {
        this.horaDeSalida = horaDeSalida;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Isla getIsla() {
        return isla;
    }

    public void setIsla(Isla isla) {
        this.isla = isla;
    }

  public void RegistrarSalida ( LocalTime horadeSalida){
      
  }
    
  public void RegistrarPago (){
      this.pagado=true;
  }
  
  public float CalcularSaldo (){
      if (horaDeEntrada == null || horaDeSalida == null) {
          return 0.0f ;
      }
      long minutosTotales = ChronoUnit.MINUTES.between(horaDeSalida, horaDeSalida);
      float horasCalculadas = minutosTotales/60.0f;
      return horasCalculadas * vehiculo.getTarifa();
  
      
  
}
}

````