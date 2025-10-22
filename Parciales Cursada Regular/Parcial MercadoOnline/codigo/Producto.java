package ParcialMercadoOnlineCorregir;

public class Producto extends Publicacion {

    private int cantidad;
    private Entrega entrega;
    private static final int UNO= 1;

    public Producto(String nombre, String descripcion, double precio, int cantidad, Entrega entrega) {
        super(nombre, descripcion, precio);
        this.entrega = entrega;
        this.cantidad = cantidad;
    }

    @Override
    public double elPrecioFinal(Usuario usuario, String localidadDada) {
        return this.entrega.costo(usuario, localidadDada) + (this.cantidad * (UNO - this.entrega.descuento()));
    }

}

