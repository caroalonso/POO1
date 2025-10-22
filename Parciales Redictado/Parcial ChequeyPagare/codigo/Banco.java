package ParcialChequeyPagare;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Cobro> cobros;

    public Banco() {
        this.cobros = new ArrayList<Cobro>();
    }

    public void agregarCheque(Cheque cheque) {
        this.cobros.add(cheque);
    }

    public void agregarPagare(Pagare pagare) {
        this.cobros.add(pagare);
    }

    public double valorLiquido() {
        return this.cobros.stream()
                .filter(Cobro -> Cobro.dependeDelVencimiento())
                .mapToDouble(Cobro -> Cobro.getMonto())
                .sum();
    }

}
