# Encapsulamiento en POO

El **encapsulamiento** es uno de los pilares fundamentales de la Programación Orientada a Objetos. Consiste en ocultar el estado interno de un objeto y obligar a que toda interacción se realice a través de una interfaz pública bien definida.

## Conceptos Clave

* **Modificadores de Acceso:** Uso de `private` para proteger los atributos y `public` para los métodos que permiten la interacción.
* **Getters (Accesores):** Métodos que permiten consultar el valor de un atributo protegido.
* **Setters (Mutadores):** Métodos que permiten modificar el valor de un atributo, permitiendo incluir validaciones de seguridad o reglas de negocio.
* **Integridad de Datos:** Evitar que clases externas modifiquen directamente valores sensibles (como el saldo de una cuenta) sin pasar por los controles correspondientes.

---

## 📺 Material de Estudio

En el siguiente video analizamos de forma práctica cómo implementar el encapsulamiento utilizando un ejemplo de una "Billetera Virtual" en Java, aplicando modificadores de acceso y métodos Get y Set.

[![POO 02 - Encapsulamiento](https://img.youtube.com/vi/2oR9K5AIaGM/0.jpg)](https://www.youtube.com/watch?v=2oR9K5AIaGM "Ver Video de Encapsulamiento")

> **Tópicos del video:** > - ¿Por qué es un error acceder directamente a los atributos? [00:02:20]
> - Implementación de métodos `get` [00:03:45]
> - Implementación de métodos `set` y protección del saldo [00:07:22]
> - Notación en diagramas de clases UML (+ para público, - para privado) [00:11:30]

---

## 🛠️ Buenas Prácticas de la Industria

1.  **Atributos Privados por Defecto:** Siempre declarar los atributos como `private`.
2.  **Validación en Setters:** No solo asignar el valor, sino verificar que sea coherente (ej: que un monto a depositar no sea negativo).
3.  **Ocultamiento de Implementación:** El "mundo exterior" no necesita saber cómo se guardan los datos, solo cómo interactuar con ellos de forma segura.