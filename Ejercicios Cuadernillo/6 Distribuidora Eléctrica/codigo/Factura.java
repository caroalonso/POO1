package ejercicio6;

import java.time.LocalDate;

public class Factura {
    private Usuario usuario;
    private LocalDate fechaEmicion;
    private double bonificacion;
    private double montoTotal;

    public Factura(Usuario usuario,double bonificacion,double montoTotal){
        this.usuario=usuario;
        this.fechaEmicion=LocalDate.now();
        this.bonificacion=bonificacion;
        this.montoTotal=montoTotal;
    }
}
