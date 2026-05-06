# Polimorfismo

## Introducción  

El polimorfismo es un concepto fundamental en la programación orientada a objetos (POO) que permite que un mismo método pueda tener diferentes comportamientos dependiendo del tipo de objeto con el que se trabaja. Esta característica aporta flexibilidad y escalabilidad al desarrollo de software.

Existen distintos tipos de polimorfismo, que se clasifican en polimorfismo estático (en tiempo de compilación) y polimorfismo dinámico (en tiempo de ejecución). A continuación, se presentan tres tipos de polimorfismo y su correcta clasificación, acompañados de ejemplos en Java.

## Tipos de polimorfismo
Al momento de definir los tipos de polimorfísmos, más allá de como se logra el polimorfismo, haremos siempre la aclaración sobre si se ejecutan de manera dinámica (en tiempo de ejecución) o estática (en tiempo de compilación).

### Polimorfismo de Subtipos (Polimorfismo de Inclusión) - Dinámico

El polimorfismo de subtipos ocurre cuando una clase hija hereda de una clase base y es tratada como si fuera una instancia de dicha clase base. La ejecución de métodos se determina en tiempo de ejecución, permitiendo la sustitución de una instancia por otra sin modificar el código que la usa.
```java
// Clase abstracta que define el método dibujar
abstract class Figura {
    abstract void dibujar(); // Método abstracto sin implementación
}

// Subclases que sobrescriben el método
class Circulo extends Figura {
    @Override
    void dibujar() {
        System.out.println("Dibujando un círculo.");
    }
}

class Cuadrado extends Figura {
    @Override
    void dibujar() {
        System.out.println("Dibujando un cuadrado.");
    }
}

public class Main {
    public static void main(String[] args) {
        Figura miFigura; // No se puede instanciar directamente, pero sí referenciar

        miFigura = new Circulo();
        miFigura.dibujar(); // Ejecuta la versión de Circulo

        miFigura = new Cuadrado();
        miFigura.dibujar(); // Ejecuta la versión de Cuadrado
    }
}
```
>Explicación: Aquí, `Figura` es la clase base, y `Circulo` y `Cuadrado` son sus subclases. Cada subclase sobrescribe el método `dibujar()`, y lo hace en tiempo de ejecución. Se usa una referencia de tipo `Figura`, pero el objeto real que se crea es de tipo `Circulo` o `Cuadrado` aunque el objeto es referenciado como `Figura`, ejecuta el método propio de la subclase instanciada.

### Polimorfismo Paramétrico - Estático
El polimorfismo paramétrico, también conocido como polimorfismo genérico, permite que una clase o método trabaje con diferentes tipos de datos sin modificar su implementación. En Java, se logra mediante el uso de Generics, y su determinación ocurre en tiempo de compilación.
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

public class Main {
    public static void main(String[] args) {
        Caja<String> cajaString = new Caja<>();
        cajaString.agregar("Texto en caja");
        System.out.println(cajaString.obtener());

        Caja<Integer> cajaEntero = new Caja<>();
        cajaEntero.agregar(42);
        System.out.println(cajaEntero.obtener());
    }
}
```
>Explicación: La clase `Caja<T>` utiliza un tipo de dato genérico `T`, lo que permite que su funcionalidad se aplique a diferentes tipos de datos sin necesidad de modificar la implementación del código. La decisión sobre qué tipo utilizar se toma en tiempo de compilación, lo que lo clasifica como polimorfismo estático

### Polimorfismo por Sobrecarga de Métodos - Estático
El polimorfismo por sobrecarga de métodos ocurre cuando una clase define múltiples versiones de un mismo método, diferenciadas por el número o tipo de parámetros. La decisión sobre qué método ejecutar se toma en tiempo de compilación, por lo que este tipo de polimorfismo es estático.

```java
class Operaciones {
    // Método que suma dos números
    int sumar(int a, int b) {
        return a + b;
    }

    // Método sobrecargado que suma tres números
    int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Método sobrecargado que suma números decimales
    double sumar(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        System.out.println(op.sumar(5, 3));    // Llama al método con dos parámetros enteros
        System.out.println(op.sumar(5, 3, 2)); // Llama al método con tres parámetros enteros
        System.out.println(op.sumar(5.5, 3.2)); // Llama al método con dos parámetros decimales
    }
}
```
>Explicación: Aquí, el método `sumar()` está sobrecargado con diferentes versiones que reciben distintos tipos o cantidades de parámetros. La elección de qué versión ejecutar se toma durante la compilación, por lo que este tipo de polimorfismo se clasifica como estático.

## Actividad del tema Polimorfismo

1.- Crear una clase base que represente una acción general en el hotel.

2.- Crear subclases que representen acciones específicas como reservar una habitación y procesar un pago.

3.- Implementar polimorfismo de subtipos para que una referencia de la clase base pueda ejecutar distintos comportamientos en tiempo de ejecución.

4.- Completar el código faltante en la siguiente clase Main, donde ya se establecen las referencias pero faltan las clases asociadas.

### Código del main.java:
```java
public class Main {
    public static void main(String[] args) {
        // Declaramos una referencia a una acción del hotel
        AccionHotel accion;

        // Tomar una reserva
        accion = new ReservaHabitacion("Habitación 101", "Juan Pérez");
        accion.ejecutarAccion();

        // Procesar un pago
        accion = new Pago("Tarjeta de crédito", 5000);
        accion.ejecutarAccion();
    }
}
```

#### Tareas:

Crear la clase superclase `AccionHotel`, que debe tener el método `ejecutarAccion()`.

Crear las clases `ReservaHabitacion` y `Pago`, que deben sobrescribir `ejecutarAccion()`.

Probar el código completando la lógica de cada clase.

📌 Tip: Usar el polimorfismo de subtipos para que `AccionHotel` pueda referenciar objetos de `ReservaHabitacion` y `Pago`.

-----
## Polimorfismo y declaración de variables
Retomemos el ejemplo del concecionario de la Actividad 7.
### ¿Por qué declaramos `Vehiculo auto1 = new Auto(...)` en lugar de `Auto auto1 = new Auto(...)`?

Esta es una de las preguntas más frecuentes al trabajar con herencia y polimorfismo. Vamos a entenderla con un ejemplo práctico.

### Ambas formas son válidas, pero tienen diferentes propósitos

```java
// Opción 1: Declaración específica
Auto auto1 = new Auto("Toyota", "Corolla", 25000000.00, 4);

