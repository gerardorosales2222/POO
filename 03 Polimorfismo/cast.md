# Casteo
El casteo (o type casting) es indicarle al compilador que trate el valor de una variable como si fuera de un tipo de dato diferente.

Podriamos decir que es el proceso de convertir explícitamente o tratar una variable como si fuera de un tipo de dato diferente al que fue declarada originalmente.

## 1. En Java existen dos tipos de casteo totalmente distintos:

+ 1.1. Casteo de primitivos: Ocurre entre números simples (como pasar de double a int: ```(int) 3.14)```.

+ 1.2. Casteo de objetos (Upcasting / Downcasting): Ocurre entre referencias a clases que comparten una jerarquía de herencia (Padre e Hijo).

## 1.1. Casteo de tipos primitivos. Ejemplo:
```java
        double precio = 765.99;
        int precioSinCentavos = (int) precio;
        System.out.println("num: " + precioSinCentavos);
```
Específicamente, se llama casteo explícito de tipos primitivos (o casting de estrechamiento / narrowing casting).
La sintaxis propia del casteo en Java indica colocar el tipo de dato de destino entre paréntesis ```(int)```.

Al hacer esto, le ordenamos a Java: "Toma el valor decimal que está guardado en precio, recorta su parte decimal y trátalo directamente como un número entero".

## Diferencia entre Castear y Parsear

Es común confundir estos términos, pero realizan operaciones completamente distintas en memoria:

+ **Castear:** Reinterpreta o recorta un valor que ya es de un tipo compatible (como recortar los decimales de un `double` a un `int`, o tratar un `Pato` como un `Animal`). Se usa la sintaxis de paréntesis `(tipo)`.
+ **Parsear:** Toma una cadena de texto (`String`), analiza sus caracteres uno a uno mediante un algoritmo y **construye un nuevo valor** de otro tipo desde cero (como transformar la palabra `"87"` en el número `87`). Se logra llamando a métodos de utilidad como `Integer.parseInt()`.

### Ejemplo comparativo:

```java
// 1. CASTEO: Solo recorta/reinterpreta el valor numérico existente
double precio = 765.99;
int precioSinCentavos = (int) precio; // Resultado: 765

// 2. PARSEO: Analiza el texto y construye un nuevo número desde cero
String textoPrecio = "765";
int precioParseado = Integer.parseInt(textoPrecio); // Resultado: 765
```

## 1.2. Casteo de Objetos. Ejemplo:

Ocurre entre referencias que comparten una **relación de subtipado** (ya sea por herencia con `extends` o por implementación de interfaces con `implements`). A diferencia de los primitivos, aquí el objeto en memoria no cambia ni se recorta: solo cambia la perspectiva con la que el código accede a él.

---

### 1.2.1. El Ejemplo Más Simple (Clase Padre e Hija)

Antes de ver interfaces o métodos avanzados, este es el caso más directo posible usando dos clases relacionadas por herencia (`class Perro extends Animal`):

```java
// Clases base
class Animal {}
class Perro extends Animal {
    void ladrar() { System.out.println("¡Guau!"); }
}

public class EjemploSimple {
    public static void main(String[] args) {
        
        Perro miPerro = new Perro();

        // UPCASTING (Implícito)
        // Guardamos un Perro en una referencia de tipo Animal.
        // No requiere paréntesis porque todo Perro ES un Animal.
        Animal miAnimal = miPerro; 

        // DOWNCASTING (Explícito)
        // Recuperamos la referencia específica de Perro.
        // Requiere paréntesis (Perro) para confirmarle a Java el tipo real.
        Perro perroRecuperado = (Perro) miAnimal;
        perroRecuperado.ladrar(); // Ahora podemos llamar a sus métodos propios
    }
}
```
### 1.2.2. Ejemplo con Interfaces

Una **interfaz** define qué *puede hacer* un objeto (un comportamiento). Cuando una clase implementa una interfaz, automáticamente se convierte en un "subtipo" de ella.
```java
package animales;
// Quien implemente esta interface será un Nadador
public interface Nadador {
    public void nadar();
}
```
Pensémoslo así: **un Pato ES UN Nadador** porque Pato implementa la interface:
```java
public class Pato implements Nadador, Volador {
    
    @Override
    public void nadar() {
        System.out.println("El pato está nadando.");
    }
```

En el siguiente main vamos a hacer el casteo:

```java
package animales;
public static void main(String[] args) {
        
    Pato patoOriginal = new Pato();

    // UPCASTING: Guardamos el Pato en una variable de tipo Nadador (Implícito)
    Nadador miNadador = patoOriginal;
    miNadador.nadar(); 

    // ¡Ojo! Como la variable es de tipo Nadador, Java solo "ve" la habilidad de nadar.
    // miNadador.volar(); // ERROR: Un "Nadador" genérico no sabe volar.

    // DOWNCASTING: Devolvemos la variable a su tipo real 'Pato' (Explícito)
    Pato patoRecuperado = (Pato) miNadador;
    patoRecuperado.volar(); // ¡Ahora sí! Un Pato sabe volar y nadar.
}
```

---

## 📝 Actividad de Autoevaluación

Para poner a prueba lo aprendido...

👉 **[Realizar el Test de Autoevaluación (Google Forms)](https://forms.gle/V3RRTJ8nRJNWnutu7)**
