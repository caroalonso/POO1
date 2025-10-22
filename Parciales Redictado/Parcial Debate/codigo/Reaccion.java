package ParcialDebate;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Reaccion implements TipoDeFeed {

    @Override
    public List<Publicacion> obtenerFeed(Usuario usuario) {
    return usuario.getPublicaciones().stream()
            .sorted((r1,r2)->Integer.compare(cantidadReacciones(r2),cantidadReacciones(r1)))
            .collect(Collectors.toList());
    }

    abstract int cantidadReacciones(Publicacion publicacion);
}
