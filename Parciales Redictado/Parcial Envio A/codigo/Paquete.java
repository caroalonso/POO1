package ParcialEnvioA;

import java.time.LocalDate;
import java.util.List;

public abstract class Paquete {
    private LocalDate fechaDespacho;
    private String destino;
    private List<Producto> productos;

    public Paquete(LocalDate fechaDescpacho, String destino, List<Producto> productos) {
        this.fechaDespacho = fechaDescpacho;
        this.destino = destino;
        this.productos = productos;
    }

    public LocalDate fechaDespacho() {
        return fechaDespacho;
    }

    private double pesoDelPaquete(){
        return this.productos.stream()
                .mapToDouble(p->p.peso())
                .sum();
    }

    private double volumenDelPaquete(){
        return this.productos.stream()
                .mapToDouble(p->p.volumen())
                .sum();
    }

    public boolean validarPaquete(){
        return this.pesoDelPaquete() <= this.pesoPaquete() && this.volumenDelPaquete() <= this.volumenPaquete();
    }

    abstract double pesoPaquete();
    abstract double volumenPaquete();
}
