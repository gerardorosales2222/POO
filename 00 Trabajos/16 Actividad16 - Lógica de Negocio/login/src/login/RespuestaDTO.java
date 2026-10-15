package login;

/**
 *
 * @author Profe
 */
public class RespuestaDTO<T> {
    private boolean exito;
    private String mensaje;
    private T datos;

    public RespuestaDTO(boolean exito, String mensaje, T datos) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.datos = datos;
    }
    
    
    
}
