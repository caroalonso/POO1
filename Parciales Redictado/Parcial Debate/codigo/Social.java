package ParcialDebate;

import java.util.List;
import java.util.stream.Collectors;

public class Social implements TipoDeFeed {

    public Social() {}

    @Override
    public List<Publicacion> obtenerFeed(Usuario usuario) {
        return usuario.getSeguidos().stream()
                .flatMap(seg -> seg.getPublicaciones().stream())
                .sorted((f1, f2) -> f2.getFecha().compareTo(f1.getFecha()))
                .collect(Collectors.toList());

    }
}
