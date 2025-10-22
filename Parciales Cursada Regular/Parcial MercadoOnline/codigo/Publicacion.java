package ParcialMercadoOnlineCorregir;

public abstract class Publicacion {

    private String nombre;
    private String descripcion;
    private double precio;

    public Publicacion(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public double precioFinal(Usuario usuario, String localidadDada) {
        return this.precio + elPrecioFinal(usuario,localidadDada);
    }
    abstract double elPrecioFinal(Usuario usuario, String localidadDada);

}
