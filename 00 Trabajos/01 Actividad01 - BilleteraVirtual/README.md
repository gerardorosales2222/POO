# Actividad 01 - Gestión Billetera Virtual

El objetivo de este desafío es aplicar la abstracción para completar un sistema de gestión de cuentas. A partir de dos piezas de software ya funcionales: la clase __Menu__, que gestiona la interacción con el usuario, y la clase __Banco__, que contiene la lógica principal y el flujo del programa. Al intentar ejecutar el proyecto, notarán que el sistema no compila porque falta el componente central: la clase __Cuenta__.

Tu tarea es diseñar e implementar la clase __Cuenta__ de forma tal que el sistema pueda realizar _depósitos_, _extracciones_ y _transferencias_ de dinero entre diferentes usuarios. Deberás analizar el código de la clase **Banco** para identificar qué métodos necesita tener la clase **Cuenta**, qué parámetros deben recibir y qué tipo de datos deben retornar. El sistema debe ser capaz de validar que las operaciones sean posibles (por ejemplo, no transferir dinero que no existe) y, además, la cuenta debe mantener de forma interna un registro histórico para que el usuario pueda _consultar_ sus últimos movimientos de saldo. Todo el desarrollo debe respetar el encapsulamiento y estar organizado dentro del mismo paquete que las clases entregadas.

```java
package banco;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Cuenta miCuenta = new Cuenta();
        Cuenta cuentaAmigo = new Cuenta();
        Menu opciones = new Menu();
        int opcion;
        Scanner entrada = new Scanner(System.in);
  
        do{
            opcion = opciones.mostrar();
            switch(opcion){    
            case 1:
                System.out.println("Ingrese monto a depositar: ");
                float cantidadDepositada = entrada.nextFloat();
                miCuenta.depositar(cantidadDepositada);
            break;
            case 2:
                System.out.println("Ingrese monto a extraer: ");
                float cantidadExtraida = entrada.nextFloat();
                miCuenta.extraer(cantidadExtraida);
            break;
            case 3:
                miCuenta.transferir(500, cuentaAmigo);
                System.out.println("Saldo Cuenta Amigo: $" + cuentaAmigo.getSaldo());
            break;
            case 4:
                System.out.println("Resumen de cuenta:");
                miCuenta.consultar();
            break;
            }
        }while(opcion != 0);
        
    }
    
}
```

```java
package banco;

import java.util.Scanner;

public class Menu {
    
    Scanner entrada = new Scanner(System.in);
    
    public int mostrar(){
        int opcion;
        
        System.out.println("1.- Depositar");
        System.out.println("2.- Extracción");
        System.out.println("3.- Transferir $500 a Cuenta Amigo");
        System.out.println("4.- Consulta");
        System.out.println("Ingrese una opción: ");
        opcion = entrada.nextInt();
        return opcion;
    }
}
```

>**Solución:**
>Están en esta carpeta las clases **Banco** y **Menu** (que son las que fueron proporcionadas como código base) y la clase **Cuenta** (que es la que soluciona el problema).