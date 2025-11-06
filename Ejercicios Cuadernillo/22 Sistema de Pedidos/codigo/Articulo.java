package ejercicio22;

public class Articulo {

    private String nombre;
    private double precio;
    private String categoria;
    private double peso;
    private int stock;
    public static final int TREINTICINCO = 35;

    public Articulo(String nombre, double precio, String categoria, double peso, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.peso = peso;
        this.stock = stock;
    }

    public double getPrecio() {
        return this.precio;
    }

    public double getPeso() {
        return this.peso;
    }

    public boolean cumpleConPeso() {
        return this.getPeso() > TREINTICINCO;
    }
}
