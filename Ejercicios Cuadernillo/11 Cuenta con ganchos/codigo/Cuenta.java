package ejercicio11;

public abstract class Cuenta {
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean depositar(double monto) {
        if (this.montoMayorAcero(monto)) {
            this.saldo += monto;
            return true;
        }
        return false;
    }

    public boolean extraer(double monto) {
        if (this.puedeExtrar(monto)) {
            this.extrarSinControlar(monto);
            return true;
        }
        return false;
    }

    public boolean tranferirAcuenta(double monto, Cuenta cuentaDestino) {
        if (this.montoMayorAcero(monto)) {
            if (this.puedeExtrar(monto)) {
                this.extrarSinControlar(monto);
                cuentaDestino.depositar(monto);
                return true;
            }
            return false;
        }
        return false;
    }

    protected void extrarSinControlar(double monto) {
        this.saldo -= monto;
    }

    public boolean montoMayorAcero(double monto) {
        return monto > 0;
    }

    protected abstract boolean puedeExtrar(double monto);

}
