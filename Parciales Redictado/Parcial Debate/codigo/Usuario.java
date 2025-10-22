package ParcialDebate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String contrasenia;
    private LocalDate fecha;
    private TipoDeFeed tipoFeed;
    private List<Publicacion> publicaciones;
    private List<Usuario> seguidos;
    private List<Publicacion> publicacionesFeed;

    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.fecha = LocalDate.now();
        this.tipoFeed = new Social(); //por defecto
        this.publicaciones = new ArrayList<>();
        this.seguidos = new ArrayList<>();
        this.publicacionesFeed = new ArrayList<>();
    }

    public void agregarSeguido(Usuario usuario) {
        this.seguidos.add(usuario);
    }

    public void crearPublicacion(String titulo, String contenido) {
        this.publicaciones.add(new Publicacion(titulo, contenido));
    }

    public void setTipoFeed(TipoDeFeed tipoFeed) {
        this.tipoFeed = tipoFeed;
    }

    public List<Usuario> getSeguidos() {
        return this.seguidos;
    }

    public List<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }

    public void feed() {
        this.publicacionesFeed = this.tipoFeed.obtenerFeed(this);
    }
}
