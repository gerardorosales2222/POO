# Sistema de Almacenamiento Seguro (Cajas de Custodia)

​Una empresa necesita digitalizar el control de sus Cajas de Custodia. Cada caja está diseñada para guardar y proteger un único objeto a la vez, asegurando que el tipo de elemento guardado no cambie durante el uso de esa caja.

​El sistema debe permitir:
+ ​Guardar un objeto dentro de la caja (solo si está vacía).
+ Consultar/Extraer el objeto guardado en la caja.
+ ​Saber si la caja se encuentra llena o vacía.

​Actualmente, la empresa maneja dos áreas operativas que requieren usar estas cajas:
+ ​Área de Valores: Guarda montos o saldos numéricos.
+ Área de Archivo: Guarda nombres o documentos en texto.

### Requisito:
Diseñe e implemente el concepto de la Caja de Custodia de modo que sea totalmente reutilizable y segura ante tipos de datos (type-safe), evitando la duplicación de código y sin recurrir a conversiones explícitas (casts). Muestre un ejemplo de uso simulando las operaciones de ambas áreas.


---
## Solución

### CajaCustodia.java
´´´java
package genericsbasic;
/**
 * @author Profe
 */
public class CajaCustodia<T> {
    private T contenido;

    public CajaCustodia() {
        this.contenido = null;
    }

    public boolean guardar(T objeto) {
        if (estaLlena()) {
            System.out.println("Error: La caja ya está ocupada. Extraiga el objeto actual antes de guardar uno nuevo.");
            return false;
        }
        if (objeto == null) {
            System.out.println("Error: No se puede guardar un objeto nulo.");
            return false;
        }
        this.contenido = objeto;
        System.out.println("Objeto guardado con éxito: " + objeto);
        return true;
    }

    public T extraer() {
        if (estaVacia()) {
            System.out.println("Error: La caja está vacía, no hay nada que extraer.");
            return null;
        }
        T objetoExtraido = this.contenido;
        this.contenido = null;
        return objetoExtraido;
    }

    public T consultar() {
        return this.contenido;
    }

    public boolean estaLlena() {
        return this.contenido != null;
    }

    public boolean estaVacia() {
        return this.contenido == null;
    }
}
´´´
### main
´´´java
package genericsbasic;

/**
 * @author Profe
 */
public class GenericsBasic {

    public static void main(String[] args) {
        System.out.println("=== AREA DE VALORES ===");
        CajaCustodia<Double> cajaValores = new CajaCustodia<>();

        System.out.println("¿La caja está vacía?: " + cajaValores.estaVacia());

        cajaValores.guardar(150000.50);

        cajaValores.guardar(20000.00); // Falla

        Double monto = cajaValores.extraer();
        System.out.println("Monto extraído: $ " + monto);
        System.out.println("¿La caja está vacía?: " + cajaValores.estaVacia());

        System.out.println("\n=== AREA DE ARCHIVO ===");
        CajaCustodia<String> cajaArchivo = new CajaCustodia<>();

        cajaArchivo.guardar("Contrato_Alquiler_2026.pdf");

        String nombreDoc = cajaArchivo.consultar();
        System.out.println("Documento en la caja: " + nombreDoc);

    }   
}
´´´