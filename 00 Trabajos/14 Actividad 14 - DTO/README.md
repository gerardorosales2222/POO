# Trabajo Práctico: Transferencia Segura de Datos y Envoltorios Genéricos en POO
En este TP vamos a comprender e implementar el patrón DTO (Data Transfer Object) junto con el uso de Clases Genéricas (Generics) para el filtrado, desacoplamiento y transporte seguro de información entre capas de software sin exponer datos sensibles.

**Consigna:** A partir de la siguiente clase main deberá desarrollar la Clase Usuario y UsuarioDTO para que todo funcione correctamente.  

```java
package dto;
/**
* @author Profe
*/
public class DTO {

    public static UsuarioDTO convertirADto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombreCompleto(),
                usuario.getEmail()
        );
    }
    
    public static void main(String[] args) {
       // 1. Simular la entidad que recuperamos de la base de datos
        Usuario usuarioBD = new Usuario(
                1L,
                "Juan Perez",
                "juancito.perez@email.com",
                "P@ssw0rd123!", //Contraseña sensible
                "ROLE_ADMIN"    //Rol interno
        );

        UsuarioDTO dto = convertirADto(usuarioBD);

        System.out.println("=== DATOS ENVIADOS AL FRONTEND ===");
        System.out.println(dto);
        
    }
    
}
```
---
# Solución

## Usuario.java
```java
package dto;
/**
 * @author Profe
 */
public class Usuario {
       private Long id;
        private String nombreCompleto;
        private String email;
        private String password;
        private String rolSeguridad;

        public Usuario(Long id, String nombreCompleto, String email, String password, String rolSeguridad) {
            this.id = id;
            this.nombreCompleto = nombreCompleto;
            this.email = email;
            this.password = password;
            this.rolSeguridad = rolSeguridad;
        }

        public Long getId() { return id; }
        public String getNombreCompleto() { return nombreCompleto; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getRolSeguridad() { return rolSeguridad; }    
}
```
## UsuarioDTO.java
```java
package dto;
/**
 * @author Profe
 */
public class UsuarioDTO {
    private Long id;
    private String nombreCompleto;
    private String email;

    public UsuarioDTO(Long id, String nombreCompleto, String email) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "UsuarioDTO {" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
```