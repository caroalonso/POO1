package ejercicio25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    private Map <String,Integer> map;

    @BeforeEach
    void setUp(){
        map = new HashMap<>();
        map.put("Lionel Messi",111);
        map.put("Gabriel Batistuta",56);
        map.put("Kun Agüero",42);
    }

    @Test
    void testCantidadElementos() {
        assertEquals(3, map.size());
    }

    @Test
    void contieneClaveTrue(){
        assertTrue(map.containsKey("Lionel Messi"));
    }

    @Test
    void contieneClaveFale(){
        assertFalse(map.containsKey("Lionel"));
    }

    @Test
    void contieneValorTrue(){
        assertEquals(111, map.get("Lionel Messi"));
    }

    @Test
    void contieneValorNull(){
        assertNull(map.get("Lionel"));
    }

    @Test
    void eliminarExistente(){
        assertEquals(42,map.remove("Kun Agüero"));
    }

    @Test
    void eliminarNull(){
        assertNull(map.remove("Kun"));
    }

    @Test
    void vaciarMap(){
        map.clear();
        assertEquals(0,map.size());
    }

    @Test
    void actualizarContenidoNoExistente(){
        assertNull(map.put("Lopez",22));
    }

    @Test
    void actualizarContenidoExistente(){
        assertEquals(111,map.put("Lionel Messi",112));
    }

    @Test
    void modificarClaveExistente() { // Al agregar una misma clave con otro valor pisa el contenido anterior por el nuevo.
        assertEquals(56,map.put("Gabriel Batistuta",22)); //valor previo a modificacion.
        assertEquals(22,map.get("Gabriel Batistuta"));// valor actual Modificado.
    }

    @Test
    void modificarClaveNoExistente() {
        assertNull(map.put("Gabriel",22)); // clave inexistente a borrar.
        assertEquals(56,map.get("Gabriel Batistuta"));// valor actual Modificado.
    }

    @Test
    void cantidadDeGoles(){
        Integer contador=0;
        for ( Integer goles: map.values()){
            contador+= goles;
        }
        assertEquals(209,contador);
    }

}
