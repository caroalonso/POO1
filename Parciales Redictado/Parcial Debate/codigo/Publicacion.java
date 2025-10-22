package ParcialDebate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private String titulo;
    private String contenido;
    private List<Respuesta> respuestas;
    private LocalDate fecha;
    private int like;
    private int dislike;

    public Publicacion(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.respuestas = new ArrayList<>();
        this.fecha = LocalDate.now();
        this.like = 0;
        this.dislike = 0;
    }

    public void crearRespuesta(Usuario usuario, String contenido) {
        this.respuestas.add( new Respuesta(usuario, contenido));
    }

    public void registrarLike() {
        this.like++;
    }

    public void registrarDislike() {
        this.dislike++;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public int getLike() {
        return this.like;
    }

    public int getDislike() {
        return this.dislike;
    }
}
