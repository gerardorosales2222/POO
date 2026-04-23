# Actividad 06 – Ferretería Herencia

**Objetivo:** Implementar un sistema de gestión de stock utilizando el concepto de Herencia. El propósito es modelar una jerarquía de clases donde una superclase genérica (Producto) provea los atributos comunes, mientras que las subclases especialicen el comportamiento y las características según el rubro.

### Requerimientos Técnicos:
+ Superclase Producto:
Debe contener los datos básicos que todo artículo de la ferretería posee: código, nombre y precio. Los atributos deben ser accesibles para sus hijos (protected).

+ Subclase Herramienta:
Representa artículos manuales o eléctricos. Debe añadir los atributos marca y tamanio.

+ Subclase InsumoElectrico:
Representa componentes que manejan corriente. Debe añadir voltaje y un indicador booleano esCertificado (para normas de seguridad).

+ Subclase Herraje:
Representa elementos de fijación o terminación (manijas, bisagras, etc.). Debe añadir material (ej: bronce, acero) y dimensiones.

## Desafío de Implementación:
Cada subclase debe implementar su propio constructor que reciba tanto los parámetros propios como los de la **superclase**, utilizando la instrucción **super()** para inicializar correctamente el objeto. No olvidar generar los métodos Getter y Setter para mantener el encapsulamiento.

## Escenario de Prueba (main):
Para verificar el correcto funcionamiento, utilizaremos la clase Ferreteria para instanciar diferentes productos y cargarlos en el sistema:
```java
public class Ferreteria {
    public static void main(String[] args) {
        Herramienta h1 = new Herramienta("Stanley", "Grande", 101, "Martillo de Galpón", 1500.50);

        InsumoElectrico i1 = new InsumoElectrico(220.0, true, 202, "Lámpara LED 10W", 450.0);

        Herraje her1 = new Herraje("Acero Inoxidable", "50mm x 50mm", 303, "Bisagra Reforzada", 890.0);

        System.out.println("--- Inventario de Ferretería Cargado ---");
        System.out.println("Producto: " + h1.getNombre() + " | Marca: " + h1.getMarca());
        System.out.println("Producto: " + i1.getNombre() + " | Voltaje: " + i1.getVoltaje() + "v");
        System.out.println("Producto: " + her1.getNombre() + " | Material: " + her1.getMaterial());
    }
}
```

> Ayuda: Para crear el constructor con parámetros de las clases hijas (subclases) en la linea super se debe respetar el orden en el que están escritos los atributos de la clase padre (superclase). Ej:
La superclase Producto primero tiene el atributo _codigo_, segundo _nombre_ y por último _precio_.
```java
public class Producto {
    protected int codigo;
    protected String nombre;
    protected double precio;
```
entonces dentro del constructor de la subclase Herramienta para hacer referencia a ellos se debe escribir en el mismo orden dentro de las paréntesis de super()

```java
// El orden en el paréntesis lo elige el programador
public Herramienta(String marca, int codigo, String tamanio, String nombre, double precio) {
    
    // Pero aquí adentro, se debe respetar el orden que Producto definió:
    super(codigo, nombre, precio);
    
    // Luego se guarda lo que es propio de la herramienta
    this.Marca = marca;
    this.tamanio = tamanio;
}
```
**Regla de Oro:** super() siempre va primero
En programación orientada a objetos, existe una jerarquía lógica. No puedes decorar una habitación si la casa aún no ha sido construida.
La superclase (Producto) es la base o los cimientos.
La subclase (Herramienta) es la ampliación o los detalles.
Java obliga a llamar a super() antes que cualquier otra cosa porque primero debe nacer el "Producto" para que luego los atributos específicos de la "Herramienta" tengan un lugar donde apoyarse.
```java
public Herramienta(String marca, int codigo, String nombre, double precio) {
    this.marca = marca;   // ❌ ERROR de compilación
    super(codigo, nombre, precio); 
}
```
Si hacemos con el ejemplo anterior el compilador dirá algo como: "Constructor call must be the first statement in a constructor" (La llamada al constructor debe ser la primera sentencia).