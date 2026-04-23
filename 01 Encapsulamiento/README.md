# Encapsulamiento en POO

El **encapsulamiento** es uno de los pilares fundamentales de la Programación Orientada a Objetos. Consiste en ocultar el estado interno de un objeto y obligar a que toda interacción se realice a través de una interfaz pública bien definida.

## Conceptos Clave

* **Modificadores de Acceso:** 
Los modificadores definen la visibilidad de los atributos y métodos, determinando quién puede ver o modificar la información desde fuera o dentro de la jerarquía de clases.

    + private (-): Es el nivel más restrictivo. El atributo o método solo es accesible dentro de la misma clase donde fue definido. Se usa para aplicar el Encapsulamiento, protegiendo los datos de manipulaciones externas indebidas.

    + public (+): Es el nivel más abierto. El atributo o método es accesible desde cualquier otra clase, sin importar el paquete en el que se encuentre. Generalmente se usa para los métodos (comportamientos) que forman la interfaz de interacción del objeto.

    + protected (#): Es el modificador clave para la Herencia. Permite que el atributo o método sea accesible por:

        1. La propia clase que lo define.

        2. Todas sus clases hijas (subclases), incluso si están en paquetes diferentes.

        3. Otras clases que se encuentren dentro del mismo paquete.

        **Uso común de protected**: Se aplica a los atributos de una clase "Padre" (como Producto) para que sus "Hijos" (como Herramienta) puedan usar los datos directamente sin necesidad de intermediarios.

* **Getters (Accesores):** Métodos que permiten consultar el valor de un atributo protegido.
* **Setters (Mutadores):** Métodos que permiten modificar el valor de un atributo, permitiendo incluir validaciones de seguridad o reglas de negocio.
* **Integridad de Datos:** Evitar que clases externas modifiquen directamente valores sensibles (como el saldo de una cuenta) sin pasar por los controles correspondientes.

---

## Material de Estudio

En el siguiente video analizamos de forma práctica cómo implementar el encapsulamiento utilizando un ejemplo de una "Billetera Virtual" en Java, aplicando modificadores de acceso y métodos Get y Set.

[![POO 02 - Encapsulamiento](https://img.youtube.com/vi/2oR9K5AIaGM/0.jpg)](https://www.youtube.com/watch?v=2oR9K5AIaGM "Ver Video de Encapsulamiento")

> Presiona Ctrl + clic sobre la imagen para abrir un video explicativo en una nueva pestaña.

---

## Buenas Prácticas de la Industria

1.  **Atributos Privados por Defecto:** Siempre declarar los atributos como `private`.
2.  **Validación en Setters:** No solo asignar el valor, sino verificar que sea coherente (ej: que un monto a depositar no sea negativo).
3.  **Ocultamiento de Implementación:** El "mundo exterior" no necesita saber cómo se guardan los datos, solo cómo interactuar con ellos de forma segura.