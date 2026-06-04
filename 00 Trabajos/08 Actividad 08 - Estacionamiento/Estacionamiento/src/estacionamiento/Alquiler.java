/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author marquitos
 */
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

