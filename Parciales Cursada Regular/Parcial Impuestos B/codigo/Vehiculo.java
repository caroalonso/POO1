package ParcialImpuestosBcorregir;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Vehiculo implements Bien {
    private String patente;
    private LocalDate fechaFabricacion;
    private double valor;
    private final static int DIEZ = 10;
    private final static double CERO = 0.0;
    private final static double MILLON = 1000000;

    public Vehiculo(String patente, LocalDate fechaFabricacion, double valor) {
        this.patente = patente;
        this.fechaFabricacion = fechaFabricacion;
        this.valor = valor;
    }

    private Long cantidadAnios() {
        return ChronoUnit.YEARS.between(this.fechaFabricacion, LocalDate.now());
    }

    @Override
    public double calcularImpuesto() {
        if (this.cantidadAnios() > DIEZ)
            return CERO;
        return this.valor * this.porcentaje();
    }

    public boolean menorAn() {
        return this.valor >= MILLON;
    }

    abstract double porcentaje();
}
