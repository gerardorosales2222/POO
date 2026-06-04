# Ejercicio 8, Estacionamiento
## Clase Main: Estacionamiento 
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author New User
 */
public class Estacionamiento implements ICobrable {
/**
 * @author Profe
 */
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
        System.out.println("Isla usada: " + transaccion.getIsla().getNumero());
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
## Clase Alquiler
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author New User
 */
public class Alquiler {
    private LocalTime horaEntrada;
    private LocalTime horaSalida; 
    private boolean pagado;
    private Vehiculo vehiculo;
    private Isla isla;

     public void registrarSalida(LocalTime salida){
         this.horaSalida= salida;
    }
     public void registrarPago(){
     this.pagado= pagado;
     }
     public float calcularSaldo(){
     if(horaEntrada== null || horaSalida== null){
     return 0;
     }
        long minutos =ChronoUnit.MINUTES.between(horaEntrada, horaSalida );
        float horas = minutos / 60.0f;
        return horas * vehiculo.getTarifa();
     }
    
    public Alquiler(LocalTime entrada, Vehiculo auto, Isla laAsignada) {
        this.horaEntrada= entrada;
        this.vehiculo= auto;
        this.isla= laAsignada;
    }

    public Alquiler(LocalTime horaEntrada, LocalTime horaSalida, boolean pagado, Vehiculo vehiculo, Isla isla) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.pagado = pagado;
        this.vehiculo = vehiculo;
        this.isla = isla;
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
}
```
## Interface ICobrale
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author New User
 */
public interface ICobrable {
    void cobrar(Alquiler transaccion);
}

```
## Clase Isla
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author New User
 */
public class Isla {
    private int numero;
    private boolean estado;

    public Isla(int par) {
    }

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
```
## Clase Vehículo 
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author New User
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