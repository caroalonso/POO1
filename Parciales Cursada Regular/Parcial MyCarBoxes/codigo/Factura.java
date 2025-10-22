package ParcialMyCarBoxesCorregir;

import java.time.LocalDate;

public class Factura {
    private LocalDate fecha;
    private String patente;
    private double montoFinal;
    private double descuento;

    public Factura(String patente, double montoFinal, double descuento) {
        this.fecha = LocalDate.now();
        this.patente = patente;
        this.montoFinal = montoFinal;
        this.descuento = descuento;
    }
}
