package ParcialChequeyPagare;

import java.time.LocalDate;

public class Cheque extends Cobro {

    public Cheque(double monto, String destinatario, String originario, LocalDate fechaEmision) {
        super(monto, destinatario, originario, fechaEmision);
    }

    @Override
    public LocalDate getFecha() {
        return this.getFechaEmision().plusDays(30);
    }

    @Override
    public boolean dependeDelVencimiento() {
        return !this.estaVencido();
    }
}

// estaVencido() --> false = el cheque NO esta vencido.
// como necesito retornar True para .filter(Cobro -> Cobro.dependeDelVencimiento()) en el stream() en la clase Banco,
// si retorna false con ! lo pasa a True !this.estaVencido()
