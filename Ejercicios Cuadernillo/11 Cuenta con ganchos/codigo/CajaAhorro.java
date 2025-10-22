package ejercicio11;

public class CajaAhorro extends Cuenta {
    private final static double DOS_POR_CIENTO = 0.02;

    public CajaAhorro(double saldo) {
        super(saldo);
    }

    private double sumarPorcentajeAmonto(double monto) {
        return monto * (1 + DOS_POR_CIENTO);
    }

    private double restarPorcentajeAmonto(double monto) {
        return monto * (1 - DOS_POR_CIENTO);
    }

    private boolean montoMasPorcentaje(double monto) {
        return this.getSaldo() >= this.sumarPorcentajeAmonto(monto);
    }

    protected void extrarSinControlar(double monto) {
        super.extrarSinControlar(sumarPorcentajeAmonto(monto));
    }

    public boolean depositar(double monto) {
        return  super.depositar(restarPorcentajeAmonto(monto));
    }

    @Override
    protected boolean puedeExtrar(double monto) {
        if (this.montoMayorAcero(monto))
          return montoMasPorcentaje(monto);
        return false;
    }

}
