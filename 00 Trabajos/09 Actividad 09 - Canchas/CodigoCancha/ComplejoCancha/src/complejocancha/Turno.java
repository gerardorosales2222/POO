/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complejocancha;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author mi pc
 */
public class Turno {
    
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String cli;
    private Cancha lacancha;
    
    
    float calcularTotal(){
     if (horaEntrada == null || horaSalida == null) {
            return 0.0f;
        }
        long minusMinutes = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        float horasCalculadas = minusMinutes /60.0f;
        return  horasCalculadas * lacancha.getTarifa();
    }

    public Turno(LocalTime horaEntrada, LocalTime horaSalida, String cli, Cancha lacancha) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cli = cli;
        this.lacancha = lacancha;
    }
    
    

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public Cancha getLacancha() {
        return lacancha;
    }

    public void setLacancha(Cancha lacancha) {
        this.lacancha = lacancha;
    }
    
    
    
}
