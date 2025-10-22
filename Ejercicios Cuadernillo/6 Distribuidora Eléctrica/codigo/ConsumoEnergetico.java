package ejercicio6;

import java.time.LocalDate;

public class ConsumoEnergetico {
    private LocalDate fecha;
    private double energiaActiva;
    private double energiaReactiva;

    public ConsumoEnergetico(double energiaActiva, double energiaReactiva) {
        this.fecha = LocalDate.now();
        this.energiaActiva = energiaActiva;
        this.energiaReactiva = energiaReactiva;
    }

    public LocalDate fecha() {
        return this.fecha;
    }

    private double costoDeConsumo(CuadroTarifario cuadro) {
        return this.energiaActiva * cuadro.getPreciokWh();
    }

    private double factorDePotencia() {
        return this.energiaActiva / (Math.sqrt((Math.pow(this.energiaActiva, 2) + Math.pow(this.energiaReactiva, 2)))) > 0.8 ? 0.10 : 0.0;
    }

    public double bonificacion(CuadroTarifario cuadro) {
        //retorna el 10% o 0% del valor del costo del consumo.
        return this.costoDeConsumo(cuadro) * this.factorDePotencia();
    }

    public double montoTotal(CuadroTarifario cuadro) {
        return this.costoDeConsumo(cuadro) * (1 - this.factorDePotencia());
    }

}




