package CalculoDeImpuestosA;

public abstract class Vehiculo extends Bien {
    private final static double DESCUENTO = 0.30;
    private boolean caracteristicasEcologicas;

    public Vehiculo(double valor, boolean caracteristicasEcologicas) {
        super(valor);
        this.caracteristicasEcologicas = caracteristicasEcologicas;
    }

    @Override
    public double descuento() {
        return this.caracteristicasEcologicas ? DESCUENTO : this.getCero();
    }
}
