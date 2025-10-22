package ejercicio13;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {
    private LocalDate fechaDeposito;
    private double montoDepositado;
    private double interesDiario;

    // asumo que el montoDeposito es mayor a cero y el interes Diario ingredado tmb
    public PlazoFijo(LocalDate fechaDeposito,double montoDepositado,double interesDiario) {
        this.fechaDeposito = fechaDeposito;
        this.montoDepositado = montoDepositado;
        this.interesDiario=interesDiario;
    }

    private long cantidadDiasDesdeDeposito() {
        return ChronoUnit.DAYS.between(fechaDeposito, LocalDate.now());
    }

    @Override
    public double  valorActualInversion() {
        return this.montoDepositado + (this.montoDepositado *  this.cantidadDiasDesdeDeposito() * this.interesDiario);
        // MontoDepositadoPrimerDiaSinInteres + (MontoDepositado x cantidadDeDias x Intereses)
    }
}

