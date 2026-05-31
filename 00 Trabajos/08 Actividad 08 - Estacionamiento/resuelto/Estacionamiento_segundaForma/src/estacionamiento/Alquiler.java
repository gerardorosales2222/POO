/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

/**
 *
 * @author jogag
 */
public class Alquiler {
      private int id;
    private int horas;
    private int horaInicial;
    private int horaSalida;
    private String estado;

    private Vehiculo vehiculo;
    private Isla isla;

    public Alquiler() {
    }

    public Alquiler(int id,int horaInicial ,int horaSalida,String estado, Vehiculo vehiculo, Isla isla) {
        this.id = id;
       
        this.horaInicial=horaInicial;
        this.horaSalida=horaSalida;
        this.estado = estado;
        this.horas=horaSalida-horaInicial;
        this.vehiculo = vehiculo;
        this.isla = isla;
    }

    public int getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }


    public int getId() {
        return id;
    }

    public int getHoras() {
        return horas;
    }

    public String getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Isla getIsla() {
        return isla;
    }
    
     public void mostrarAlquiler(double total) {

        System.out.println("----ESTACIONAMIENTO----");
        int n=1;
        System.out.println("["+n+"] Cliente: " + vehiculo.getCliente().getNombre());
           n++;
        System.out.println("Telefono: " + vehiculo.getCliente().getTelefono());

        System.out.println("----------------");

        System.out.println("Vehiculo: " + vehiculo.getMarca());

        System.out.println("Patente: " + vehiculo.getPatente());

        System.out.println("Tipo: "  + vehiculo.getTipo());

        System.out.println("----------------");
        
     
      System.out.println("Estado alquiler: " + estado + " | Horas: " + horas + " | Isla asignada: " + isla.getNumero()  );
        System.out.println("----------------");

        System.out.println("TOTAL A PAGAR: $" + total);


    }

}
