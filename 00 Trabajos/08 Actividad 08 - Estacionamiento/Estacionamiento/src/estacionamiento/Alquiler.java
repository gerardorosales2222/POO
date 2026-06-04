
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
