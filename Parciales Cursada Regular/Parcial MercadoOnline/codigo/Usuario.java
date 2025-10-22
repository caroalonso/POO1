package ParcialMercadoOnlineCorregir;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

    private String email;
    private String localidad;
    private LocalDate fechaIngreso;
    private List<Publicacion> publicaciones;
    private final static int DIEZ = 10;

    public Usuario(String email, String localidad) {
        this.email = email;
        this.localidad = localidad;
        this.fechaIngreso = LocalDate.now();
        this.publicaciones = new ArrayList<>();
    }

    public Servicio agregarServicio(String nombre, String descripcion, double precio) {
        Servicio servicio = new Servicio(nombre, descripcion, precio);
        this.publicaciones.add(servicio);
        return servicio;
    }

    public Producto agregarProductoNuevo(String nombre, String descripcion, double precio, int cantidad, Entrega entrega) {
        Producto productoNuevo = new Producto(nombre, descripcion, precio, cantidad, entrega);
        this.publicaciones.add(productoNuevo);
        return productoNuevo;
    }

    public Producto agregarProductoUsado(String nombre, String descripcion, double precio) {
        Producto productoUsado = new Producto(nombre, descripcion, precio, 1, new EntregaRetiro());
        this.publicaciones.add(productoUsado);
        return productoUsado;
    }

    public boolean mayorAvalor(int valor) {
        return ChronoUnit.YEARS.between(this.fechaIngreso, LocalDate.now()) > valor;
    }

    public double distancia(String localidadDada) {
        return Map.distanceBetween(this.localidad, localidadDada) * DIEZ;
    }

    public List<Publicacion> ordenar(String localidadDada) {
        return this.publicaciones.stream()
                .sorted((p1, p2) -> Double.compare(p2.precioFinal(this, localidadDada), p1.precioFinal(this, localidadDada)))
                .collect(Collectors.toList());
    }

}
