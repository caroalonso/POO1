package ejercicio21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternacionalTest {
    private PersonaFisica personaFisica;

    private Internacional internacionalEstandarMenorAkilo;
    private Internacional internacionalEstandarIgualAkilo;
    private Internacional internacionalEstandarMayorAkilo;

    private Internacional internacionalRapidoMenorAkilo;
    private Internacional internacionalRapidoIgualAkilo;
    private Internacional internacionalRapidoMayorAkilo;

    private Estandar estandar;
    private Rapida rapida;

    @BeforeEach
    void setup() {
        personaFisica = new PersonaFisica("Pedro", "calle123", 123);

        estandar = new Estandar();
        rapida = new Rapida();

        internacionalEstandarMenorAkilo = new Internacional("origen123", "destino234", 100, LocalDate.of(2025, 8, 1), estandar);
        internacionalEstandarIgualAkilo = new Internacional("origen123", "destino234", 1000, LocalDate.of(2025, 8, 1), estandar);
        internacionalEstandarMayorAkilo = new Internacional("origen123", "destino234", 1100, LocalDate.of(2025, 8, 1), estandar);

        internacionalRapidoMenorAkilo = new Internacional("origen666", "destino444", 100, LocalDate.of(2025, 8, 1), rapida);
        internacionalRapidoIgualAkilo = new Internacional("origen666", "destino444", 1000, LocalDate.of(2025, 8, 1), rapida);
        internacionalRapidoMayorAkilo = new Internacional("origen666", "destino444", 1100, LocalDate.of(2025, 8, 1), rapida);
    }

    @Test
    void testCostoPersonaFisicaEntregaEstandarMenorAkilo() {
        personaFisica.agregarEnvio(internacionalEstandarMenorAkilo);
        assertEquals(6000, internacionalEstandarMenorAkilo.costo());
    }

    @Test
    void testCostoPersonaFisicaEntregaEstandarIgualAkilo() {
        personaFisica.agregarEnvio(internacionalEstandarIgualAkilo);
        assertEquals(15000, internacionalEstandarIgualAkilo.costo());
    }

    @Test
    void testCostoPersonaFisicaEntregaEstandarMayorAkilo() {
        personaFisica.agregarEnvio(internacionalEstandarMayorAkilo);
        assertEquals(18200, internacionalEstandarMayorAkilo.costo());
    }


    @Test
    void testCostoPersonaFisicaEntregarRapidaMenorAkilo() {
        personaFisica.agregarEnvio(internacionalRapidoMenorAkilo);
        assertEquals(6800, internacionalRapidoMenorAkilo.costo());
    }

    @Test
    void testCostoPersonaFisicaEntregarRapidaIgualAkilo() {
        personaFisica.agregarEnvio(internacionalRapidoIgualAkilo);
        assertEquals(15800, internacionalRapidoIgualAkilo.costo());
    }

    @Test
    void testCostoPersonaFisicaEntregarRapidaMayorAkilo() {
        personaFisica.agregarEnvio(internacionalRapidoMayorAkilo);
        assertEquals(19000, internacionalRapidoMayorAkilo.costo());
    }


}
