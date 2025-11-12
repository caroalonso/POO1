package ejercicio24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public abstract class Orden {

    private LocalDate fecha;
    private Usuario usuario;
    private String direccion;
    private List<Producto> productos;
    private static final double DESCUENTO = 0.10;
    public static final int UNO = 1;

    public Orden(Usuario usuario, String direccion) {
        this.fecha = LocalDate.now();
        this.usuario = usuario;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto (Producto producto){
        this.productos.add(producto);
    }

    public double costoProductos(){
        return this.productos.stream()
                .mapToDouble(p->p.getCosto())
                .sum();
    }

    public boolean cantidadProductos(int valor){
        return this.productos.size() >= valor;
    }

    public double calcularCosto() {
        if (this.descuento())
            return this.costo() * (UNO - DESCUENTO);
        return costo();
    }

    abstract double costo();
    abstract boolean descuento();
}
