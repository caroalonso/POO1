package ejercicio26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void testEspacioOcupadoEmail() {
        Email email = new Email("Hola", "mundo"); // 9 caracteres
        email.agregarArchivo(new Archivo("doc")); // 3 caracteres

        assertEquals(12, email.espacioOcupado()); // 12 total
    }

    @Test
    void testCategoriaEmail() {
        // Pequeño → 1 a 300
        Email ePeqBordeInf = new Email(".", "a".repeat(298)); // Total = 299
        assertEquals("Pequeño", ePeqBordeInf.categoriaEmail());

        Email ePeqBordeSup = new Email("a".repeat(300), "");  // Total = 300
        assertEquals("Pequeño", ePeqBordeSup.categoriaEmail());

        // Mediano → 301 a 500
        Email eMedBordeInf = new Email("a".repeat(301), "");  // 301
        assertEquals("Mediano", eMedBordeInf.categoriaEmail());

        Email eMedBordeSup = new Email("a".repeat(500), "");  // 500
        assertEquals("Mediano", eMedBordeSup.categoriaEmail());

        // Grande → <=0 o >=501
        Email eGrande = new Email("a".repeat(501), "");       // 501
        assertEquals("Grande", eGrande.categoriaEmail());
    }

    @Test
    void testContieneTexto() {
        Email email = new Email("Hola", "este es un test");
        assertTrue(email.contieneTexto("Hola"));
        assertTrue(email.contieneTexto("test"));
        assertFalse(email.contieneTexto("chau"));
    }

}
