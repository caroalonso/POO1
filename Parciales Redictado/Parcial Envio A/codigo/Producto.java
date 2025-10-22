package ParcialEnvioA;

public class Producto {
    private double peso;
    private double volumen;

    public Producto (double peso , double volumen){
        this.peso=peso;
        this.volumen=volumen;
    }

    public double peso(){
        return this.peso;
    }

    public double volumen(){
        return this.volumen;
    }
}
