
package estacionamiento;

public class Isla {
    private int nro;
    private boolean estado;
    
    public Isla(int par) {
    }
    public Isla(int nro, boolean estado) {
        this.nro = nro;
        this.estado = false;
    }
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
