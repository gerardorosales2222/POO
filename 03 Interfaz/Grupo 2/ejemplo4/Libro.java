
package ejemplo4_interfaz;

/**
 *
 * @author Carmen
 */
public class Libro implements Libreria{
    private String Titulo;
    private String Autor;
    private int publicacion;
    private String genero;
    private double precio;
    
    public Libro(){
        
    }
    
    public Libro(String Titulo, String Autor, int publicacion, String genero, double precio) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.publicacion = publicacion;
        this.genero = genero;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public void mostrarDetalle() {
        System.out.println("----------------------------");
        System.out.println("LIBRO: ");
        System.out.println("Titulo: " + Titulo);
        System.out.println("Autor: " + Autor);
        System.out.println("Publicacion: " + publicacion);
        System.out.println("Genero: " + genero);
        System.out.println("Precio: $" + precio);
    }
    
}
