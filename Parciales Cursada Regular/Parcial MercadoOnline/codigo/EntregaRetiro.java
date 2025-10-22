package ParcialMercadoOnlineCorregir;

public class EntregaRetiro implements Entrega {

    private static final double CERO = 0;

    public EntregaRetiro() {
    }

    @Override
    public double descuento() {
        return CERO;
    }

    @Override
    public double costo(Usuario usuario, String localidadDada) {
        return CERO;
    }

}
