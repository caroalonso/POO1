package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private String tituloEmail;
    private String cuerpoEmail;
    private List<Archivo> adjuntos;

    public Email(String titulo, String cuerpo) {
        this.tituloEmail = titulo;
        this.cuerpoEmail = cuerpo;
        this.adjuntos = new ArrayList<>();
    }

    public void agregarArchivo(Archivo archivo) {
        this.adjuntos.add(archivo);
    }

    public String getTitulo() {
        return this.tituloEmail;
    }

    public String getCuerpo() {
        return this.cuerpoEmail;
    }

    public List<Archivo> adjuntos(){
        return this.adjuntos;
    }

    public boolean contieneTexto(String texto) {
        return this.getTitulo().contains(texto) || this.getCuerpo().contains(texto);
    }

    private int espacioAdjuntos() {
        return this.adjuntos.stream()
                .mapToInt(a -> a.tamanio())
                .sum();
    }

    public int espacioOcupado() {
        return this.espacioAdjuntos() + this.tituloEmail.length() + this.cuerpoEmail.length();
    }

}
