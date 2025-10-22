package ParcialViviendas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String direccion;
    private List<Contrato> contratos;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contratos = new ArrayList<>();
    }

    public void agregarContratoUnico(LocalDate fecha, Servicio servicio) {
        this.contratos.add(new ContratoUnico(fecha, servicio));
    }

    public void agregarContratoProlongado(LocalDate fecha, int cantidadDias, Servicio servicio) {
        this.contratos.add(new ContratoProlongado(fecha, cantidadDias, servicio));
    }

    public double obtenerMonto() {
        return this.contratos.stream()
                .mapToDouble(c -> c.sumaValorContrato())
                .sum();
    }
}

