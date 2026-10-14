# Gestión de Datos Seguros con DTOs y Respuestas Genéricas
En el sistema de un banco, la entidad Cliente maneja información interna y confidencial (por ejemplo, el campo pass o la clave numérica de identificación id). Cuando necesitamos consultar los datos de un usuario para mostrarlos por pantalla o enviarlos a otra capa de la aplicación, nunca debemos exponer la contraseña.
Para resolver esto, estructuraremos el proyecto utilizando objetos de transferencia (ClienteDTO) y un contenedor genérico de respuestas (RespuestaDTO).

**Consigna:**
Partiendo del código base provisto en clase (main), deberán completar y extender la aplicación en Java creando las siguientes clases:
+ Cliente 
+ ClienteDTO
+ RespuestaDTO<T>


¿Por qué la clase ClienteDTO no incluye el atributo pass ni el id. ¿Qué ventaja de seguridad nos aporta esto?

## main
```java
package bancomacro;
/**
 * @author Profe
 */
public class BancoMacro {
    
    public static ClienteDTO convertirADTO(Cliente cli){
        return new ClienteDTO(cli.getNombre(),
                cli.getApellido(), 
                cli.getDni());
    }
    
    public static void main(String[] args) {
        Cliente cli = new Cliente(661L, "Rogelio", "Rojas", "22876543", "1234");
        ClienteDTO cliDTO = convertirADTO(cli);
        
        RespuestaDTO<ClienteDTO> respuesta = new RespuestaDTO<>(true,"Encontrado",cliDTO);
        
    }
    
```
---
# Solución

## Cliente.java
```java
package bancomacro;

/**
 *
 * @author Profe
 */
public class Cliente {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String pass;

    public Cliente(Long id, String nombre, String apellido, String dni, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
        
}

```
## ClienteDTO.java
```java
package bancomacro;
public class ClienteDTO {
    private String nombre;
    private String apellido;
    private String dni;

    public ClienteDTO(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    } 
}

```
## Respuesta.java
```java
package bancomacro;
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

    public boolean isExito() {
        return exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getDatos() {
        return datos;
    }
     
}

```