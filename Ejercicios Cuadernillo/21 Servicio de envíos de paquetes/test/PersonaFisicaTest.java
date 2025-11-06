package ejercicio21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaFisicaTest {
    private PersonaFisica personaFisica;
    private DateLapse dateLapse;
    private Estandar estandar;
    private Local local;

    @BeforeEach
    void setUp() {
        estandar = new Estandar();
        local = new Local("dir123", "dir345", 100, LocalDate.of(2025, 4, 1), estandar);
        personaFisica = new PersonaFisica("ori123", "des123", 2345);
        dateLapse = new DateLapse(LocalDate.of(2025, 2, 1), LocalDate.of(2025, 6, 8));
    }

    @Test
    void testSinEnvios() {
        assertEquals(0, personaFisica.montoApagarDentroDeUnPeriodo(dateLapse));
    }

    @Test
    void testConEnvios() {
        personaFisica.agregarEnvio(local);
        assertEquals(900, personaFisica.montoApagarDentroDeUnPeriodo(dateLapse));
    }

}
