package canchafutbol5;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Turno {
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private Cliente cliente;
    private Cancha cancha;

    public Turno() {
    }

    public Turno(LocalTime horaEntrada, LocalTime horaSalida, Cliente cliente, Cancha cancha) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cliente = cliente;
        this.cancha = cancha;
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
    public void registrarSalida(LocalTime horaSalida) {
    this.horaSalida = horaSalida;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }
     float calcularTotal(){
     if (horaEntrada == null || horaSalida == null) {
            return 0.0f;
        }
        long minusMinutes = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        float horasCalculadas = minusMinutes /60.0f;
        return  horasCalculadas * cancha.getTarifaPorHora();
    }
   
}
