package ejercicio2;

import java.time.LocalDate;

public class Ticket {

    private final LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    //private double impuestoTotal;


    public Ticket (int cantidadDeProductos, double pesoTotal, double precioTotal) {
        this.fecha=LocalDate.now();
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
        //this.impuestoTotal = precioTotal * 0.21;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double impuesto(){
        return precioTotal * 0.21;
    }

    @Override
    public String toString() {
        return "-------------------------------------" + "\n" +
                "Fecha: " + this.fecha + "\n" +
                "Cantidad de Productos: " + this.cantidadDeProductos + "\n" +
                "Peso Total:  " + String.format("%.3f", this.pesoTotal) + " Kg" + "\n" +
                "Precio Total con impuestos: $ " + String.format("%.3f", this.impuesto()) + "\n" +
                // "Precio Total con impuestos: $ " + String.format("%.3f", this.impuestoTotal()) + "\n" +
                "-------------------------------------";
    }

}
