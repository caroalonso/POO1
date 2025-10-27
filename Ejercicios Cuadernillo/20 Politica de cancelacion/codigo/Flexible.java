package ejercicio20;

public class Flexible implements PoliticaCancelacion {

    public Flexible() {
    }

    @Override
    public double reembolso(Reserva reserva, double precioNoche) {
        if (reserva.puedeCancelar())
            return reserva.precioReserva(precioNoche);
        return 0;
    }
}