// Opción 2: Declaración polimórfica (la que usamos en esta actividad)
Vehiculo auto1 = new Auto("Toyota", "Corolla", 25000000.00, 4);
```

### ¿Cuál es la diferencia?

| Declaración | Tipo declarado | Tipo real | ¿Qué permite? |
|-------------|----------------|-----------|----------------|
| `Auto auto1 = new Auto(...)` | `Auto` | `Auto` | Acceder a métodos específicos de `Auto` |
| `Vehiculo auto1 = new Auto(...)` | `Vehiculo` | `Auto` | Tratar al objeto como `Vehiculo` (polimorfismo) |

### La analogía del concesionario

> Imagina que entras a un concesionario y dices: *"Necesito un **vehículo**"*.
> 
> El vendedor puede traerte un **Auto** o una **Moto**, porque ambos **son** vehículos. 
> 
> En cambio, si dices: *"Necesito un **Auto**"*, solo podrás obtener autos, nunca motos.

**En programación es igual:**
- Declarar como `Vehiculo` te permite **cambiar el tipo específico** sin modificar el resto del código
- Declarar como `Auto` te **limita** a trabajar solo con autos

### ¿Por qué usamos `Vehiculo` en esta actividad?

**Objetivo didáctico:** Aprender **Polimorfismo**

El polimorfismo permite que una variable de tipo padre (`Vehiculo`) pueda hacer referencia a objetos de cualquier clase hija (`Auto` o `Moto`).

```java
// Esto ES polimorfismo
Vehiculo miVehiculo;

miVehiculo = new Auto("Toyota", "Corolla", 25000000.00, 4);
miVehiculo.mostrarDetalles(); // Muestra detalles de Auto

miVehiculo = new Moto("Honda", "CB500F", 12000000.00, 500);
miVehiculo.mostrarDetalles(); // Muestra detalles de Moto
```

### La ventaja clave: Flexibilidad

Gracias a declarar como `Vehiculo`, podemos crear métodos que trabajen con **cualquier** tipo de vehículo:

```java
// Este método puede recibir TANTO un Auto como una Moto
public void procesarVenta(Vehiculo vehiculo) {
    vehiculo.mostrarDetalles();  // Se comporta diferente según el tipo REAL
}

// Podemos llamarlo con distintos tipos
procesarVenta(new Auto("Toyota", "Corolla", 25000000.00, 4));
procesarVenta(new Moto("Honda", "CB500F", 12000000.00, 500));
```

### ⚠️ ¿Hay algo que NO pueda hacer con la declaración polimórfica?

Sí. Al declarar como `Vehiculo`, **no puedes acceder directamente** a los métodos específicos de `Auto` o `Moto`:

```java
Vehiculo auto1 = new Auto("Toyota", "Corolla", 25000000.00, 4);

// Esto NO compila:
// auto1.getCantidadPuertas();  

// Para acceder a métodos específicos, necesitas hacer "casting":
if (auto1 instanceof Auto) {
    Auto autoReal = (Auto) auto1;
    int puertas = autoReal.getCantidadPuertas(); // ✅ Ahora sí funciona
}
```

### 📝 Resumen para recordar

| Si necesitas... | Declara como... |
|----------------|-----------------|
| Usar métodos específicos de `Auto` (ej: `getCantidadPuertas()`) | `Auto` |
| Tratar a todos los vehículos de forma genérica y aprovechar el polimorfismo | `Vehiculo` |

### 🎓 Conclusión para esta actividad

En **Gestión de Concesionaria** usamos `Vehiculo auto1 = new Auto(...)` porque:

1. ✅ Queremos **demostrar el polimorfismo** (el objetivo de la actividad)
2. ✅ El método `imprimirFactura()` solo necesita los métodos de `Vehiculo`
3. ✅ La clase `Venta` tiene un atributo de tipo `Vehiculo`, no `Auto` ni `Moto`
4. ✅ Preparamos el código para ser **extensible** (si agregamos `Camion`, el código sigue funcionando)

---

> "Programar pensando en el polimorfismo es programar pensando en el futuro."
```