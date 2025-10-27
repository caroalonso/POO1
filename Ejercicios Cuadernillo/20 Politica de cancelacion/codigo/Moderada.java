package ejercicio20;

public class Moderada implements PoliticaCancelacion {

    private static final int SIETE = 7;
    private static final int DOS = 2;
    private static final double CINCUENTA_POR_CIENTO = 0.50;

    public Moderada() {
    }

    @Override
    public double reembolso(Reserva reserva, double precioNoche) {
        if (reserva.estaDentroDeLosUltimosXDiasAntesDelInicio(DOS))
            return reserva.precioReserva(precioNoche) * CINCUENTA_POR_CIENTO;
        if (reserva.estaDentroDeLosUltimosXDiasAntesDelInicio(SIETE))
            return reserva.precioReserva(precioNoche);
        return 0;
    }

}
