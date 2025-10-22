package ejercicio14;

public abstract class Pieza {
    private String material;
    private String color;

    public Pieza(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public boolean esMaterial(String material){
        return this.material.equals(material);
    }

    public boolean esColor(String color){
        return this.color.equals(color);
    }

    protected double calculoEnComun(double radio, int potencia) {
        return Math.PI * Math.pow(radio, potencia);
    }

    abstract double volumen();

    abstract double superficie();

}
