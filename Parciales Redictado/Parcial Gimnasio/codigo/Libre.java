package ParcialGimnasio;

import java.time.LocalDate;

public class Libre extends ServicioGym {
    private Socio socio;
    private int cantidadHoras;
    private static final double PRECIO_POR_HORA=300;
    private static final double DESCUENTO=0.10;
    private static final int CANTIDAD_SERVICIOS=5;

    public Libre(LocalDate fecha,Socio socio, int cantidadHoras){
        super(fecha);
        this.socio=socio;
        this.cantidadHoras=cantidadHoras;
    }

    private double precioTotalPorCantidadDeHoras(){
        return this.cantidadHoras * PRECIO_POR_HORA;
    }

    @Override
    public double costoDeServicio() {
        return this.socio.igualOmayor(CANTIDAD_SERVICIOS) ? (this.precioTotalPorCantidadDeHoras() * (1-DESCUENTO)) : this.precioTotalPorCantidadDeHoras();
    }
}
