
package ejemplo4_interfaz;

/**
 *
 * @author Carmen
 */
public class Revista implements Libreria{
    private String Titulo;
    private String Autor;
    private int publicacion;
    private int numeroEdicion;
    private double precio;
    
    public Revista(){
        
    }
    public Revista(String Titulo, String Autor, int publicacion, int numeroEdicion, double precio) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.publicacion = publicacion;
        this.numeroEdicion = numeroEdicion;
        this.precio = precio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public void mostrarDetalle() {
        System.out.println("REVISTA: ");
        System.out.println("Titulo: " + Titulo);
        System.out.println("Autor: " + Autor);
        System.out.println("Publicacion: " + publicacion);
        System.out.println("Numero de Edicion: " + numeroEdicion);
        System.out.println("Precio: $" + precio);
    }
    
}
