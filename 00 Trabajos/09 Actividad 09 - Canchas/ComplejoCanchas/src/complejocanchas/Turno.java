package complejocanchas;

import java.time.LocalTime;

public class Turno {
    private Cliente cliente;
    private Cancha cancha;
    private LocalTime horaEntrada, horasalida;
    private int minutos;

    //los parametros que van en el constructor son los que el usuario o administrador va a agregar a mano 
    public Turno(Cliente cliente, Cancha cancha, LocalTime horaEntrada, int minutos) {
        this.cliente = cliente;
        this.cancha = cancha;
        this.horaEntrada = horaEntrada;
        this.minutos = minutos;
        this.horasalida = horaEntrada.plusMinutes(minutos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHorasalida() {
        return horasalida;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHorasalida(LocalTime horasalida) {
        this.horasalida = horasalida;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public float calcularTotal (){
        return (minutos/60.0f)*cancha.getTarifa();
    }
}
