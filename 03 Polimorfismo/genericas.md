# Clases Genéricas (Generics) en Java

## Introducción
En Java, cuando queremos crear colecciones o clases contenedoras que puedan trabajar con distintos tipos de datos, nos encontramos con un desafío: **¿cómo mantenemos la reutilización de código sin perder la seguridad de tipos?**

Históricamente (antes de Java 5), para lograr esto se recurría a la clase `Object` y al **casteo explícito**. Sin embargo, los **Generics** (Clases Genéricas) llegaron para resolver las desventajas del casteo manual, ofreciendo código más limpio y seguro en tiempo de compilación.

---

## 1. El Problema Histórico: El uso de `Object` y el Casteo Manual

Como toda clase en Java hereda de `Object` (Upcasting implícito), podíamos crear una caja capaz de guardar cualquier elemento:

```java
public class CajaAntigua {
    private Object contenido;

    public void guardar(Object elemento) {
        this.contenido = elemento; // Upcasting a Object
    }

    public Object obtener() {
        return this.contenido;
    }
}
```
### 1.1. ¿Cuál es la desventaja de este enfoque?
Al recuperar el objeto con obtener(), Java solo sabe que devuelve un Object. Por lo tanto, estabamoss obligados a hacer un Downcasting explícito:
```java
CajaAntigua caja = new CajaAntigua();
caja.guardar("Hola Mundo");

// DOWNCASTING OBLIGATORIO:
String texto = (String) caja.obtener();
```

> ⚠️ **El gran riesgo:** Si uno se equivocaba de tipo al castear, la aplicación no daba error al compilar, pero fallaba catastróficamente en tiempo de ejecución con un `ClassCastException`.
> 
> Para comprender en detalle qué es el Downcasting, la diferencia con el Parseo y los riesgos del `ClassCastException`, revisa esta guía previa:
> 👉 **[Guía de Casteo en Java](https://github.com/gerardorosales2222/POO/blob/main/03%20Polimorfismo/cast.md)**

### Ejemplo de equivocación de tipo al castear
```java
CajaAntigua caja1 = new CajaAntigua();
CajaAntigua caja2 = new CajaAntigua();

caja1.guardar("Hola Mundo"); // Guardamos un String
caja2.guardar(42);           // Guardamos un Integer

```

Al momento de leer o recuperar el contenido mediante caja.obtener(), el método te devuelve una referencia de tipo Object.

Como el compilador no recuerda qué guardaste exactamente dentro de la caja, estás obligado a forzar el casteo al tipo que crees que hay dentro. Si te equivocas de tipo en el paréntesis, es donde todo falla.

```java
// Supongamos que en el código del programa nos confundimos las cajas:

// Creemos que caja2 tenía un String, pero en realidad tenía un Integer (42)
String texto = (String) caja2.obtener();
```
El compilador dice: "Bueno, obtener() da un Object y el programador me está diciendo explícitamente con (String) que está seguro de que ahí hay un String. Todo parece correcto". Compila sin lanzar ningún error.

Pero en tiempo de ejecución: Cuando el programa se ejecuta y abre la caja2, descubre que en la memoria RAM el objeto real es un Integer (42). Como un Integer no es un String, Java detiene el programa inmediatamente y lanza:
>java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String

## 2. La Solución: Clases Genéricas (<T>)
Una Clase Genérica permite parametrizar el tipo de dato. Es decir, el tipo de dato se pasa como si fuera un parámetro usando la sintaxis de corchetes angulares <T>.
```java
public class Caja<T> {
    private T contenido;

    public void guardar(T elemento) {
        this.contenido = elemento;
    }

    public T obtener() {
        return this.contenido;
    }
}
```
## 3. Ventajas de los Generics frente al Casteo
A. Eliminación del Casteo Manual
Ya no necesitamos colocar (String) ni (Integer) al recuperar el elemento. Java sabe exactamente qué tipo de dato hay en el contenedor.
```java
Caja<String> cajaTexto = new Caja<>();
cajaTexto.guardar("mi texto");

// Se obtiene directamente como String, SIN casteo explícito:
String texto = cajaTexto.obtener();
```
B. Seguridad de Tipos en Tiempo de Compilación (Type Safety)
Si intentas guardar un tipo de dato incorrecto, el compilador detectará el error inmediatamente y no te dejará compilar el programa:

```java
Caja<Integer> cajaNumero = new Caja<>();
cajaNumero.guardar(100); // El compilador admite como parámetro de guardar solamente Integers

// EJEMPLO DE POSIBLE ERROR DE COMPILACIÓN:
// cajaNumero.guardar("Cincuenta"); // ❌ El compilador rechaza esto antes de ejecutar
```


### Comparativa: Generics vs. Casteo de Objetos (`Object`)

| Criterio | Casteo de Objetos (`Object`) | Generics (`<T>`) |
| :--- | :--- | :--- |
| **Sintaxis** | Requiere el tipo entre paréntesis `(Tipo)` al recuperar el objeto. | Utiliza parámetros de tipo `<T>` al declarar la clase o método. |
| **Recuperación de datos** | **Manual:** Obliga a realizar un Downcasting explícito. | **Automática:** Se obtiene el tipo correcto sin escribir casteos. |
| **Momento de verificación** | En **tiempo de ejecución** (Runtime). | En **tiempo de compilación** (Compile-time). |
| **Seguridad de tipos (*Type Safety*)** | **Baja:** Propensa a errores si se confunde el tipo guardado. | **Alta:** El compilador impide ingresar o extraer tipos no autorizados. |
| **Manejo de errores** | Lanza `ClassCastException` y detiene el programa en producción. | Muestra un **error de compilación** en el IDE antes de ejecutar. |
| **Legibilidad del código** | Más verboso y sucio debido a los paréntesis de casteo repetitivos. | Más limpio, expresivo y autocontenido. |
| **Reutilización de código** | Alta (mediante la superclase `Object`), pero insegura. | Alta y 100% segura. |

## Resumen
+ Los Generics nos permiten aplicar Polimorfismo Paramétrico.

+ Eliminan la necesidad de hacer Downcasting explícito para recuperar el tipo original de un objeto.

+ Trasladan la detección de errores de tipos desde el tiempo de ejecución (runtime) al tiempo de compilación.