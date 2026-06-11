package complejocanchas;

public class Cancha {
    
    private int tarifa;
    private float nro;

    public Cancha() {
    }

    public Cancha(int tarifa, float nro) {
        this.tarifa = tarifa;
        this.nro = nro;
    }

    public int getTarifa() {
        return tarifa;
    }

    public float getNro() {
        return nro;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public void setNro(float nro) {
        this.nro = nro;
    }
    
}
