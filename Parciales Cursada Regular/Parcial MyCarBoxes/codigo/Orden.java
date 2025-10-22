package ParcialMyCarBoxesCorregir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden {
    private String patente;
    private LocalDate fecha;
    private List<Repuesto>repuestos;
    private final static double DIEZ_POR_CIENTO=0.10;

    public Orden(String patente) {
        this.patente = patente;
        this.fecha = LocalDate.now();
        this.repuestos = new ArrayList<>();
    }

    public Repuesto altaRepuesto(String nombre, double costo , LocalDate fechaFabricacion){
        Repuesto repuesto = new Repuesto(nombre,costo,fechaFabricacion);
        this.repuestos.add(repuesto);
        return repuesto;
    }

    public boolean mayorAvalor(){
        return this.repuestos.stream()
                .anyMatch(r->r.validarFecha());
    }

    protected double totalRepuestos(){
        return this.repuestos.stream()
                .mapToDouble(r->r.costo())
                .sum();
    }

    private double costoFinal(){
        return this.totalRepuestos() + this.costo() * (1 + DIEZ_POR_CIENTO);
    }

    public Factura facturacion(double descuento){
        double montoFinal = this.costoFinal() * (1 - descuento);
        double importeDescuento = this.costoFinal() * descuento;
        return new Factura(this.patente,montoFinal,importeDescuento);
    }

    public String patente(){
        return this.patente;
    }

    public LocalDate fecha(){
        return this.fecha;
    }

    abstract double costo();
}
