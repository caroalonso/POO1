package ParcialMercadoOnlineCorregir;

public interface Entrega {
    double descuento();
    double costo(Usuario usuario, String localidadDada);
}
