# Actividad 10 - Sistema Call Center & Soporte Técnico ISP

Crear un Diagrama de Clases UML y programar la solución completa para el Call Center de una empresa proveedora de servicios de Internet (ISP) en lenguaje Java, asegurando el correcto funcionamiento y la adecuación a los siguientes requisitos.

## Contexto del problema

Un proveedor de servicios de Internet (ISP) necesita un sistema CRM para su Call Center que permita gestionar las **Incidencias Técnicas** reportadas por los clientes. El negocio funciona de la siguiente manera:

1. **Clientes y Registro:** Cada `Cliente` está registrado en el sistema con su nombre, nro de cliente, DNI y domicilio de instalación.

2. **Tipos de Incidencias:** Cuando un cliente llama por un problema técnico, un operador registra una `Incidencia`.
   * **Incidencia Remota:** Muchas situaciones (como cambio de clave WiFi, reinicio de módem o consultas varias) se resuelven telefónicamente en el momento. Estas incidencias quedan cerradas registrando únicamente la descripción de la solución aplicada.
   * **Incidencia Presencial (Orden Técnica):** Si el problema no puede ser resuelto a distancia, la incidencia requiere la visita de un técnico al domicilio del cliente.

3. **Bandas Horarias y Orden Técnica:** Para coordinar la visita presencial, la empresa cuenta con `BandaHoraria` previamente programadas en el sistema (por ejemplo, "Lunes 08:00 a 12:00", "Lunes 12:00 a 16:00") que disponen de un cupo máximo de atenciones simultáneas. 
   * La `OrdenTecnica` debe asociarse a una `BandaHoraria` con cupo disponible para confirmar la cita con el cliente.

4. **Planificación de Recorridos:** El área de logística agrupa las distintas `OrdenTecnica` programadas para un día determinado y las asigna a un `Tecnico` dentro de su `Recorrido` (Hoja de Ruta) diario para organizar las visitas en territorio.


