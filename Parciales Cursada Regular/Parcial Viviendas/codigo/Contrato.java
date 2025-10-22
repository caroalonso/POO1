package ParcialViviendas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Contrato {
    private LocalDate fecha;
    private Servicio servicio;

    public Contrato(LocalDate fecha, Servicio servicio) {
        this.fecha = fecha;
        this.servicio = servicio;
    }

    public boolean esFinDeSemana() {
        DayOfWeek dia = DayOfWeek.from(this.fecha);
        return dia.equals(DayOfWeek.SATURDAY) || dia.equals(DayOfWeek.SUNDAY);
    }

    public double getValorServicio() {
        return this.servicio.montoServicio();
    }

    abstract double sumaValorContrato();
}
