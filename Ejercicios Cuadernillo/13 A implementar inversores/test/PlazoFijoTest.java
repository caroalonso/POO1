package ejercicio13;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PlazoFijoTest {
    private PlazoFijo plazoFijo;

    @Test
    void testValorActualInversionUnDia() {
        plazoFijo = new PlazoFijo(LocalDate.now(), 100, 0.10);
        assertEquals(100, plazoFijo.valorActualInversion(), 0.001);
    }

    @Test
    void testValorActualInversionMasDeUnDia() {
        plazoFijo = new PlazoFijo(LocalDate.now().minusDays(1), 100, 0.10);
        assertEquals(110, plazoFijo.valorActualInversion(), 0.001);
    }


}
