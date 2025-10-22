package CalculoDeImpuestosA;

import java.time.LocalDate;

public abstract class Bien {
    private double valor;
    private LocalDate fechaAdquisicion;
    private final static double CERO = 0;

    public Bien(double valor) {
        this.valor = valor;
        this.fechaAdquisicion = LocalDate.now();
    }

    public double calcularImpuesto() {
        return this.impuesto() * (1 - this.descuento());
    }

    public double getValor() {
        return this.valor;
    }

    public double getCero() {
        return CERO;
    }

    abstract double impuesto();

    abstract double descuento();
}
