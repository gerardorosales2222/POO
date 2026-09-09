# Actividad 13 - Servicio de Streaming
Crear una solución completa en lenguaje Java para una plataforma de contenidos bajo demanda, asegurando el correcto funcionamiento y la adecuación a los siguientes requisitos.

## Contexto del problema
Una empresa proveedora de entretenimiento digital requiere una plataforma para gestionar las reproducciones y los cobros de sus cuentas. El funcionamiento del negocio se establece de la siguiente manera:

La plataforma cuenta con usuarios registrados que eligen contratar distintas modalidades de acceso al catálogo. Cada modalidad establece sus propias condiciones de uso, tales como la cantidad permitida de pantallas en simultáneo, la calidad máxima de video autorizada y el costo final de la suscripción mensual.

El catálogo del servicio está compuesto por distintos tipos de producciones audiovisuales. Algunas producciones corresponden a obras autocontenidas de una sola entrega, mientras que otras se estructuran en entregas seriadas organizadas por partes y capítulos.

Al momento de reproducir un contenido, el sistema debe verificar que el perfil activo no supere el límite de pantallas autorizadas por su modalidad de acceso. Si el intento de reproducción ocurre dentro del límite permitido, la transmisión inicia adaptando la tasa de transferencia a la calidad máxima soportada por la modalidad contratada. En caso contrario, el acceso debe ser bloqueado emitiendo un aviso de capacidad agotada.

El cobro del servicio se procesa mensualmente. Algunas modalidades aplican una tarifa plana sin importar el volumen consumido, mientras que otras modalidades económicas o promocionales aplican un costo base reducido más un cargo adicional por cada hora de transmisión consumida fuera del horario habitual de menor tráfico.

## Código de prueba (Main)
A continuación se proporciona la clase PlataformaStreaming con el método main que servirá como punto de partida y verificación de la solución:

```Java
package streaming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Profe
 */
public class PlataformaStreaming implements IProcesadorServicio {

    @Override
    public void procesarReproduccion(Usuario u, Produccion p) {
        System.out.println("Intentando reproducir: " + p.getTitulo() + " en la cuenta de " + u.getNombre());
        boolean reproducido = u.iniciarReproduccion(p);
        
        if (reproducido) {
            System.out.println("Transmisión iniciada exitosamente.");
            System.out.println("Calidad de emisión: " + u.getModalidad().getCalidadMaxima());
            System.out.println("Pantallas activas: " + u.getPantallasEnUso() + "/" + u.getModalidad().getLimitePantallas());
        } else {
            System.out.println("No se pudo iniciar la transmisión: Límite de pantallas alcanzado.");
        }
        System.out.println("==========================================\n");
    }

    @Override
    public void cobrarSuscripcion(Usuario u) {
        double total = u.getModalidad().calcularMontoMensual(u.getHorasConsumidasFueraDePico());
        System.out.println("====== RESUMEN DE FACTURACION ======");
        System.out.println("Usuario: " + u.getNombre());
        System.out.println("Suscripción: " + u.getModalidad().getNombreModalidad());
        System.out.println("Monto liquidado: $" + String.format("%.2f", total));
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        PlataformaStreaming plataforma = new PlataformaStreaming();

        Modalidad basicaConAnuncios = new ModalidadPromocional(2500.0, 1, "720p", 150.0);
        Modalidad premiumFamilia = new ModalidadPlana(8500.0, 4, "4K UHD");

        Usuario usuario1 = new Usuario("Laura R.", basicaConAnuncios, 10);
        Usuario usuario2 = new Usuario("Marcos S.", premiumFamilia, 0);

        Produccion pelicula = new Pelicula("Inception", 148, "Sci-Fi");
        Produccion episodio = new EpisodioSerie("Breaking Bad", "S01E01 - Pilot", 58);

        // Intento de reproducción dentro del límite
        plataforma.procesarReproduccion(usuario1, pelicula);

        // Simulación de saturación de pantallas en usuario1
        plataforma.procesarReproduccion(usuario1, episodio);

        // Cobro de servicios
        plataforma.cobrarSuscripcion(usuario1);
        plataforma.cobrarSuscripcion(usuario2);
    }
}
```