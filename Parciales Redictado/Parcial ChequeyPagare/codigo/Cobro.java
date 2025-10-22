package ParcialChequeyPagare;

import java.time.LocalDate;

public abstract class Cobro {

    private double monto;
    private String destinatario;
    private String originario;
    private LocalDate fechaEmision;

    public Cobro(double monto, String destinatario, String originario, LocalDate fechaEmicion) {
        this.monto = monto;
        this.destinatario = destinatario;
        this.originario = originario;
        this.fechaEmision = fechaEmicion;
    }

    public double getMonto() {
        return this.monto;
    }

    public LocalDate getFechaEmision() {
        return this.fechaEmision;
    }

    public boolean estaVencido() {
        return ((LocalDate.now().equals(this.getFecha())) || (LocalDate.now().isAfter(this.getFecha())));
    }

  abstract LocalDate getFecha();

   abstract boolean dependeDelVencimiento();
}
