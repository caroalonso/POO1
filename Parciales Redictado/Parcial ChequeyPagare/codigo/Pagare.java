package ParcialChequeyPagare;

import java.time.LocalDate;

public class Pagare extends Cobro {

    private LocalDate fechaVencimiento;

    public Pagare(double monto, String destinatario, String originario, LocalDate fechaEmision, LocalDate fechaVencimiento) {
        super(monto, destinatario, originario, fechaEmision);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public LocalDate getFecha() {
        return this.fechaVencimiento;
    }

    @Override
    public boolean dependeDelVencimiento() {
        return this.estaVencido();
    }

}
