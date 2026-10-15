package login;

/**
 *
 * @author Profe
 */
public class Usuario {
    
    private Long id;
    private String nombre;
    private String email;
    private String pass;

    public Usuario(Long id, String nombre, String email, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public boolean logearse(String pass){
        if(pass.equalsIgnoreCase(this.pass)){
            return true;
        }else{
            return false;
        }
        
    }
    
}
