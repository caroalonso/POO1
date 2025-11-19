package ejercicio29Bag;

public class Item {
    private String nombre;
    private int cantidad;
    private double precioUnidad;

    public Item (String nombre,int cantidad,double precioUnidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precioUnidad=precioUnidad;
    }

    public double costo (){
        return this.cantidad * this.precioUnidad;
    }
}
