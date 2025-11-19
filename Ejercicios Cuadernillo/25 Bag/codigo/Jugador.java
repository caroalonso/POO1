package ejercicio25;

import java.util.Objects;

public class Jugador {

    private String nombre;
    private String apellido;

    public Jugador (String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof Jugador))
            return false;
        Jugador other = (Jugador) obj;
        return Objects.equals(nombre, other.nombre) &&
               Objects.equals(apellido, other.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
