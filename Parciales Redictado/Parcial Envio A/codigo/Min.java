package ParcialEnvioA;

import java.time.LocalDate;
import java.util.List;

public class Min extends Paquete{
    private final static double PESO=1200;
    private final static double VOLUMEN=1300;
    private final static double PRECIO=750;

    public Min(LocalDate fechaDescpacho, String destino, List<Producto> productos) {
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
