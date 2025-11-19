package ejercicio29Set;

import java.time.LocalDate;

public abstract class Actividad {
   private LocalDate fechaInicio;
   private String ipUsada;
   private int duracion;

   public Actividad (String ipUsada,int duracion){
       this.fechaInicio=LocalDate.now();
       this.ipUsada=ipUsada;
       this.duracion=duracion;
   }

   public LocalDate getFecha(){
       return this.fechaInicio;
   }

   public String getIpUsada(){
       return this.ipUsada;
   }

   public int getDuracion(){
       return this.duracion;
   }

   abstract double montoPorActividad();
}
