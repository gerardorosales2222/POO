# Actividad 04 – Escuela Primaria

Simulación de Evaluación de Alumnos.

**Objetivo:** Desarrollar un sistema donde un objeto de tipo Maestro pueda evaluar a objetos de tipo Alumno, asignándoles una calificación. El foco está en que el maestro sea capaz de "asignar" una nota a un alumno mediante un método.

### Requerimientos Técnicos:
+ Clase Alumno:  
Cada alumno tiene un nombre y una lista de calificaciones (notas).

+ Clase Maestro:  
Tiene un nombre y un grado asociado.

+ Clase Nota:
Tiene un valor y una materia asociada.

### Método Clave:  
La clase Profesor debe tener un método:
```java
public void calificar(Alumno evaluado, Nota nota)
```



```java
public class EscuelaPrimaria {
    public static void main(String[] args) {
        Alumno ana = new Alumno("Ana");
        Alumno beto = new Alumno("Beto");
        Alumno carla = new Alumno("Carla");

        Maestro juan = new Maestro("Juan", "4to Grado");

        System.out.println("--- Iniciando Simulación de Evaluación ---");

        juan.calificar(ana, new Nota(9, "Matemática"));
        juan.calificar(beto, new Nota(8, "Lengua"));
        juan.calificar(carla, new Nota(7, "Matemática"));

        System.out.println("\n--- Resultados Finales ---");
        ana.verNotas();
        beto.verNotas();
        carla.verNotas();
    }
}
```