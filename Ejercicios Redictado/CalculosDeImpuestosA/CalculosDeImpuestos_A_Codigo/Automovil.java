package CalculoDeImpuestosA;

public class Automovil extends Vehiculo {
    private int antiguedad;
    private final static double CINCO_POR_CIENTO= 0.05;
    private final static int DIEZ=10;

    public Automovil (double valor,boolean caracteristicasEcologicas,int antiguedad){
        super(valor,caracteristicasEcologicas);
        this.antiguedad=antiguedad;
    }

    private boolean menorAdiez(){
        return this.antiguedad < DIEZ;
    }

    @Override
    public double impuesto(){
        return this.menorAdiez() ? this.getValor()* CINCO_POR_CIENTO : this.getCero();
    }
}
