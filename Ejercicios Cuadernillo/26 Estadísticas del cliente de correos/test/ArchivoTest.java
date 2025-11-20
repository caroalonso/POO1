package ejercicio26;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArchivoTest {

    @Test
    void testTamanioArchivo() {
        assertEquals(0, new Archivo("").tamanio());
        assertEquals(1, new Archivo("a").tamanio());
        assertEquals(6, new Archivo("archivo").tamanio());
    }
}
