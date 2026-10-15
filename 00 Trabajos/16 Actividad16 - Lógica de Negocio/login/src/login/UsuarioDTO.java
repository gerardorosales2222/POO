
package login;

/**
 *
 * @author Profe
 */
public class UsuarioDTO {
    private String nombre;
    private String email;

    public UsuarioDTO(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
     
    
    
    
}
