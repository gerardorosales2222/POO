Se creo una aplicación para realizar la reserva de una habiatación del hotel Las Lajitas
--
**Clases y atributos**
- ReservaHabitacion que extiende de AccionHotel:
String nroHabitacion
String nombreCliente

- Pago que extiende de AccionHotel:
String metodoPago
float monto

**Interfaz**
- AccionHotel:
Se realiza la firma del metodo:
void ejecutarAccion()

**main**
- Se realiza una referencia a la inetrfaz Accion hotel con la variable accion:
AccionHotel accion;
Se guarda el objeto ReservaHabitacion en accion y se ejecuta el metodo ejecutarAccion().
Se realiza lo mismo con Pago.



