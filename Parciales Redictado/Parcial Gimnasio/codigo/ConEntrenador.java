package ParcialGimnasio;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class ConEntrenador extends ServicioGym {

    private LocalTime horaInicio;
    private Entrenador entrenador;

    public ConEntrenador (LocalDate fecha, Entrenador entrenador,LocalTime horaInicio){
        super(fecha);
        this.entrenador=entrenador;
        this.horaInicio=horaInicio;
    }

    public double honorarioDeEntrenador(){
        return this.entrenador.honorario(this.horaInicio);
    }

    public double adicionalDomingo(){
        return this.esDomingo() ? this.valorDomingo() : 0 ;
    }

    public double adicionalAntiguedad(){
        return  this.entrenador.calcularDiferenciaEnAnios() * this.valorAnio();
    }

    abstract double valorDomingo();
    abstract double valorAnio();
}
