package ejercicio22;

import java.util.List;

public class PedidosSupermercado extends Pedido {

    private List<Articulo> productos;
    private boolean cupon;
    public static final int UNO=1;
    public static final double DESCUENTO=0.10;


    public PedidosSupermercado(String email, Entrega entrega, List<Articulo> productos, boolean cupon) {
        super(email, entrega);
        this.productos = productos;
        this.cupon = cupon;
    }

    public void agregarArticulo(Articulo articulo) {
        if (articulo.cumpleConPeso())
            this.productos.add(articulo);
    }

    public double costoPedidos() {
        double costo= this.productos.stream()
                .mapToDouble(p -> p.getPrecio())
                .sum();
        return this.cupon ? costo : costo * (UNO - DESCUENTO);
    }

    public double pesoPedidos() {
        return this.productos.stream()
                .mapToDouble(p -> p.getPeso())
                .sum();
    }
}
