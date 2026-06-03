#  <center> POO <center>
## Solucion del Ejercicio del Estacionamiento

### CLASE MAIN
```java
public class Estacionamiento implements ICobrable{

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
        System.out.println("Isla usada: " + transaccion.getIsla().getNumero());
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
### INTERFAZ ICOBRABLE
```java
public interface ICobrable {
    void cobrar(Alquiler transaccion);
}
```

### CLASE VEHICULO
```java
public class Vehiculo {
    private String tipo; 
    private String color;
    private String marcaModelo;
    private String patente;
    private float tarifa;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    
}
```

### CLASE ISLA
```java
public class Isla {
    private int numero;
    private boolean estado;

    public Isla() {
    }

    public Isla(int numero) {
        this.numero = numero;
        this.estado = estado;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
```

### CLASE ALQUILER
```java
public class Alquiler {
    private LocalTime horaEntrada;
    private LocalTime hotaSalida;
    private boolean pagado;
    private Vehiculo vehiculo;
    private Isla isla;

    public Alquiler() {
    }

    public Alquiler(LocalTime horaEntrada, Vehiculo vehiculo, Isla isla) {
        this.horaEntrada = horaEntrada;
        this.hotaSalida = hotaSalida;
        this.pagado = pagado;
        this.vehiculo = vehiculo;
        this.isla = isla;
    }
    
    public void registrarSalida(LocalTime hotaSalida){
    
    }
    public void registrarPago(){
        this.pagado=true;
    }
    float calcularSaldo(){
        if (horaEntrada == null || hotaSalida == null) {
            return 0.0f;
        }
        long minutosTotales = ChronoUnit.MINUTES.between(horaEntrada, horaEntrada);
        float horasCalculadas = minutosTotales/60.0f;
        return horasCalculadas * vehiculo.getTarifa();
        
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHotaSalida() {
        return hotaSalida;
    }

    public void setHotaSalida(LocalTime hotaSalida) {
        this.hotaSalida = hotaSalida;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Isla getIsla() {
        return isla;
    }

    public void setIsla(Isla isla) {
        this.isla = isla;
    }
}
```
