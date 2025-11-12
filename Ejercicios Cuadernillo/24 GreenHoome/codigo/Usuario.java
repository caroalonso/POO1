package ejercicio24;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombreCompleto;
    private String domicilio;
    private List<Orden> ordenes;

    public Usuario(String nombreCompleto, String domicilio) { //<- minimo 1 orden parametro Orden orden
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.ordenes = new ArrayList<>();
        // this.ordenes.add(orden);
    }

    public void agregarOrden(Orden orden) {
        this.ordenes.add(orden);
    }

    public List<Orden> getOrdenes() {
        return this.ordenes;
    }

    public double calcularCosto() {
        return this.ordenes.stream()
                .mapToDouble(o -> o.calcularCosto())
                .sum();
    }

}
