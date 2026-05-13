# Interfaz en POO

## Introducción  

Una interfaz en Programación Orientada a Objetos (POO) es un tipo de estructura que define un conjunto de métodos, pero no contiene su implementación. Es un contrato que especifica qué acciones pueden realizar las clases que implementen esa interfaz.

* Una interfaz no contiene implementación (solo la firma de los métodos). Esto significa que no describe cómo se hace algo, sino qué se debe hacer.

* Sirve para garantizar que las clases que la implementan sigan un conjunto común de reglas, lo que favorece la consistencia y flexibilidad.

* A diferencia de las clases abstractas, una interfaz no puede contener atributos ni métodos concretos (dependiendo del lenguaje, hay excepciones).

## Ejemplo 1
Supongamos que estamos creando un programa para animales, y queremos asegurarnos que cualquier animal que "pueda volar" implemente un método llamado volar:

```java
// Definición de la interfaz
public interface Volador {
    void volar(); // Método que deben implementar las clases
}

// Clase que implementa la interfaz
public class Pajaro implements Volador {
    @Override
    public void volar() {
        System.out.println("El pájaro está volando.");
    }
}

// Otra clase que también implementa la interfaz
public class Avion implements Volador {
    @Override
    public void volar() {
        System.out.println("El avión está volando.");
    }
}

// Uso de las clases
public class Main {
    public static void main(String[] args) {
        Volador pajaro = new Pajaro();
        Volador avion = new Avion();
        
        pajaro.volar();
        avion.volar();
    }
}
```
En este caso:
La interfaz Volador define el método volar, pero no especifica cómo implementarlo.
Las clases `Pajaro` y `Avion` implementan volar de maneras específicas según sus características.

## Relación con Herencia
No es exactamente lo mismo, pero están relacionadas. Mientras que herencia permite a una clase "heredar" comportamientos y propiedades de una clase base, las interfaces permiten que una clase "prometa" implementar cierto comportamiento sin heredarlo.

Un beneficio de las interfaces es que una clase puede implementar múltiples interfaces (algo que no es posible con la herencia directa, ya que Java, por ejemplo, solo permite herencia simple).

## Ejemplo 2

Por ejemplo, un Hidroavión podría implementar tanto una interfaz Volador como una interfaz Nadador, combinando habilidades sin la necesidad de heredar directamente de dos clases:

```java
public class Hidroavion implements Volador, Nadador {
    @Override
    public void volar() {
        System.out.println("El hidroavión está volando.");
    }

    @Override
    public void nadar() {
        System.out.println("El hidroavión está flotando en el agua.");
    }
}
```

## Ejemplo 3

Imaginemos el diseño de un programa que maneje distintos tipos de vehículos. Una interfaz podría ser:

```java
// Definición de la interfaz
public interface Vehiculo {
    void mover(); // Método que deben implementar las clases
}

// Clase para coche
public class Coche implements Vehiculo {
    @Override
    public void mover() {
        System.out.println("El coche está rodando.");
    }
}

// Clase para avión
public class Avion implements Vehiculo {
    @Override
    public void mover() {
        System.out.println("El avión está volando.");
    }
}
```


# Actividad de Interfaz

1.- Suban los tres ejemplos a la carpeta de su grupo.

2.- Creen en grupo un nuevo ejemplo del uso de interfaz y súbanlo a la carpeta de su grupo nombrándolo Ejemplo 4.

![Ejemplo de organización de la actividad](https://github.com/gerardorosales2222/POO/blob/main/03%20Interfaz/InterfazEjemplos.jpg)

> La imagen muestra una posible organización de la actividad y un ejemplo de un posible uso de la interfaz `Figura` como ejemplo 4.