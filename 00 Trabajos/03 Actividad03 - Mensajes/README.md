# Actividad 03 - Mensajes

**Consigna:** Simulación de Red de Mensajería.

**Objetivo:** Desarrollar un sistema de comunicación donde los objetos de tipo **Usuario** puedan enviarse mensajes entre sí. El foco está en que un usuario sea capaz de "entregar" un objeto de tipo **Mensaje** a otro usuario a través de un método.

**Requerimientos Técnicos:**

+ Clase Usuario: Se deberá definir esta clase con los atributos que consideres necesarios para que cada usuario tenga un nombre y una forma de almacenar los mensajes que recibe (una lista o historial).

+ Clase Mensaje: Debe representar el contenido de lo enviado y quién lo envía (remitente). 

+ El Método Clave: La clase Usuario debe tener un método para enviar mensajes.

+ Firma sugerida: public void enviarMensaje(String texto, Usuario destinatario). Este método debe crear un mensaje y "depositarlo" en el buzón del destinatario.

+ Sin Menú: No se debe pedir datos por teclado (Scanner). La lógica debe ejecutarse directamente en el main siguiendo un guion fijo.

### El Desafío:
Se deberá programar la interacción de 3 usuarios (Ana, Beto y Carla) para que realicen las acciones que figuran en la clase que contiene el _main( )_, la cuál está dada a continuación.

```java
public static void main(String[] args) {
    Usuario ana = new Usuario("Ana");
    Usuario beto = new Usuario("Beto");
    Usuario carla = new Usuario("Carla");

    System.out.println("--- Iniciando Simulación ---");
    
    ana.enviarMensaje("Hola Beto, ¿tenés el apunte de POO?", beto);
    beto.enviarMensaje("Hola Ana, sí, ahí te lo paso", ana);
    beto.enviarMensaje("Carla, ¿viste que Ana me pidió el apunte?", carla);
    carla.enviarMensaje("Uh, no se lo pases que todavía tiene errores", beto);

    System.out.println("\n--- Buzón de Ana ---");
    ana.verMensajes();

    System.out.println("\n--- Buzón de Beto ---");
    beto.verMensajes();

    System.out.println("\n--- Buzón de Carla ---");
    carla.verMensajes();
}

```

> **Solución:**
> Se subieron las tres clases que resuelven este problema. La clase __Mensajero__ es la que contiene el método _main( )_. 