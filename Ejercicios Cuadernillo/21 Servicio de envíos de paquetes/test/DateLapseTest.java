package ejercicio21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateLapseTest {

    private LocalDate inicio;
    private LocalDate fin;
    private DateLapse dateLapse;

    @BeforeEach
    void setUp() {
        inicio = LocalDate.of(2025, 3, 1);
        fin = LocalDate.of(2025, 4, 1);
        dateLapse = new DateLapse(inicio, fin);
    }

    @Test
    void testFueraDeRango() {
        DateLapse fueraDeRango = new DateLapse(LocalDate.of(2025, 2, 1), LocalDate.of(2025, 2, 6));
        assertFalse(dateLapse.overlaps(fueraDeRango));
    }

    @Test
    void testLimiteInferior() {
        DateLapse limiteInferior = new DateLapse(LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 1));
        assertTrue(dateLapse.overlaps(limiteInferior));
    }

    @Test
    void testLimiteSuperior() {
        DateLapse limiteSuperior = new DateLapse(LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 1));
        assertTrue(dateLapse.overlaps(limiteSuperior));
    }

    @Test
    void testEntreRango() {
        DateLapse entreRango = new DateLapse(LocalDate.of(2025, 3, 8), LocalDate.of(2025, 3, 23));
        assertTrue(dateLapse.overlaps(entreRango));
    }

}
