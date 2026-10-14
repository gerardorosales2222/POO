# Guía de Repaso: Conceptos Clave sobre DTOs, Seguridad y Estructuras en Java

Antes de responder el formulario de evaluación, lo invitamos a realizar una breve lectura de repaso sobre los conceptos fundamentales que estuvimos trabajando en clase. Esta síntesis le ayudará a afianzar los temas centrales y a comprender el *porqué* detrás de cada decisión de diseño en el código.

---

### 1. ¿Qué es un DTO y por qué lo utilizamos?
En el desarrollo de software, a menudo manejamos clases de entidad (como `Usuario` o `Cliente`) que contienen información completa y confidencial de la base de datos. Sin embargo, cuando necesitamos mostrar datos en la interfaz, enviarlos por consola o transmitirlos a otra capa, **no debemos exponer información sensible** (como contraseñas o identificadores internos).

Para resolver esto, utilizamos los **DTO** (*Data Transfer Object* o *Objeto de Transferencia de Datos*). Un DTO es una clase liviana cuyo único propósito es transportar exclusivamente los datos que la vista o el cliente necesita ver, manteniendo protegida la entidad original.

### 2. La importancia de la inmutabilidad (Sin `setters`)
Al diseñar un DTO (como `UsuarioDTO`), es una buena práctica incluir únicamente un constructor para inicializar sus valores y **métodos getters**, pero **evitar los métodos setters**. 
¿Por qué? Porque un DTO debe ser un objeto de lectura (*read-only* o inmutable) durante su transporte. Si permitiéramos modificar sus campos libremente mediante setters a lo largo del sistema, perderíamos el control sobre la integridad de los datos que estamos visualizando o transfiriendo.

### 3. Clases Genéricas y Estandarización de Respuestas (`RespuestaDTO<T>`)
Para que nuestra aplicación sea ordenada y profesional, no nos limitamos a devolver solo el objeto de datos. Implementamos clases envoltorias genéricas como `RespuestaDTO<T>`. 
* El uso del parámetro genérico **`<T>`** es clave: nos permite reutilizar la misma estructura de respuesta para cualquier tipo de objeto (puede envolver un `UsuarioDTO`, un `ProductoDTO`, etc.).
* Esta clase agrupa el estado de la operación (`exito` como booleano), un mensaje descriptivo para el usuario ("Acceso concedido", "Error de credenciales") y los datos propiamente dichos.

### 4. Lógica de Validación y Manejo de Errores (`null`)
Cuando implementamos la lógica de inicio de sesión (*login*), validamos las credenciales ingresadas por consola (mediante la librería `Scanner`) frente a los datos registrados. 
* Si las credenciales son correctas, el sistema realiza la conversión a DTO y retorna una respuesta exitosa con los datos.
* Si las credenciales son incorrectas, la operación no encuentra un perfil válido que mostrar; por esta razón, el atributo `datos` del `RespuestaDTO` se establece en **`null`**, evitando así exponer información innecesaria o errónea.

### 5. El proceso de Mapeo (`convertirADTO`)
Para transformar una entidad completa en su versión reducida y segura, utilizamos métodos auxiliares de conversión o mapeo (como `convertirADTO`). Este método actúa como un puente que toma la información pública de la entidad original (nombre, correo) y construye un nuevo DTO listo para ser consumido de forma segura.

