package ParcialEnvioA;

import java.time.LocalDate;
import java.util.List;

public class Max extends Paquete{
    private final static double PESO=15000;
    private final static double VOLUMEN=25000;

    public Max (LocalDate fechaDescpacho, String destino, List<Producto> productos) {
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
