package ejercicio21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterurbanoTest {
    private PersonaFisica personaFisica;
    private Interurbano interurbanoMenorACien;
    private Interurbano interurbanoIgualACien;
    private Interurbano interurbanoEntreCienyQuinientos;
    private Interurbano interurbanoIgualAQuinientos;
    private Interurbano interurbanoMayorAquinientos;

    @BeforeEach
    void setup() {
        personaFisica = new PersonaFisica("Pedro", "calle123", 123);

        interurbanoMenorACien = new Interurbano("origen123", "destino234", 10, LocalDate.of(2025, 8, 1), 99);
        interurbanoIgualACien = new Interurbano("origen123", "destino234", 10, LocalDate.of(2025, 8, 1), 100);
        interurbanoEntreCienyQuinientos = new Interurbano("origen123", "destino234", 10, LocalDate.of(2025, 8, 1), 101);
        interurbanoIgualAQuinientos = new Interurbano("origen123", "destino234", 10, LocalDate.of(2025, 8, 1), 500);
        interurbanoMayorAquinientos = new Interurbano("origen123", "destino234", 10, LocalDate.of(2025, 8, 1), 501);
    }

    @Test
    void testInterurbanoMenorAcien (){
        personaFisica.agregarEnvio(interurbanoMenorACien);
        assertEquals(200,interurbanoMenorACien.costo());
    }

    @Test
    void testInterurbanoIgualAcien(){
        personaFisica.agregarEnvio(interurbanoIgualACien);
        assertEquals(250,interurbanoIgualACien.costo());
    }

    @Test
    void testInterurbanoEntreCienyQuinientos  (){
        personaFisica.agregarEnvio(interurbanoEntreCienyQuinientos);
        assertEquals(250,interurbanoEntreCienyQuinientos.costo());
    }

    @Test
    void testInterurbanogualAQuinientos (){
        personaFisica.agregarEnvio(interurbanoEntreCienyQuinientos);
        assertEquals(250,interurbanoEntreCienyQuinientos.costo());
    }

    @Test
    void testInterurbanoMayorAquinientos (){
        personaFisica.agregarEnvio(interurbanoMayorAquinientos);
        assertEquals(300,interurbanoMayorAquinientos.costo());
    }

    }
