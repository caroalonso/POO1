package ParcialMyCarBoxesCorregir;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyCarBoxes {
    private List<Orden> ordenes;
    private final static double CINCO_POR_CIENTO = 0.05;
    private final static double CERO = 0;


    public MyCarBoxes() {
        this.ordenes = new ArrayList<>();
    }

    public OrdenCompra altaOrdenCompra(String patente) {
        OrdenCompra ordenCompra = new OrdenCompra(patente);
        this.ordenes.add(ordenCompra);
        return ordenCompra;
    }

    public OrdenReparacion altaOrdenReparacion(String patente, String descripcion, int cantidadHoras) {
        OrdenReparacion ordenReparacion = new OrdenReparacion(patente, descripcion, cantidadHoras);
        this.ordenes.add(ordenReparacion);
        return ordenReparacion;
    }

    // LocalDate.now().minusYears(1) = Calcula fecha desde hace un año a partir de hoy.
    // Si fecha de orden es posterior a esa fecha calculada( dentro del último año) = true
    private boolean ordenUltimoAnio(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now().minusYears(1));
    }

    private double descuentoOrdenesUltimoAnio(String patente, LocalDate fecha) {
        long resultado = this.ordenes.stream()
                .filter(orden -> orden.patente().equals(patente) && this.ordenUltimoAnio(fecha))
                .count(); // retorna tipo Long
        return resultado > 1 ? CINCO_POR_CIENTO : CERO;
    }

    public List<Factura> facturacionOrdenes() {
        return this.ordenes.stream()
                .map(orden -> orden.facturacion(this.descuentoOrdenesUltimoAnio(orden.patente(),orden.fecha())))
                .collect(Collectors.toList());
    }

}


