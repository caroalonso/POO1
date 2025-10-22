package ejercicio3;

public class Item {

    private String detalle;
    private int cantidad;
    private double costoUnitario;

    public Item() {}

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public double costo() {
        return this.cantidad * this.costoUnitario;
    }
}
