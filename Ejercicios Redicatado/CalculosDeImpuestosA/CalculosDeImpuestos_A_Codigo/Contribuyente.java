package CalculoDeImpuestosA;

import java.util.ArrayList;
import java.util.List;

public class Contribuyente {
    private List<Bien> bienes;

    public Contribuyente() {
        this.bienes = new ArrayList<>();
    }

    public double calcularTotalDeImpuestosApagar() {
        return this.bienes.stream()
                .mapToDouble(b -> b.calcularImpuesto())
                .sum();
    }
}
