# Trabajo Práctico: Transferencia Segura de Datos y Envoltorios Genéricos en POO
Comprender e implementar el patrón DTO (Data Transfer Object) junto con el uso de Clases Genéricas (Generics) para el filtrado, desacoplamiento y transporte seguro de información entre capas de software sin exponer datos sensibles.

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