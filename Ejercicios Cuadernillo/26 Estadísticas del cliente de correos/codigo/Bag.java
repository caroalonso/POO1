package ejercicio26;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bag<T> extends AbstractCollection<T> implements BagInterface<T> {

    private Map <T,Integer> bag;

    public Bag() {
        this.bag = new HashMap<>();
    }

    // agrega clave nueva e incrementa en 1 "contador" de la clave.
    @Override
    public boolean add(T key) {
        bag.put (key,bag.getOrDefault(key, 0) + 1);
        return true;
    }

    // retorna "contador" de clave. Sí no existe la clave retorna 0.
    @Override
    public int occurrencesOf(T key) {
        return bag.getOrDefault(key, 0);
    }

    // resta en 1 el "contador" si existe la clave.
    @Override
    public void removeOccurrence(T key) {

        if (bag.containsKey(key)) { // si existe clave
            int current = bag.get(key); // guardo el "valor contador" de la clave
            if (current > 1) // si el valor mayor a 1
                bag.put(key, current - 1); // resto 1 al "valor cntador"
            else
                bag.remove(key); // si es 1 elimino clave y valor de map.
        }
    }

    // elimina clave-valor de bag.
    @Override
    public void removeAll(T key) {
        bag.remove(key);
    }

    // suma todo los "contadores" de las claves.
    @Override
    public int size() {
      return   bag.values().stream()
              .mapToInt(i -> i.intValue())
              .sum();
    }

    // NUEVO METODO AGREGADO PARA SABER CANTIDAD DE CLAVES SIN REPETIR
    public int sizeUnique() {
        return bag.size();  // cantidad de claves sin repetir de bag , llama a .size de HashMap no de bag.
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = bag.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
