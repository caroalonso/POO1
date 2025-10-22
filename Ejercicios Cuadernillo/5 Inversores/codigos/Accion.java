package ejercicio5;

public class Accion implements Inversion {
    private String nombre;
    private int cantidadAcciones;
    private double costoPorUnidadDeAccion;

    public Accion(String nombre, int cantidadAcciones, double costoPorUnidadAccion) {
        if (cantidadAcciones <= 0) {
            throw new IllegalArgumentException("La cantidad de acciones debe ser mayor que cero.");
        }
        if (costoPorUnidadAccion <= 0) {
            throw new IllegalArgumentException("El costo por unidad debe ser mayor que cero.");
        }
        this.nombre = nombre;
        this.cantidadAcciones = cantidadAcciones;
        this.costoPorUnidadDeAccion = costoPorUnidadAccion;
    }

    @Override
    public double valorActualInversion() {
        return this.cantidadAcciones * this.costoPorUnidadDeAccion;
    }
}

