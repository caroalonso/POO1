package ejercicio22;

public class Vianda {

    private String nombre;
    private double precio;
    private boolean aptoCeliaco;
    private boolean disponibilidad;

    public Vianda(String nombre, double precio, boolean aptoCeliaco, boolean disponibilidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.aptoCeliaco = aptoCeliaco;
        this.disponibilidad = disponibilidad;
    }

    public double getPrecio(){
        return this.precio;
    }

    public boolean getAptoCeliaco(){
        return this.aptoCeliaco;
    }

}
