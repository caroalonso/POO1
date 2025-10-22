package ParcialImpuestosBcorregir;

import java.time.LocalDate;

public class Automotor extends Vehiculo {
    private String modelo;
    private String marca;
    private final static double PORCENTAJE_CINCO = 0.05;

    public Automotor(String patente, String marca, String modelo, double valor, LocalDate fechaFabricacion) {
        super(patente, fechaFabricacion, valor);
        this.modelo = modelo;
        this.marca = marca;
    }

    @Override
    double porcentaje() {
        return PORCENTAJE_CINCO;
    }
}
