package ParcialViviendas;

public abstract class Servicio {
    private double precio;
    private int cantidadHoras;

    public Servicio(double precio, int cantidadHoras) {
        this.precio = precio;
        this.cantidadHoras = cantidadHoras;
    }

    public double precioPorHoras() {
        return this.precio * this.cantidadHoras;
    }

    abstract double montoServicio();

}
