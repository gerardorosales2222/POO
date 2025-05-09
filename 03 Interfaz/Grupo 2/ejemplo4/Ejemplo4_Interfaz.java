
package ejemplo4_interfaz;

/**
 *
 * @author Carmen
 */
public class Ejemplo4_Interfaz {

    public static void main(String[] args) {
       Revista revistas=new Revista("Computer Hoy", "Equipo editorial de PC Actual", 1995, 12, 3500);
       Comic comics=new Comic("Batman:El Caballero Oscuro", "Frank Miller", 1986, "Frank Miller", 4000);
       Libro libros=new Libro("Crepusculo", "Stephenie Meyer", 1996, "Romance Paranormal" , 7000);
       
       revistas.mostrarDetalle();
       comics.mostrarDetalle();
       libros.mostrarDetalle();
    }
    
}
