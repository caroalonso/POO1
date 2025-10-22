package ParcialMercadoOnlineCorregir;

public class Servicio extends Publicacion {

    private final static int QUINIENTOS = 500;
    private final static int OCHOCIENTOS = 800;
    private final static double OCHO_POR_CIENTO = 0.08;
    private final static double CERO = 0.0;
    private final static int DIEZ = 10;
    private final static int UNO = 1;

    public Servicio(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }

    private int esLocalidad(String localidadDada) {
        if (localidadDada.equals("AMBA"))
            return QUINIENTOS;
        return OCHOCIENTOS;
    }

    private double descuento(Usuario usuario) {
        if (usuario.mayorAvalor(DIEZ))
            return OCHO_POR_CIENTO;
        return CERO;
    }

    @Override
    public double elPrecioFinal(Usuario usuario, String localidadDada) {
        return this.esLocalidad(localidadDada) * (UNO - this.descuento(usuario));
    }

}
