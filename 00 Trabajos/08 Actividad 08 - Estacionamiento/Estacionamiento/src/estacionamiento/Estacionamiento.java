/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author marquitos
 */
public class Estacionamiento implements ICobrable{

    
    private String nombre;
    private ArrayList <Isla> islas = new ArrayList<>();
    
    public Estacionamiento(){}

    public Estacionamiento(String nombre) {
        this.nombre = nombre;
        
        this.islas.add(new Isla(1, true));
        this.islas.add(new Isla(2, true));
        this.islas.add(new Isla(3, true));
    }

    public void cobrar(Alquiler transaccion) {
        float total = transaccion.CalcularSaldo();
        System.out.println("\n--- TICKET DE COBRO ---");
        System.out.println("Vehículo Patente: " + transaccion.getVehiculo().getPatente());
        System.out.println("Isla usada: " + transaccion.getIsla().getNumero());
        System.out.println("Total a pagar: $" + total);
        transaccion.RegistrarPago();
        System.out.println("Estado del alquiler: ¡PAGADO!");
        System.out.println("-----------------------");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Estacionamiento predioCentro = new Estacionamiento("Estacionamiento Central");

        Vehiculo auto = new Vehiculo("AutoMovil", "2018", "Wolskvawen","123JKF", 1200.0f);
        auto.setPatente("AF123JK");
        auto.setTarifa(1200.0f);

        Isla islaAsignada = predioCentro.islas.get(0);
        islaAsignada.setEstado(true);
        
        LocalTime entrada = LocalTime.of(8, 0);
        LocalTime salida = LocalTime.of(10, 30);
        Alquiler alquilerAuto = new Alquiler(entrada, salida, true, auto, islaAsignada);

        //El vehículo se retira a las 10:30 hs (Se queda 2 horas y media)
      
        alquilerAuto.RegistrarSalida(salida);
        islaAsignada.setEstado(false);

        predioCentro.cobrar(alquilerAuto);
    }
}
