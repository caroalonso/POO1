package ejercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModeradaTest {

    private Moderada politica;
    private Inmueble inmueble;
    private Usuario usuario;
    private DateLapse periodo1;
    private DateLapse periodo2;
    private DateLapse periodo3;

    @BeforeEach
    void setUp() {
        politica = new Moderada();
        inmueble = new Inmueble("Casa Azul", "Av. 123", 100, politica);
        usuario = new Usuario("Laura", "32.456.789");
        periodo1 = new DateLapse(LocalDate.now().plusDays(7), LocalDate.now().plusDays(12));
        periodo2 = new DateLapse(LocalDate.now().minusDays(3), LocalDate.now().plusDays(5));
        periodo3 = new DateLapse(LocalDate.now().plusDays(2), LocalDate.now().plusDays(4));
    }

    // 1: dentro de la semana anterior de inicio retorna 100%
    @Test
    void testReembolsoCienPorCiento() {
        inmueble.crearReserva(periodo1, usuario);
        Reserva reserva = usuario.getReservas().iterator().next();
        assertEquals(500, inmueble.cancelarReserva(reserva, usuario));
    }

    // 2: reserva en curso retorna 0
    @Test
    void testReembolsoCero() {
        // Creo la reserva manualmente.
        Reserva reserva = new Reserva(periodo2,inmueble);
        // agrego la reserva al inmueble y al usuario
        inmueble.getReservas().add(reserva);
        usuario.agregarReserva(reserva);
        // Intentar cancelar pero como la reserva ya está en curso, no se puede cancelar
        assertEquals(0, inmueble.cancelarReserva(reserva, usuario));
    }

    // 3: 2 día antes del inicio retorna 50%
    @Test
    void testReembolso50PorCiento() {
        inmueble.crearReserva(periodo3, usuario);
        Reserva reserva = usuario.getReservas().iterator().next();
        assertEquals(100, inmueble.cancelarReserva(reserva, usuario));
    }

}

