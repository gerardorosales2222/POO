# Solución Actividad 4

## Clase Maestro

```java
package escuelaprimaria;
/**
 *
 * @author Profe
 */
public class Maestro {
    public String nombre;
    public String grado;

    public Maestro(String nombre, String grado) {
        this.nombre = nombre;
        this.grado = grado;
    }
    
    public void calificar(Alumno evaluado, Nota nota){
        evaluado.agregarNota(nota);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
}
```
## Clase Alumno
```java
package escuelaprimaria;

import java.util.ArrayList;

/**
 *
 * @author Profe
 */
public class Alumno {
    public String nombre;
    public ArrayList<Nota> calificaciones = new ArrayList<>();

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Nota> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Nota> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    public void agregarNota(Nota calificacion){
        calificaciones.add(calificacion);
    }
    
    public void verNotas(){
        System.out.println(this.getNombre() + " ");
        for(Nota calif : calificaciones){
            System.out.println("Materia: " + calif.getMateria() + " Nota: " + calif.getNota());
        }
    }
    
}
```

## Clase Nota
```java
package escuelaprimaria;
/**
 *
 * @author Profe
 */
public class Nota {
    public float nota;
    public String materia;

    public Nota(float nota, String materia) {
        this.nota = nota;
        this.materia = materia;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    } 
}
```