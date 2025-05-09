
package ejemplo4_interfaz;

/**
 *
 * @author Carmen
 */
public class Comic implements Libreria {
    private String Titulo;
    private String Autor;
    private int publicacion;
    private String dibujante;
    private double precio;
    
    public Comic(){
        
    }
    
    public Comic(String Titulo, String Autor, int publicacion, String dibujante, double precio) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.publicacion = publicacion;
        this.dibujante = dibujante;
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

    public String getDibujante() {
        return dibujante;
    }

    public void setDibujante(String dibujante) {
        this.dibujante = dibujante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    @Override
    public void mostrarDetalle() {
        System.out.println("-------------------------");
        System.out.println("COMIC: ");
        System.out.println("Titulo: " + Titulo);
        System.out.println("Autor: " + Autor);
        System.out.println("Publicacion: " + publicacion);
        System.out.println("Genero: " + dibujante);
        System.out.println("Precio: $" + precio);
    }
    
}
