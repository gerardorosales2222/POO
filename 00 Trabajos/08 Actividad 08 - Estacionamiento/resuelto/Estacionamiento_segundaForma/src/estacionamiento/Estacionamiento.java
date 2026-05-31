/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author jogag
 */
public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // GESTION DE ISLAS
        GestionIsla gestion= new GestionIsla();

        Isla i1 = new Isla(1, 1, true);
        Isla i2 = new Isla(2, 2, true);

        gestion.agregarIsla(i1);
        gestion.agregarIsla(i2);

        // CLIENTE
        Cliente c1= new Cliente(1,"Jose",  "123456"  );
        Cliente c2= new Cliente(1,"Victor",  "3345"  );
        
        // VEHICULO
        Vehiculo v1 = new Vehiculo(  1,"AA111",  "Toyota", "Automovil", 1000, c1);
         Vehiculo v2 = new Vehiculo(  1,"EE333",  "4x4", "Camioneta", 1500, c2);

        // ALQUILER
        Alquiler a1 = new Alquiler( 1,3,5,"Activo",v1, i1 );
        Alquiler a2 = new Alquiler( 2,5,8,"Activo",v2, i2 );
        
        // COBRO
        Cobro cobro = new CobroImple();

        double total1 = cobro.calcularCobro(  v1,a1.getHoras());
        double total2 = cobro.calcularCobro(  v2,a2.getHoras());
        
        // MOSTRAR DATOS
        a1.mostrarAlquiler(total1);
        a2.mostrarAlquiler(total2);
        
        // MOSTRAR ISLAS
        gestion.mostrarIslas();

    }
}
