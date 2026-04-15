# Solución Actividad 3

## Clase Usuario

```java
package mensajero;
import java.util.ArrayList;

/**
 * @author Profe
 */
public class Usuario {
    private String nombre;
    private ArrayList<Mensaje> recibidos = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void enviarMensaje(String msj, Usuario destino){
        Mensaje nuevoMsj = new Mensaje(msj, this);
        destino.recibirMensaje(nuevoMsj);
    }
    
    public void recibirMensaje(Mensaje msj){
        this.recibidos.add(msj);
    }
    
    public void verMensajes(){
        for(Mensaje msj : recibidos){
            System.out.println(msj.getRemitente() + " : " + msj.getContenido());
        }
    }
    
}
```
## Clase Mensaje
```java
package mensajero;
/**
 * @author Profe
 */
public class Mensaje {
    private String contenido;
    private Usuario remitente;
    
    public Mensaje(String contenido, Usuario remitente){
        this.contenido = contenido;
        this.remitente = remitente;
    }
    
    public String getContenido(){
       return this.contenido;
    }
    
    public String getRemitente(){
        return remitente.getNombre();
    }
    
}

```