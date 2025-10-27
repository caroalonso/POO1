package ejercicio20;

public class Estricta implements PoliticaCancelacion {

    public Estricta() {
    }

    @Override
    public double reembolso(Reserva reserva, double precioNoche) {
        return 0;
    }
}
