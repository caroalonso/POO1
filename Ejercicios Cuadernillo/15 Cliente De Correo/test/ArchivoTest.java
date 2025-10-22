package ejercicio15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArchivoTest {

    private Archivo archivo;

    @Test
    void testTamanio(){
        archivo= new Archivo("arch");
        assertEquals(4,archivo.tamanio());
    }
}
