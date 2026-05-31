/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamiento;

import java.util.ArrayList;

/**
 *
 * @author jogag
 */
public class GestionIsla {

    private ArrayList<Isla> listaIslas = new ArrayList<>();

    public void agregarIsla(Isla isla) {
        listaIslas.add(isla);

    }

    public void mostrarIslas() {

        for (Isla i : listaIslas) {
            System.out.println("ID: " + i.getId() + " | Numero: " + i.getNumero() + " | Disponible: " + i.isDisponible()
            );
        }
    }
}
