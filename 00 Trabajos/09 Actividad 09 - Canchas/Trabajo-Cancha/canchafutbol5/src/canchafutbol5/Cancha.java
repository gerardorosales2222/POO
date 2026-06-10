package canchafutbol5;

public class Cancha {
    private int numero;
    private float TarifaPorHora;

    public Cancha() {
    }

    public Cancha(int numero, float TarifaPorHora) {
        this.numero = numero;
        this.TarifaPorHora = TarifaPorHora;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getTarifaPorHora() {
        return TarifaPorHora;
    }

    public void setTarifaPorHora(float TarifaPorHora) {
        this.TarifaPorHora = TarifaPorHora;
    }

    
    
}
