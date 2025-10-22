package ParcialGimnasio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Grupal extends ConEntrenador {
    private List<Socio> socios;
    private static final double DOMINGO = 800;
    private static final double ANIO = 250;

    public Grupal(LocalDate fecha, Entrenador entrenador, LocalTime horaInicio, List<Socio> socios) {
        super(fecha, entrenador, horaInicio);
        this.socios = socios;
    }

    public void agregarSocio(Socio socio){
        this.socios.add(socio);
    }

    private double honorarioDivididoPorSocios(){
        return this.honorarioDeEntrenador()/this.socios.size();
    }

    private double antiguedad(){
        return this.adicionalAntiguedad()/this.socios.size();
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
        return this.honorarioDivididoPorSocios() + this.antiguedad() + this.adicionalDomingo();
    }
}
