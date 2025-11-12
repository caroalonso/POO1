package ejercicio24;

public class OrdenCompra extends Orden {

    private double precioEnvio;
    private static final int CINCO = 5;

    public OrdenCompra(Usuario usuario, String direccion, double precioEnvio) {
        super(usuario, direccion);
        this.precioEnvio = precioEnvio;
    }

    @Override
    public double costo() {
        return this.costoProductos();
    }

    @Override
    public boolean descuento() {
        return this.cantidadProductos(CINCO);
    }
}
