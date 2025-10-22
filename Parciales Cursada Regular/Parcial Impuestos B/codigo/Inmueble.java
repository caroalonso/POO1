package ParcialImpuestosBcorregir;

public class Inmueble implements Bien {
    private int numPartida;
    private double valorLote;
    private double valorEdificacion;

    public Inmueble(int numPartida, double valorLote, double valorEdificacion) {
        this.numPartida = numPartida;
        this.valorLote = valorLote;
        this.valorEdificacion = valorEdificacion;
    }

    @Override
    public double calcularImpuesto() {
        return this.valorLote + this.valorEdificacion;
    }
}
