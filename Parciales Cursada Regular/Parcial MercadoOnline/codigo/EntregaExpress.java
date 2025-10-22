package ParcialMercadoOnlineCorregir;

public class EntregaExpress implements Entrega {

    private static final double DIEZ_POR_CIENTO = 0.10;

    public EntregaExpress() {}

    @Override
    public double descuento() {
        return DIEZ_POR_CIENTO;
    }

    @Override
    public double costo(Usuario usuario, String localidadDada) {
        return usuario.distancia(localidadDada);
    }
}
