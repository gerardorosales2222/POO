# TP2 - Herencia en POO  
**Programación Orientada a Objetos**  
**Profesor: Gerardo René Rosales**  

## 1. Herencia  

### Definición  
La **herencia** es un mecanismo fundamental de la Programación Orientada a Objetos (POO) que permite crear nuevas clases (*subclases* o *clases derivadas*) basadas en clases existentes (*superclases* o *clases base*). La subclase hereda atributos y métodos de la superclase, fomentando la reutilización de código y la creación de jerarquías de clases.  

### Ejemplo en Java  
```java
// Clase base (superclase)
class Animal {
    String nombre;

    public void hacerSonido() {
        System.out.println("Sonido genérico de animal");
    }
}

// Clase derivada (subclase)
class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
    }
}

public class EjemploHerencia {
    public static void main(String[] args) {
        Perro miPerro = new Perro();
        miPerro.nombre = "Rex";
        miPerro.hacerSonido(); // Imprime "Guau!"
    }
}
```
# Conceptos Clave en Herencia  

### Clase Padre (*Superclase*)  
La clase padre, también conocida como *superclase* o *clase base*, es la clase de la que se heredan atributos y métodos. Define las características y comportamientos comunes que compartirán las subclases.  

### Clase Hija (*Subclase*)  
La clase hija, también llamada *subclase* o *clase derivada*, es la clase que hereda atributos y métodos de una clase padre. Puede agregar sus propios atributos y métodos específicos, o modificar los heredados mediante *sobreescritura de métodos*.  

### Herencia Simple  
La **herencia simple** ocurre cuando una subclase hereda de una única superclase. Es el tipo de herencia más común y el único soportado directamente por Java.  

```java
// Clase Padre
class Animal {
    String nombre;
    void respirar() {
        System.out.println("El animal está respirando");
    }
}

// Clase Hija
class Perro extends Animal {
    void ladrar() {
        System.out.println("El perro dice: ¡Guau!");
    }
}
```

### Herencia Múltiple  
La **herencia múltiple** permitiría que una subclase herede de múltiples superclases. Sin embargo, **Java no soporta directamente la herencia múltiple** debido a la complejidad y ambigüedad que puede generar (*problema del diamante*). Para evitar estos problemas, Java usa **interfaces** para simular la herencia múltiple.  

```java
// Definimos capacidades (Interfaces)
interface FuncionesReloj {
    void mostrarHora();
}

interface FuncionesTelefono {
    void hacerLlamada(String numero);
}

// La clase Smartwatch hereda de una base (opcional) e implementa múltiples interfaces
class DispositivoElectronico {
    void encender() {
        System.out.println("Iniciando sistema...");
    }
}

class Smartwatch extends DispositivoElectronico implements FuncionesReloj, FuncionesTelefono {
    
    @Override
    public void mostrarHora() {
        System.out.println("Son las 10:30 AM");
    }

    @Override
    public void hacerLlamada(String numero) {
        System.out.println("Llamando al " + numero + " desde el reloj...");
    }
}
```

### Herencia Multinivel  
La **herencia multinivel** se produce cuando una subclase hereda de otra subclase, creando una jerarquía de herencia.  

### Ejemplo en Java  
```java
class Vehiculo {
    String marca;
}

class Coche extends Vehiculo {
    int numeroPuertas;
}

class CocheDeportivo extends Coche {
    boolean turbo;
}

public class EjemploMultinivel {
    public static void main(String[] args) {
        CocheDeportivo miDeportivo = new CocheDeportivo();
        miDeportivo.marca = "Ferrari";
        miDeportivo.numeroPuertas = 2;
        miDeportivo.turbo = true;
    }
}
```

## 3. Reutilización de Código  

La **herencia** fomenta la reutilización de código, permitiendo que las subclases hereden atributos y métodos de la superclase. Esto reduce la duplicación de código y facilita el mantenimiento de los programas.  

---

# Polimorfismo en Herencia  

## ¿Qué tipo de polimorfismo se usa en herencia?  
En el contexto de la herencia, el polimorfismo más común es el **polimorfismo de subtipos** o **polimorfismo inclusivo**. Este permite que una instancia de una subclase sea tratada como una instancia de su superclase, lo que facilita la generalización y el manejo flexible de los objetos.  

