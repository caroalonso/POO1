package ejercicio14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrismasRectangularesTest {

    private PrismasRectangulares prismasRectangulares;

    @Test
    void testParametrosPositivos() {
        prismasRectangulares = new PrismasRectangulares("Hierro", "Negro", 2, 2,2);
        assertEquals(24, prismasRectangulares.superficie(), 0.001);
        assertEquals(8, prismasRectangulares.volumen(), 0.001);
    }

    @Test
    void testParametrosCero() {
        prismasRectangulares = new PrismasRectangulares("Vidrio", "Azul", 0, 2,2);
        assertEquals(8, prismasRectangulares.superficie(), 0.001);
        assertEquals(0, prismasRectangulares.volumen(), 0.001);

        prismasRectangulares = new PrismasRectangulares("Vidrio", "Azul", 2, 0,2);
        assertEquals(8, prismasRectangulares.superficie(), 0.001);
        assertEquals(0, prismasRectangulares.volumen(), 0.001);

        prismasRectangulares = new PrismasRectangulares("Vidrio", "Azul", 2, 2,0);
        assertEquals(8, prismasRectangulares.superficie(), 0.001);
        assertEquals(0, prismasRectangulares.volumen(), 0.001);
    }

    @Test
    void testParametrosNegativos() {
        assertThrows(IllegalArgumentException.class, () ->
        {new PrismasRectangulares("Hierro", "Negro", -1, 2,2);});
        assertThrows(IllegalArgumentException.class, () ->
        {new PrismasRectangulares("Madera", "Rojo", 2, -1,2);});
        assertThrows(IllegalArgumentException.class, () ->
        {new PrismasRectangulares("Vidrio", "Amarillo", 2, 2,-1);});
    }
}