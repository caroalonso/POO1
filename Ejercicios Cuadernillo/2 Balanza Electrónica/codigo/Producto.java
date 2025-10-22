package ejercicio2;

public class Producto {

    private double peso;
    private double precioPorKilo;
    private String descripcion;

    public Producto() {}

    public double getPrecio(){

        return peso * precioPorKilo;
   }

    public void setPeso(double peso) {

        this.peso = peso;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecioPorKilo() {

        return precioPorKilo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return  "Descripcion: "+ this.descripcion + "\n" +
                "Peso: " + String.format("%.3f", this.peso) +" Kg "+ "\n" +
                "Precio Por Kilo: $ " + String.format("%.3f", this.precioPorKilo);

    }
}

