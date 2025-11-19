package ejercicio25;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MapJugadorTest {

    private Map<Jugador, Integer> map;
    private Jugador messi;
    private Jugador batistuta;
    private Jugador aguero;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        messi = new Jugador("Lionel", "Messi");
        batistuta = new Jugador("Gabriel", "Batistuta");
        aguero = new Jugador("Sergio", "Agüero");

        map.put(messi, 111);
        map.put(batistuta, 56);
        map.put(aguero, 42);
    }

    @Test
    void testCantidadElementos() {
        assertEquals(3, map.size());
    }

    @Test
    void contieneClaveTrue() { // Debe funcionar gracias a equals/hashCode
        Jugador otroMessi = new Jugador("Lionel", "Messi");
        assertTrue(map.containsKey(otroMessi));
    }

    @Test
    void contieneClaveFalse() { // Apellido distinto
        Jugador otroMessi = new Jugador("Lionel", "Mesi");
        assertFalse(map.containsKey(otroMessi));
    }

    @Test
    void obtenerValor() {
        assertEquals(111, map.get(messi));
    }

    @Test
    void obtenerValorNull() {
        Jugador otroMessi = new Jugador("Lionel", "Mesi");
        assertNull(map.get(otroMessi));
    }

    @Test
    void eliminarElemento() {
        assertEquals(42, map.remove(aguero));
    }

    @Test
    void sumarGoles() {
        Integer contador = 0;
        for (Integer goles : map.values()) {
            contador += goles;
        }
        assertEquals(209, contador);
    }

    @Test
    void modificarValorExistente() {
        assertEquals(111, map.put(messi, 112)); // valor anterior a modificacion
        assertEquals(112, map.get(messi)); // nuevo valor
    }

    @Test
    void agregarNuevoJugador() {
        Jugador lopez = new Jugador("Juan", "Lopez");
        assertNull(map.put(lopez, 22)); // inexistente
        assertEquals(22, map.get(lopez)); // existente
    }
}

