package ejercicio11;

public class CuentaCorriente extends Cuenta {

    private double limiteDescubierto;

    public CuentaCorriente(double saldo) {
        super(saldo);
        this.limiteDescubierto = 0;
    }

    public double getDescubierto() {
        return this.limiteDescubierto;
    }

    public void setDescubierto(double monto) {
        if (this.montoMayorAcero(monto))
            this.limiteDescubierto = monto;
    }


    @Override
    protected boolean puedeExtrar(double monto) {
        if (this.montoMayorAcero(monto))
          return this.getSaldo() + this.getDescubierto() >= monto;
        return false;
    }
}


