package ParcialGimnasio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Personalizada extends ConEntrenador{
    private Socio socio;
    private static final double DOMINGO=500;
    private static final double ANIO=400;

    public Personalizada(LocalDate fecha, Entrenador entrenador, LocalTime horaInicio,Socio socio){
        super(fecha,entrenador,horaInicio);
        this.socio=socio;
    }

    @Override
    public double valorDomingo() {
        return DOMINGO;
    }

    @Override
    public double valorAnio() {
        return ANIO;
    }

    @Override
    public double costoDeServicio() {
        return this.honorarioDeEntrenador() + this.adicionalDomingo() + this.adicionalAntiguedad();
    }
}
