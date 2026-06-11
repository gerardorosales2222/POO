# Buenas profe, le mando mi trabajo con el readmi.md que muestre mi codigo dentro de la carpeta del proyecto

## Este es el codigo de la interfaz Icobrable
```dart
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author Usuario
 */
public interface Icobrable {
    void cobrar(Alquiler transaccion);
}

```
## Este es el codigo de la clase Isla
```dart
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author Usuario
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

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEstado() {
        return estado;
    }

}
```
## Este es el codigo de la clase Vehiculo
```dart
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author Usuario
 */
public class Vehiculo {
    private String tipo;
    private String color;
    private String marcamodelo;
    private String patente;
    private float tarifa;
    
    
    public Vehiculo(String tipo, String color, String marcamodelo, String patente, float tarifa) {
        this.tipo = tipo;
        this.color = color;
        this.marcamodelo = marcamodelo;
        this.patente = patente;
        this.tarifa = tarifa;
    }

    public Vehiculo() {
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public String getPatente() {
        return patente;
    }

    public float getTarifa() {
        return tarifa;
    }
}
```
## este es el codigo de la clase Alquiler
```dart
package estacionamiento;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author Usuario
 */
public class Alquiler {
    private boolean pagado;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    public Alquiler() {
    }

    public Alquiler(boolean pagado, LocalTime horaEntrada, Vehiculo vehiculo, Isla isla) {
        this.pagado = pagado;
        this.horaEntrada = horaEntrada;
        this.vehiculo = vehiculo;
        this.isla = isla;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }
    private Vehiculo vehiculo;
    private Isla isla;

    public boolean isPagado() {
        return pagado;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Isla getIsla() {
        return isla;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setIsla(Isla isla) {
        this.isla = isla;
    }
    
     public void registrarPago() {
        this.pagado = true;
    }
    
    public float CalcularSaldo(){
       if (horaEntrada == null || horaSalida == null){
        return 0.0f;
        }
       long minutosTotales = ChronoUnit.MINUTES.between(horaEntrada,horaSalida);
       float horasCalculadas = minutosTotales / 60.0f;
       return horasCalculadas * vehiculo.getTarifa();
      
    }
    void registrarSalida(LocalTime salida) {
        this.horaSalida = horaSalida;
    }
}

```