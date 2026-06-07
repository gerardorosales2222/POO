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
