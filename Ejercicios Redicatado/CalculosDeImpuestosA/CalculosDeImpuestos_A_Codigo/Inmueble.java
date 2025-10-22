package CalculoDeImpuestosA;

public class Inmueble extends Bien {
    private int antiguedad;
    private boolean edificacion;
    private final static double QUINIENTOS_MIL = 500.000;
    private final static double UNO_POR_CIENTO = 0.01;
    private final static double DOS_POR_CIENTO = 0.02;
    private final static double DESCUENTO = 0.20;
    private final static int ANIOS = 5;

    public Inmueble(double valor, int antiguedad, boolean edificacion) {
        super(valor);
        this.antiguedad = antiguedad;
        this.edificacion = edificacion;
    }

    private boolean aplicaParaDescuento() {
        return ((this.edificacion) && (this.antiguedad > ANIOS) && (this.getValor() < QUINIENTOS_MIL));
    }

    @Override
    public double impuesto() {
        return this.edificacion ? this.getValor() * UNO_POR_CIENTO : this.getValor() * DOS_POR_CIENTO;
    }

    @Override
    public double descuento() {
        return this.aplicaParaDescuento() ? DESCUENTO : this.getCero();
    }
}
