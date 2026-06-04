/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionaminento;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Usuario
 */
public class Alquiler {
    private  LocalTime horaEntrada;
     private LocalTime horaSalida;
     private boolean pagado;
     private Vehiculo vehiculo;
     private Isla isla;

    public Alquiler() {
    }

    public Alquiler(LocalTime entrada, Vehiculo auto, Isla laAsignada) {
        this.horaEntrada = entrada;
        this.vehiculo = auto;
        this.isla = laAsignada;
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
    public void registrarSalida(LocalTime horaSalida){
    this.horaSalida = horaSalida;
    }
    public void registrarPago(){
        this.pagado = true;
        
    }
    public float calcularSaldo(){ 
    if (horaEntrada==null || horaSalida == null){
        return 0.0f;
    }  

    long minutosTotales = ChronoUnit.MINUTES.between(horaSalida, horaSalida);
    float horasCalculadas = minutosTotales / 60.0f;
    return horasCalculadas * vehiculo.getTarifa();
   
     
            } 
}
