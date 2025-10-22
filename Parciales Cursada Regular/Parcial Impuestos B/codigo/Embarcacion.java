package ParcialImpuestosBcorregir;

import java.time.LocalDate;

public class Embarcacion extends Vehiculo {
    private String nombre;
    private final static double PORCENTAJE_QUINCE = 0.15;
    private final static double PORCENTAJE_DIEZ = 0.10;

    public Embarcacion(String patente, String nombre, double valor, LocalDate fechaFabricacion) {
        super(patente, fechaFabricacion, valor);
        this.nombre = nombre;
    }

    @Override
    double porcentaje() {
        if (this.menorAn())
            return PORCENTAJE_QUINCE;
        return PORCENTAJE_DIEZ;
    }
}
