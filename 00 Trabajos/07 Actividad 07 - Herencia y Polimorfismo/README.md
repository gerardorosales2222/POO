# Actividad 06 – Herencia, Composición y Polimorfismo

> [!TIP]
> En este ejercicio, la clase **Venta** tendrá un atributo de tipo `Vehiculo`. Gracias al polimorfismo, en ese mismo lugar podremos asignar tanto una `Moto` como un `Auto`, ya que ambos **son** un `Vehiculo`.
> NO se deberías crear clases Vendedor y Comprador. La herencia aquí es para los vehículos (Auto y Moto heredan de Vehiculo), no para las personas.
> La distinción entre "vendedor" y "comprador" es un rol que juega la persona en la venta, no un tipo diferente de persona.

## Modelado de Relaciones Complejas: Concesionaria

Crear un diagrama de clases para una concesionaria dedicada a la venta de motos y automóviles. Utilizar herencia para los distintos tipos de vehículos y una relación de composición en caso de ser necesario. Los requisitos son:
que el sistema pueda registrar una **venta** de un vehículo especificando su **vendedor**, **comprador** y el **vehículo** vendido.

---

## Consignas

### 1. Sistema de Ventas de Vehículos

**Clase Vehiculo (Superclase):** Debe contener atributos comunes como `marca`, `modelo` y `precio`.

**Clases Moto y Auto (Subclases):** Heredan de Vehiculo. Pueden incluir atributos específicos (por ejemplo: `cilindrada` para Moto, `cantidadPuertas` para Auto).

**Clase Persona:** Debe tener `nombre` y `dni`. Se utilizará para identificar tanto al **Vendedor** como al **Comprador**.

**Clase Venta:** Debe tener un `Vendedor` (Persona), un `Comprador` (Persona) y un `Vehiculo`. 

---

### Código Base para el Main

A continuación, el código en el que nos vamos a basar para probar el sistema:
```java
public class Concecionaria {

    public static void main(String[] args) {
        // Creamos los participantes
        Persona vendedor = new Persona("Juan Pérez", "33444555");
        Persona comprador = new Persona("Ana García", "40111222");

        // Creamos los vehículos (Aplicando Polimorfismo)
        Vehiculo auto1 = new Auto("Toyota", "Corolla", 33000000, 4);
        Vehiculo moto1 = new Moto("Honda", "CB500F", 5400000, 500);

        // Registramos la venta de un Auto
        Venta factura1 = new Venta(vendedor, comprador, auto1);

        System.out.println("--- Procesando Venta de Concesionaria ---");
        factura1.imprimirFactura();        
        System.out.println("\n------------------------------------------");
        
        // Registramos la venta de una Moto usando el mismo proceso
        Venta factura2 = new Venta(vendedor, comprador, moto1);
        factura2.imprimirFactura();
    }
}
```
