# Ejercicio Resuelto

## Usuario.java
```java
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
```

## UsuarioDTO
```java
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
```
## RespuestaDTO
```java
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
```

## main
```java
package login;
/**
 * @author Profe
 */
public class Login {

    public static UsuarioDTO convertirADTO(Usuario user) {
        return new UsuarioDTO(user.getNombre(), user.getEmail());
    }
    
    public static void main(String[] args) {
        
        Usuario user = new Usuario(1L,"Roman","rom67@gmail.com","123");
        UsuarioDTO userDTO = convertirADTO(user);
        boolean login = user.logearse("123");
        if(login){
            RespuestaDTO<UsuarioDTO> ok = new RespuestaDTO(login,"Permitido", userDTO);
            System.out.println("Acceso permitido..."+ok);
        }else{
            RespuestaDTO<UsuarioDTO> mal = new RespuestaDTO(login,"Denegado", null);
            System.out.println("Acceso denegado!");
        }
        
    }
    
}

```