package ParcialEnvioA;

import java.time.LocalDate;
import java.util.List;

public class Normal extends Paquete {
    private final static double PESO=5000;
    private final static double VOLUMEN=10000;
    private final static double PRECIO=1800;

    public Normal(LocalDate fechaDescpacho, String destino, List<Producto> productos) {
        super(fechaDescpacho, destino, productos);
    }

    @Override
    double pesoPaquete() {
        return PESO;
    }

    @Override
    double volumenPaquete() {
        return VOLUMEN;
    }
}
