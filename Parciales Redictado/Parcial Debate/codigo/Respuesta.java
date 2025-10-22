package ParcialDebate;

import java.time.LocalDate;

public class Respuesta {
    private Usuario usuario;
    private String contenido;
    private LocalDate fecha;

    public Respuesta(Usuario usuario, String contenido) {
        this.usuario = usuario;
        this.contenido = contenido;
        this.fecha = LocalDate.now();
    }
}
