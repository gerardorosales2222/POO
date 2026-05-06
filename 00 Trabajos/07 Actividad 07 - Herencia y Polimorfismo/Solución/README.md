# Solución Actividad 07

## Clase Persona
```java
public class Persona {
    private String nombre;
    private String dni;
    
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    
    @Override
    public String toString() {
        return nombre + " (DNI: " + dni + ")";
    }
}
```

## Clase Vehículo
```java
public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected double precio;
    
    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    
    // Método abstracto para polimorfismo
    public abstract void mostrarDetalles();//No tiene implementación
    
    // Getters
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }
}
```

## Clase Auto
```java
public class Auto extends Vehiculo {
    private int cantidadPuertas;
    
    public Auto(String marca, String modelo, double precio, int cantidadPuertas) {
        super(marca, modelo, precio);
        this.cantidadPuertas = cantidadPuertas;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Auto: " + marca + " " + modelo + 
                         " | Puertas: " + cantidadPuertas + 
                         " | Precio: $" + precio);
    }
}
```

## Clase Moto
```java
public class Moto extends Vehiculo {
    private int cilindrada;
    
    public Moto(String marca, String modelo, double precio, int cilindrada) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Moto: " + marca + " " + modelo + 
                         " | Cilindrada: " + cilindrada + "cc" +
                         " | Precio: $" + precio);
    }
}
```

## Clase Venta
```java
public class Venta {
    private Persona vendedor;
    private Persona comprador;
    private Vehiculo vehiculo;
    private static int contadorFacturas = 0;
    private int numeroFactura;
    
    public Venta(Persona vendedor, Persona comprador, Vehiculo vehiculo) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.vehiculo = vehiculo;
        this.numeroFactura = ++contadorFacturas;
    }
    
    public void imprimirFactura() {
        System.out.println("FACTURA N°: " + numeroFactura);
        System.out.println("----------------------");
        System.out.println("VENDEDOR: " + vendedor);
        System.out.println("COMPRADOR: " + comprador);
        System.out.println("----------------------");
        System.out.println("VEHÍCULO VENDIDO:");
        vehiculo.mostrarDetalles();  // Polimorfismo en acción
        System.out.println("----------------------");
        System.out.println("TOTAL: $" + vehiculo.getPrecio());
    }
}
```
## Clase Concecionario (main)
```java
public class Concecionaria {
    
    float pi = 3;
    int num = (int)pi;

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