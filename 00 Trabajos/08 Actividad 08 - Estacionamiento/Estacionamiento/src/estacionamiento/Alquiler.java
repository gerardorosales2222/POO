/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author mi pc
 */
public class Alquiler {
    private LocalTime horaEntrada;
    private LocalTime hotaSalida;
    private boolean pagado;
    private Vehiculo vehiculo;
    private Isla isla;

    public Alquiler() {
    }

    public Alquiler(LocalTime horaEntrada, Vehiculo vehiculo, Isla isla) {
        this.horaEntrada = horaEntrada;
        this.hotaSalida = hotaSalida;
        this.pagado = pagado;
        this.vehiculo = vehiculo;
        this.isla = isla;
    }
    
    public void registrarSalida(LocalTime hotaSalida){
    
    }
    public void registrarPago(){
        this.pagado=true;
    }
    float calcularSaldo(){
        if (horaEntrada == null || hotaSalida == null) {
            return 0.0f;
        }
        long minutosTotales = ChronoUnit.MINUTES.between(horaEntrada, horaEntrada);
        float horasCalculadas = minutosTotales/60.0f;
        return horasCalculadas * vehiculo.getTarifa();
        
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHotaSalida() {
        return hotaSalida;
    }

    public void setHotaSalida(LocalTime hotaSalida) {
        this.hotaSalida = hotaSalida;
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
