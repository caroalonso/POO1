package ejercicio14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CilindroTest {

    private Cilindro cilindro;

    @Test
    void testParametrosPositivos() {
        cilindro = new Cilindro("Hierro", "Negro", 2, 2);
        assertEquals(50, cilindro.superficie(), 0.3);
        assertEquals(25, cilindro.volumen(), 0.2);
    }
   @Test
    void testParametrosCero() {
        cilindro = new Cilindro("Vidrio", "Azul", 0, 2);
        assertEquals(0, cilindro.superficie(), 0.001);
        assertEquals(0, cilindro.volumen(), 0.001);
        cilindro = new Cilindro("Madera", "Naranja", 2, 0);
        assertEquals(25, cilindro.superficie(), 0.133);
        assertEquals(0, cilindro.volumen(), 0.001);
    }

    @Test
    void testParametrosNegativos() {
        // Verififica que se mande exception con radio y altura negativa.
        assertThrows(IllegalArgumentException.class, () ->
        {new Cilindro("Hierro", "Negro", -1, 2);});
        assertThrows(IllegalArgumentException.class, () ->
        {new Cilindro("Madera", "Rojo", 2, -1);});
    }

}