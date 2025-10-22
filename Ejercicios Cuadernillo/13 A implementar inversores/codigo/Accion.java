package ejercicio13;

public class Accion implements Inversion {

    private String nombre;
    private int cantidadAcciones;
    private double costoPorUnidadDeAccion;

    // asumo que la cantidad de acciones siempre es positiva y
    // el costo por unidad de accion tambien
    public Accion(String nombre, int cantidadAcciones, double costoPorUnidadAccion) {
        this.nombre = nombre;
        this.cantidadAcciones = cantidadAcciones;
        this.costoPorUnidadDeAccion = costoPorUnidadAccion;
    }

    @Override
    public double valorActualInversion() {
        return this.cantidadAcciones * this.costoPorUnidadDeAccion;
    }
}

