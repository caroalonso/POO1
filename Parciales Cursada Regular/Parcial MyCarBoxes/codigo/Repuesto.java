package ParcialMyCarBoxesCorregir;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Repuesto {
    private String nombre;
    private double costo;
    private LocalDate fechaFabricacion;
    private final static int VALOR=5;


    public Repuesto(String nombre, double costo, LocalDate fechaFabricacion) {
        this.nombre = nombre;
        this.costo = costo;
        this.fechaFabricacion = fechaFabricacion;
    }

    public double costo(){
        return this.costo;
    }

    public boolean validarFecha(){
        return ChronoUnit.YEARS.between(this.fechaFabricacion,LocalDate.now()) > VALOR;
    }
}
