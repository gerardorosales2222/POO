# Actividad 05 – Sistemas de Gestión de Colecciones

> [!TIP]
>En programación, una colección es una estructura de datos que nos permite agrupar múltiples objetos en una sola unidad.
>Si una variable es como una caja donde solo cabe un objeto por ejempo una sola nota:
>```java
>public class Alumno {
>    private String nombre;
>    private float nota_parcial1;
>    private float nota_parcial2;
>    private float nota_final;
>}
>```
Una colección es como un estante diseñado específicamente para guardar y organizar muchas de esas cajas:
>```java
>public class Alumno {
>    private String nombre;
>    private ArrayList<Nota> calificaciones = new ArrayList<>();
>}
>```

## Modelado de Relaciones de Composición.

A continuación se presentan ejercicios para desarrollar la capacidad de gestionar colecciones de objetos mediante el uso de ArrayList. Se deberá implementar clases contenedoras que "posean" una lista de elementos y métodos que permitan recorrer y procesar dicha información.

**Requerimientos Técnicos Generales:**
+ Encapsulamiento: Todos los atributos deben ser privados.

+ Composición: La clase principal de cada ejercicio debe instanciar y gestionar su propia lista.

+ Recorrido: Utilizar ciclos (for o for-each) para mostrar la información.

## Consignas
### 1. PlayList de Música

Clase **Cancion**: Debe tener titulo y artista.

Clase **Playlist**: Debe tener un nombre y un ArrayList<Cancion>.

Método Clave: **public void mostrarPlaylist( )** que recorra la lista y muestre: _"Reproduciendo: **[titulo]** de **[artista]**"_.

```java
public class Musica {
    public static void main(String[] args) {
        Playlist misFavoritos = new Playlist("Clásicos del Pop");
        
        misFavoritos.agregar(new Cancion("La Flaca", "Jarabe de Palo"));
        misFavoritos.agregar(new Cancion("Color Esperanza", "Diego Torres"));
        misFavoritos.agregar(new Cancion("Ciega, Sordomuda", "Shakira"));
        misFavoritos.agregar(new Cancion("Persiana Americana", "Soda Stereo"));

        System.out.println("--- Mi Playlist de los 90/2000 ---");
        misFavoritos.mostrarPlaylist();
    }
}
```


### 2. Álbum de Fotos

Clase **Foto**: Debe tener archivo (nombre del archivo) y espacioMB.

Clase **Album**: Debe tener un titulo y un ArrayList<Foto>.

Método Clave: **public void verGaleria( )** que imprima el nombre de cada archivo guardado en el álbum.
```java
public class Fotografia {
    public static void main(String[] args) {
        Album verano = new Album("Viaje 2026");
        
        verano.añadirFoto(new Foto("playa.jpg", 4.5));
        verano.añadirFoto(new Foto("familia.png", 3.2));
        verano.añadirFoto(new Foto("atardecer.jpg", 5.1));

        System.out.println("--- Galería del Álbum ---");
        verano.verGaleria();
    }
}
```