package ejercicio21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalTest {
    private PersonaFisica personaFisica;

    private Local localEstandar;
    private Local localRapido;

    private Estandar estandar;
    private Rapida rapida;


    @BeforeEach
    void setup() {
        personaFisica = new PersonaFisica("Pedro", "calle123", 123);

        estandar = new Estandar();
        rapida = new Rapida();

        localEstandar = new Local("origen123", "destino234", 100, LocalDate.of(2025, 8, 1), estandar);
        localRapido = new Local("origen666", "destino444", 200, LocalDate.of(2025, 8, 1), rapida);

    }

    @Test
    void testCostoPersonaFisicaEntregaEstandar() {
        personaFisica.agregarEnvio(localEstandar);
        assertEquals(1000, localEstandar.costo());
    }

    @Test
    void testCostoPersonaFisicaEntregarRapida() {
        personaFisica.agregarEnvio(localRapido);
        assertEquals(500, localRapido.costo());
    }

}
