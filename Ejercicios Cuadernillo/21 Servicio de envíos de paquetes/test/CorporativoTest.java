package ejercicio21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorporativoTest {
    private Corporativo corporativo;
    private DateLapse dateLapse;
    private Estandar estandar;
    private Local local;

    @BeforeEach
    void setUp() {
        estandar = new Estandar();
        local = new Local("dir123", "dir345", 100, LocalDate.of(2025, 4, 1), estandar);
        corporativo = new Corporativo("ori123", "des123", 2345);
        dateLapse = new DateLapse(LocalDate.of(2025, 2, 1), LocalDate.of(2025, 6, 8));
    }

    @Test
    void testSinEnvios() {
        assertEquals(0, corporativo.montoApagarDentroDeUnPeriodo(dateLapse));
    }

    @Test
    void testConEnvios() {
        corporativo.agregarEnvio(local);
        assertEquals(1000, corporativo.montoApagarDentroDeUnPeriodo(dateLapse));
    }
}