### Ejemplo en Java  
```java
class Animal {
    public void hacerSonido() {
        System.out.println("Sonido genérico de animal");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("¡Guau!");
    }
}

class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("¡Miau!");
    }
}

public class EjemploPolimorfismo {
    public static void main(String[] args) {
        Animal miAnimal1 = new Perro(); // Tratamos un "Perro" como un "Animal"
        Animal miAnimal2 = new Gato(); // Tratamos un "Gato" como un "Animal"

        miAnimal1.hacerSonido(); // Imprime "¡Guau!"
        miAnimal2.hacerSonido(); // Imprime "¡Miau!"
    }
}
```
En este caso, aunque miAnimal1 y miAnimal2 son instancias de Perro y Gato, respectivamente, el código los trata como objetos de tipo Animal. Sin embargo, gracias a la sobrescritura de métodos, se ejecuta el comportamiento específico de cada subclase.

## ¿Es la herencia necesaria para todos los tipos de polimorfismo?
No. Aunque el polimorfismo de subtipos depende de la herencia, hay otros tipos de polimorfismo que no requieren una relación de herencia, como:

Polimorfismo paramétrico (uso de genéricos): Permite definir clases y métodos que funcionan con múltiples tipos sin necesidad de herencia.

```java
class Caja<T> {
    private T contenido;

    public void agregar(T elemento) {
        contenido = elemento;
    }

    public T obtener() {
        return contenido;
    }
}

public class EjemploGenerics {
    public static void main(String[] args) {
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.agregar("Hola, mundo!");
        System.out.println(cajaTexto.obtener()); // Imprime "Hola, mundo!"
    }
}
```
## Polimorfismo por sobrecarga de métodos: 
Se logra mediante la declaración de múltiples métodos con el mismo nombre pero diferentes parámetros, sin necesidad de herencia.

```java
class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }

    public double sumar(double a, double b) {
        return a + b;
    }
}

public class EjemploSobrecarga {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println(calc.sumar(5, 3)); // Imprime 8
        System.out.println(calc.sumar(5.5, 3.2)); // Imprime 8.7
    }
}
```
Como se puede ver, aunque la herencia es fundamental para ciertos tipos de polimorfismo (especialmente el de subtipos), no es imprescindible para todos. Java proporciona mecanismos alternativos para lograr comportamiento polimórfico sin necesidad de establecer una jerarquía de clases.

## Actividad a desarrollar:

Ejecuta los ejemplos de este material teórico en tu PC y realiza variaciones.

### Ejecución y Modificación de Ejemplos:
* Ejecuta los ejemplos proporcionados en el entorno de desarrollo NetBeans.
* Describe detalladamente las modificaciones que implementaste en el código de los ejemplos.
* Explica cómo cada una de tus modificaciones afectó el comportamiento original de los programas.
* **Incluye una captura de pantalla del código modificado.**

### Crear un Ejemplo Propio que incluya los conceptos vistos en este Trabajo Práctico:
* Describe el ejemplo de herencia que desarrollaste. Especifica claramente:
    * El tema o dominio del problema que aborda tu ejemplo.
    * La jerarquía de clases que definiste (clase padre y clases hijas).
    * Los atributos (variables) definidos en cada clase y su propósito.
    * Los métodos (funciones) implementados en cada clase y su funcionalidad.
* **Adjunta el código fuente completo de tu ejemplo propio.**
* Explica de manera concisa y clara cómo tu ejemplo práctico demuestra los conceptos fundamentales de herencia que se abordaron en este Trabajo Práctico.

### Preguntas de Reflexión:
* ¿Cuál consideras que es la principal ventaja de emplear la herencia dentro del paradigma de la Programación Orientada a Objetos (POO)? Justifica tu respuesta.
* ¿En qué escenarios o tipos de problemas crees que la herencia múltiple podría resultar particularmente útil, a pesar de las limitaciones que presentan algunos lenguajes de programación?
* Describe la relación fundamental que existe entre el concepto de polimorfismo y el mecanismo de la herencia en la POO. ¿Cómo se complementan estos dos conceptos?
* Comparte las dificultades específicas que encontraste al intentar aplicar los conceptos de herencia en la práctica durante esta actividad. ¿Cómo las resolviste o qué estrategias consideras que podrían ayudarte a superarlas en el futuro?