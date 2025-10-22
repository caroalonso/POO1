package ParcialGimnasio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Entrenador {
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private double honorarioManiana;
    private double honorarioTarde;

    public Entrenador(String nombreCompleto, LocalDate fechaNacimiento, double honorarioManiana, double honorarioTarde) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = LocalDate.now();
        this.honorarioManiana = honorarioManiana;
        this.honorarioTarde = honorarioTarde;
    }

    public Long calcularDiferenciaEnAnios() {
        return ChronoUnit.YEARS.between(this.fechaIngreso, LocalDate.now());
    }

    private boolean iniciaEnManiana(LocalTime hora) {
        LocalTime inicio = LocalTime.of(7, 0);
        LocalTime fin = LocalTime.of(12, 0);
        return !hora.isBefore(inicio) && !hora.isAfter(fin); //"¿La hora no es antes de inicio y no es después de fin?"
    }

    public double honorario(LocalTime hora) {
        return this.iniciaEnManiana(hora) ? this.honorarioManiana : this.honorarioTarde;
    }

}
