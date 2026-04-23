# Solución Actividad 6

## Clase Producto (Superclase)

```java
package ferreteria;
/**
 * @author Profe
 */
public class Producto {
    protected int codigo;
    protected String nombre;
    protected double precio;
    
    public Producto(){}

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
```
## Clase Herramienta (Subclase)
```java
package ferreteria;
/**
 * @author Profe
 */
public class Herramienta extends Producto{
    private String Marca;
    private String tamanio;

    public Herramienta(String Marca, String tamanio, int codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.Marca = Marca;
        this.tamanio = tamanio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }   
}
```

## Clase InsumoElectrico (Subclase)
```java
package ferreteria;
/**
 * @author Profe
 */
public class InsumoElectrico extends Producto{
    private double voltaje;
    private boolean esCertificado;

    public InsumoElectrico(double voltaje, boolean esCertificado, int codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.voltaje = voltaje;
        this.esCertificado = esCertificado;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public boolean isEsCertificado() {
        return esCertificado;
    }

    public void setEsCertificado(boolean esCertificado) {
        this.esCertificado = esCertificado;
    }   
}
```

## Clase Herraje (Subclase)
```java
package ferreteria;
/**
 * @author Profe
 */
public class Herraje extends Producto{
   private String material;//bronce, hierro, acero inoxidable
   private String dimensiones;

    public Herraje(String material, String dimensiones, int codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.material = material;
        this.dimensiones = dimensiones;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }  
}
```

## Clase Ferreteria (main)
```java
package ferreteria;
/**
 * @author Profe
 */
public class Ferreteria {

    public static void main(String[] args) {
        
    }   
}
```