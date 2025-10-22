package ejercicio14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EsferaTest {

    private Esfera esfera;

    @Test
    void testParametroPositivo() {
        esfera = new Esfera("Hierro", "Negro", 2);
        assertEquals(50, esfera.superficie(), 0.3);
        assertEquals(33, esfera.volumen(), 0.6);
    }

    @Test
    void testParametroCero() {
        esfera = new Esfera("Vidrio", "Azul", 0);
        assertEquals(0, esfera.superficie(), 0.001);
        assertEquals(0, esfera.volumen(), 0.001);
    }

    @Test
    void testParametroNegativo() {
        // Verifica que se mande exception con radio negativo.
        assertThrows(IllegalArgumentException.class, () ->
        {new Esfera("Hierro", "Negro", -1);});
    }
}