# Actividad 08 – Estacionamiento Orientado a Objetos

A partir del Diagrama de Clases UML provisto por la cátedra, deberán programar la solución completa en lenguaje Java, asegurando el correcto funcionamiento de las relaciones de Composición fuerte, la implementación de la interfaz ICobrable y la lógica del cálculo de saldos.

![Ejemplo de organización de la actividad](https://raw.githubusercontent.com/gerardorosales2222/POO/main/img/DC_Estacionamiento.jpg)

## Pasos Obligatorios para la Entrega (Workflow de Git)

Para que tu entrega sea evaluada, deberás seguir estrictamente el flujo de trabajo profesional basado en Forks y Pull Requests:

**Paso 1:** Crear tu propio entorno de trabajo
Entrar al repositorio de la materia en GitHub.

Hacer clic en el botón Fork (esquina superior derecha) para crear una copia exacta del proyecto en tu cuenta personal.

Cloná tu fork localmente en tu computadora usando la terminal:

```bash
git clone https://github.com/TU_USUARIO/nombre-del-repositorio.git
```

**Paso 2:** Aislar tu espacio de desarrollo (Uso de Ramas)
No trabajes sobre la rama main. Antes de tocar cualquier línea de código, debés crear una rama propia que lleve tu apellido en minúsculas:

```bash
git checkout -b tu-apellido
```

**Paso 3:** Codificación y Resolución. Dirigite a la carpeta asignada para esta actividad dentro del proyecto.

Programá las clases (Estacionamiento, Alquiler, Isla, Vehiculo e ICobrable) respetando los tipos de datos, modificadores de visibilidad (private/public) y relaciones del diagrama UML.

**Paso 4:** Subir los cambios a GitHub
Una vez que el código compile perfectamente y el main corra sin errores, guardá y subí tu rama:

```bash
git add .
git commit -m "Solución del diagrama de estacionamiento"
git push origin tu-apellido
```
**Paso 5:** Enviar la entrega (Pull Request)
Entrá a tu repositorio en GitHub (tu fork).

Vas a ver un cartel amarillo que dice "Compare & pull request". Hacé clic ahí.

Asegurate de que la dirección del PR apunte correctamente:

Base repository: El de la materia (rama: main).

Head repository: Tu fork (rama: tu-apellido).

En el título del Pull Request poné: Entrega Actividad Estacionamiento - [Tu Nombre y Apellido].

Hacé clic en "Create pull request".


## Clase main

A continuación una ayuda. Esta será la clase main con la que trabajaremos. Cuando todo esto funcione quiere decir que hicimos bien el ejercicio. 

```java
package estacionamiento;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @author Profe
 */
public class Estacionamiento implements ICobrable {

    private String nombre;
    private ArrayList<Isla> islas = new ArrayList<>();
    
    public Estacionamiento(){}

    public Estacionamiento(String nombre) {
        this.nombre = nombre;
        
        this.islas.add(new Isla(1));
        this.islas.add(new Isla(2));
        this.islas.add(new Isla(3));
    }

    @Override
    public void cobrar(Alquiler transaccion) {
        float total = transaccion.calcularSaldo();
        System.out.println("\n--- TICKET DE COBRO ---");
        System.out.println("Vehículo Patente: " + transaccion.getVehiculo().getPatente());
        System.out.println("Isla usada: " + transaccion.getIsla().getNro());
        System.out.println("Total a pagar: $" + total);
        transaccion.registrarPago(); 
        System.out.println("Estado del alquiler: ¡PAGADO!");
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Estacionamiento predioCentro = new Estacionamiento("Estacionamiento Central");

        Vehiculo auto = new Vehiculo();
        auto.setPatente("AF123JK");
        auto.setTarifa(1200.0f);

        Isla islaAsignada = predioCentro.islas.get(0);
        islaAsignada.setEstado(true);
        
        LocalTime entrada = LocalTime.of(8, 0); 
        Alquiler alquilerAuto = new Alquiler(entrada, auto, islaAsignada);

        //El vehículo se retira a las 10:30 hs (Se queda 2 horas y media)
        LocalTime salida = LocalTime.of(10, 30);
        alquilerAuto.registrarSalida(salida);
        islaAsignada.setEstado(false);

        predioCentro.cobrar(alquilerAuto);
    }
}
```