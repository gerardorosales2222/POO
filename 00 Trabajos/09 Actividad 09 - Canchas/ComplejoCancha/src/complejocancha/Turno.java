/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complejocancha;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author marquitos
 */
public class Turno {
     private LocalTime HoraEntrada ;
     private LocalTime HoraSalida;
     private String reponsable;
     private int dni;
     private Cancha LaCacnha;
     

    public Turno(LocalTime HoraEntrada, LocalTime HoraSalida, String reponsable,int dni, Cancha LaCacnha) {
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
        this.reponsable = reponsable;
        this.dni = dni;
        this.LaCacnha = LaCacnha;
       
    }

    public LocalTime getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(LocalTime HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public LocalTime getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(LocalTime HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getReponsable() {
        return reponsable;
    }

    public void setReponsable(String reponsable) {
        this.reponsable = reponsable;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    

    public Cancha getLaCacnha() {
        return LaCacnha;
    }

    public void setLaCacnha(Cancha LaCacnha) {
        this.LaCacnha = LaCacnha;
    }
     
     public float calcularTotal(){
         if (HoraEntrada == null || HoraSalida == null) {
          return 0.0f ;
      }
      long minutosTotales = ChronoUnit.MINUTES.between(HoraEntrada, HoraSalida);
      float horasCalculadas = minutosTotales/60.0f;
      return horasCalculadas * LaCacnha.getTarifa();
     }
}
