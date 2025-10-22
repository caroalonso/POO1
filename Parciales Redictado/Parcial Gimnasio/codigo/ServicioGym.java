package ParcialGimnasio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class ServicioGym {
    private LocalDate fechaDeLaClase;

public ServicioGym(LocalDate fechaDeLaClase){
    this.fechaDeLaClase=fechaDeLaClase;
}

public boolean esIgual(LocalDate fecha){
    return this.fechaDeLaClase.equals(fecha);
}

public boolean esDomingo(){
    return this.fechaDeLaClase.getDayOfWeek()== DayOfWeek.SATURDAY;
}

abstract double costoDeServicio();
}

