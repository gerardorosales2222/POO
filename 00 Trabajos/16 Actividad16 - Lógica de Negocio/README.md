# Práctica: Autenticación Interactiva por Consola con DTOs y Respuestas Genéricas

## Objetivo
Implementar una aplicación interactiva en Java que utilice la clase `Scanner` para solicitar datos por consola, aplicando lógica de validación de credenciales (*login*), objetos de transferencia (`DTO`) y respuestas genéricas para proteger información sensible.

---

## Situación Problemática
En una plataforma de videojuegos online (*GamerZone*), la entidad `Usuario` almacena información privada, como la contraseña (`pass`) y el identificador interno (`id`). Cuando un usuario desea iniciar sesión, debe ingresar su nombre de usuario y su contraseña por consola. El sistema debe validar las credenciales:
* Si son correctas, permite el acceso y retorna los datos del perfil (mostrando nombre y correo, **sin exponer la contraseña ni el ID**).
* Si son incorrectas, rechaza el acceso informando el error.

---

## Consigna

Deberá programar una aplicación en Java que conste de las siguientes clases dentro del paquete `gamerzone`:

1. **`Usuario`**: Atributos privados (`id`, `nombreUsuario`, `correo`, `pass`), constructor, getters y setters.
2. **`UsuarioDTO`**: Atributos privados para la vista pública (`nombreUsuario`, `correo`), constructor, getters y el método `toString()`.
3. **`RespuestaDTO<T>`**: Clase genérica para estandarizar las respuestas del sistema (`exito`, `mensaje`, `datos`).
4. **`Main` (o clase principal)**: 
   * Debe inicializar un objeto `Usuario` registrado en el sistema con datos de prueba (ej: `id = 10L`, `nombreUsuario = "GamerPro99"`, `correo = "pro@gamer.com"`, `pass = "secret123"`).
   * Utilizar la librería `Scanner` para pedirle al usuario por consola que ingrese su **nombre de usuario** y su **contraseña**.
   * Implementar un método estático de inicio de sesión que valide los datos ingresados frente al usuario registrado y retorne un `RespuestaDTO<UsuarioDTO>`.
   * Mostrar por pantalla el resultado de la operación (mensaje de éxito con los datos del DTO o mensaje de error).

---

## Usuario.java
```java
package gamerzone;

public class Usuario {
    private Long id;
    private String nombreUsuario;
    private String correo;
    private String pass;

    public Usuario(Long id, String nombreUsuario, String correo, String pass) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}