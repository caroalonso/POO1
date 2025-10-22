package ParcialMercadoOnlineCorregir;

public class EntregaCorreo implements Entrega {

    private static final double CINCO_POR_CIENTO = 0.05;
    private static final double QUINIENTOS = 500;

    public EntregaCorreo(){}

    @Override
    public double descuento() {
        return CINCO_POR_CIENTO;
    }

    @Override
    public double costo(Usuario usuario, String localidadDada) {
        return QUINIENTOS;
    }
}
