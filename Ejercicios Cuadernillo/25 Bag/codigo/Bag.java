package ejercicio25;

import java.util.Collection;
public interface Bag<T> extends Collection<T> {

    // agrega clave a Bag, incrementando en 1 su "contador".
    @Override
    boolean add(T key);

    // retorna "contador" de clave. Sí no existe la clave retorna 0.
    int occurrencesOf(T key);

    // resta 1 al "contador" de la clave. Si no existe la clave no hace nada.
    void removeOccurrence(T key);

    // elimina clave-valor de Bag. Sí no existe la clave no hace nada.
    void removeAll(T key);

    // Devuelve el número total de elementos en el Bag, es decir, la suma de todas las cardinalidades de todos sus elementos.
    @Override
    int size();
}
