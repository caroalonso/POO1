package ejercicio5;

public class Cuadrado implements Figura {
    private double lado;

    public Cuadrado() {}

    public void setLado(double unLado) {
        this.lado = unLado;
    }

    public double getLado() {
        return this.lado;
    }

    @Override
    public double getArea() {
        return (this.lado * this.lado);
    }

    @Override
    public double getPerimetro() {
        return (this.lado * 4);
    }

}
