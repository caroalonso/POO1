package ParcialDebate;

import java.util.List;

public interface TipoDeFeed {
    List<Publicacion> obtenerFeed(Usuario usuario);
}
