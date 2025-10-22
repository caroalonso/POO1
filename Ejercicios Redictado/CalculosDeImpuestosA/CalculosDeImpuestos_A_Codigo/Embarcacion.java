package CalculoDeImpuestosA;

public class Embarcacion extends Vehiculo {
    private double valorMercado;
    private final static double QUINCE_POR_CIENTO = 0.15;
    private final static double DIEZ_POR_CIENTO = 0.10;
    private final static double MILLON = 1000000.0;

    public Embarcacion(double valor, double valorMercado, boolean caracteristicasEcologicas) {
        super(valor, caracteristicasEcologicas);
        this.valorMercado = valorMercado;
    }

    private boolean menorAmillon() {
        return this.valorMercado < MILLON;
    }


    @Override
    public double impuesto() {
        return this.menorAmillon() ? this.getValor() * DIEZ_POR_CIENTO : this.getValor() * QUINCE_POR_CIENTO;
    }
}
