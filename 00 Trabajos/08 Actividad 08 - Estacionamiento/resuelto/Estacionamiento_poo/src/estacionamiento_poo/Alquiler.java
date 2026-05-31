/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento_poo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jogag
 */
public class Alquiler {

    private LocalTime entrada;
    private LocalTime salida;

    private Vehiculo vehiculo;
    private Isla isla;

    private boolean pagado;

    public Alquiler(LocalTime entrada,  Vehiculo vehiculo, Isla isla) {

        this.entrada = entrada;
        this.vehiculo = vehiculo;
        this.isla = isla;

        this.pagado = false;

    }

    public void registrarSalida(LocalTime salida) {

        this.salida = salida;

    }

    public float calcularSaldo() {

        long minutos =    ChronoUnit.MINUTES.between(   entrada, salida );

        float horas = minutos / 60.0f;

        return horas * vehiculo.getTarifa();

    }

    public void registrarPago() {

        pagado = true;

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Isla getIsla() {
        return isla;
    }}