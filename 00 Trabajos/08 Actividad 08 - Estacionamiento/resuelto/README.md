# Actividad 08 – Estacionamiento Orientado a Objetos

## Clase main


```java
package estacionamiento_poo;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author jogag
 */
public class Estacionamiento_poo implements ICobrable {

    private String nombre;
    private ArrayList<Isla> islas = new ArrayList<>();
    
    public Estacionamiento_poo(){}

    public Estacionamiento_poo(String nombre) {
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
        Estacionamiento_poo predioCentro = new Estacionamiento_poo("Estacionamiento Central");

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
## Interface Icobrable
```Java
package estacionamiento_poo;
/**
 *
 * @author jogag
 */
interface ICobrable {
    void cobrar(Alquiler transaccion); 
}
```

## Clase Alquiler
```Java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento_poo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jogag
 */
public class Alquiler {

    private LocalTime entrada;
    private LocalTime salida;

    private Vehiculo vehiculo;
    private Isla isla;

    private boolean pagado;

    public Alquiler(LocalTime entrada,  Vehiculo vehiculo, Isla isla) {

        this.entrada = entrada;
        this.vehiculo = vehiculo;
        this.isla = isla;

        this.pagado = false;

    }

    public void registrarSalida(LocalTime salida) {

        this.salida = salida;

    }

 // Aclaración:
    // Este método fue el que más me costó entender,
    // por eso investigué cómo funcionaba el manejo
    // de horas y minutos en Java usando LocalTime
    // y ChronoUnit.
    public float calcularSaldo() {
           // Calcula la diferencia en minutos, entre la hora de entrada y salida.
        long minutos =    ChronoUnit.MINUTES.between(   entrada, salida );

        // Convierte los minutos a horas.
        float horas = minutos / 60.0f;
        // Multiplica las horas por la tarifa
        //retorna el total
        return horas * vehiculo.getTarifa();

    }

    public void registrarPago() {

        pagado = true;

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Isla getIsla() {
        return isla;
    }}
}
```
## Clase Isla
```Java
package estacionamiento_poo;

/**
 *
 * @author jogag
 */
public class Isla {

    private int nro;
    private boolean estado;

    public Isla(int nro) {

        this.nro = nro;
        this.estado = false;

    }

    public int getNro() {
        return nro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
```

## Clase Vehiculo
```Java
package estacionamiento_poo;

/**
 *
 * @author jogag
 */
public class Vehiculo {

    private String patente;
    private float tarifa;

    public Vehiculo() {
    }

    public Vehiculo(String patente, float tarifa) {

        this.patente = patente;
        this.tarifa = tarifa;

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
tambien hice otra forma sin seguir el main:Segunda forma,Estacionamiento_SegundaForma
si es posible quiero saber que cosa puedo mejorar