
package estacionamiento_poo;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author jogag
 */
public class Estacionamiento_poo implements ICobrable {

    private String nombre;
    private ArrayList<Isla> islas = new ArrayList<>();
    
    public Estacionamiento_poo(){}

    public Estacionamiento_poo(String nombre) {
        this.nombre = nombre;
        
        this.islas.add(new Isla(1));
        this.islas.add(new Isla(2));
        this.islas.add(new Isla(3));
    }

    @Override
    public void cobrar(Alquiler transaccion) {
        float total = transaccion.calcularSaldo();
        System.out.println("\n--- TICKET DE COBRO ---");
        System.out.println("Vehículo Patente: " + transaccion.getVehiculo().getPatente());
        System.out.println("Isla usada: " + transaccion.getIsla().getNro());
        System.out.println("Total a pagar: $" + total);
        transaccion.registrarPago(); 
        System.out.println("Estado del alquiler: ¡PAGADO!");
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Estacionamiento_poo predioCentro = new Estacionamiento_poo("Estacionamiento Central");

        Vehiculo auto = new Vehiculo();
        auto.setPatente("AF123JK");
        auto.setTarifa(1200.0f);

        Isla islaAsignada = predioCentro.islas.get(0);
        islaAsignada.setEstado(true);
        
        LocalTime entrada = LocalTime.of(8, 0); 
        Alquiler alquilerAuto = new Alquiler(entrada, auto, islaAsignada);

        //El vehículo se retira a las 10:30 hs (Se queda 2 horas y media)
        LocalTime salida = LocalTime.of(10, 30);
        alquilerAuto.registrarSalida(salida);
        islaAsignada.setEstado(false);

        predioCentro.cobrar(alquilerAuto);
    }
}
