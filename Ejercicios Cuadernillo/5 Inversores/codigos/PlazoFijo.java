package ejercicio5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {
    private LocalDate fechaDeposito;
    private double montoDepositado;
    private double interesDiario;

    public PlazoFijo(LocalDate fechaDeposito,double montoDepositado,double interesDiario) {
        if (fechaDeposito.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de constitución debe ser hoy o una fecha futura.");
        }
        if (montoDepositado <= 0) {
            throw new IllegalArgumentException("El monto depositado debe ser mayor que cero.");
        }
        if (interesDiario <= 0) {
            throw new IllegalArgumentException("El interes diario debe ser mayor que cero.");
        }
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

