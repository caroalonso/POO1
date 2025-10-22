package ejercicio15;

public class Archivo {

    private String nombre;

    public Archivo(String nombreArchivo) {
        this.nombre = nombreArchivo;
    }

    public int tamanio() {
        return this.nombre.length();
    }

}
