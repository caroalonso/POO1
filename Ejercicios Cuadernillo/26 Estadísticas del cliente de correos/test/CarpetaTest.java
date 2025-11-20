package ejercicio26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarpetaTest {

    @Test
    void testAgregarYBuscarEmailEnCarpeta() {
        Carpeta carpeta = new Carpeta("Trabajos");
        Email email = new Email("Informe", "Reunión");
        carpeta.agregarEmail(email);

        assertEquals(email, carpeta.buscar("Informe"));
        assertEquals(email, carpeta.buscar("Reunión"));
        assertNull(carpeta.buscar("Nada"));
    }

    @Test
    void testEspacioOcupadoCarpeta() {
        Carpeta carpeta = new Carpeta("Carpeta 1");

        Email e1 = new Email("Hola", "mundo");
        Email e2 = new Email("Java", "JUnit");

        carpeta.agregarEmail(e1);
        carpeta.agregarEmail(e2);

        int esperado = (4+5) + (4+4);
        assertEquals(esperado, carpeta.espacioOcupado());
    }

    @Test
    void testCantidadEmails() {
        Carpeta carpeta = new Carpeta("Inbox");
        carpeta.agregarEmail(new Email("a", "b"));
        carpeta.agregarEmail(new Email("c", "d"));

        assertEquals(2, carpeta.cantidadEmails());
    }

    @Test
    void testCategoriasTamanio() {
        Carpeta carpeta = new Carpeta("Inbox");

        Email e1 = new Email("a".repeat(50), "");   // 50 → Pequeño
        Email e2 = new Email("a".repeat(350), "");  // 350 → Mediano
        Email e3 = new Email("a".repeat(700), "");  // 700 → Grande
        Email e4 = new Email("a".repeat(700), "");  // Otra Grande

        carpeta.agregarEmail(e1);
        carpeta.agregarEmail(e2);
        carpeta.agregarEmail(e3);
        carpeta.agregarEmail(e4);

        Bag<String> bag = carpeta.categoriasTamanio();

        assertEquals(1, bag.occurrencesOf("Pequeño"));
        assertEquals(1, bag.occurrencesOf("Mediano"));
        assertEquals(2, bag.occurrencesOf("Grande"));
        assertEquals(3, bag.sizeUnique()); // Pequeño, Mediano, Grande
    }

}
