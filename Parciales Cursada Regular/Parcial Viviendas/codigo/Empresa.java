package ParcialViviendas;

import java.util.List;
import java.util.ArrayList;

public class Empresa {
    private List<Servicio> servicios;
    private List<Cliente> clientes;

    public Empresa() {
        this.servicios = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public Cliente agregarCliente(String nombre, String direccion) {
        Cliente cliente = new Cliente(nombre, direccion);
        this.clientes.add(cliente);
        return cliente;
    }

    public ServicioLimpieza agregarServicioLimpieza(double precio, int cantidadHoras, double tarifaMinima) {
        ServicioLimpieza servicioLimpieza = new ServicioLimpieza(precio, cantidadHoras, tarifaMinima);
        this.servicios.add(servicioLimpieza);
        return servicioLimpieza;
    }

    public ServicioParquizacion agregarServicioParquizacion(double precio, int cantidadHoras, int cantidadMaquinas, double costoMaquinas) {
        ServicioParquizacion servicioParquizacion = new ServicioParquizacion(precio, cantidadHoras, cantidadMaquinas, costoMaquinas);
        this.servicios.add(servicioParquizacion);
        return servicioParquizacion;
    }

    public int serviciosConMontosMayorAvalor(int valor) {
        return (int) this.servicios.stream()
                .filter(s -> s.montoServicio() > valor)
                .count();
    }
}
