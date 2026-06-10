/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complejocanchas;

import java.time.LocalTime;

/**
 *
 * @author jogag
 */
class Turno {

    private LocalTime horaInicio;
    private int duracionMinutos;
    private Cliente cliente;
    private Cancha cancha;

    public Turno(LocalTime horaInicio, int duracionMinutos, Cliente cliente, Cancha cancha) {

        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
        this.cliente = cliente;
        this.cancha = cancha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaInicio.plusMinutes(duracionMinutos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public double calcularTotal() {
        return (duracionMinutos / 60.0) * cancha.getTarifaPorHora();
    }

}
