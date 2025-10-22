package ParcialViviendas;

public class ServicioParquizacion extends Servicio {
    private int cantidadMaquinas;
    private double costoMaquinas;

    public ServicioParquizacion(double precio, int cantidadHoras, int cantidadMaquinas, double costoMaquinas) {
        super(precio, cantidadHoras);
        this.cantidadMaquinas = cantidadMaquinas;
        this.costoMaquinas = costoMaquinas;
    }

    public double maquinaPorCosto() {
        return this.cantidadMaquinas * this.costoMaquinas;
    }

    public double montoServicio() {
        return this.maquinaPorCosto() * this.precioPorHoras();
    }
}
