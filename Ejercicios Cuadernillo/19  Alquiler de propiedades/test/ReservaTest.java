package ejercicio19;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    @Test
    void testDentroDePeriodo() {
        DateLapse periodo1 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        DateLapse periodo2 = new DateLapse(LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 4));
        DateLapse periodo3 = new DateLapse(LocalDate.of(2025, 1, 6), LocalDate.of(2025, 1, 8));
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50);
        Reserva reserva = new Reserva(periodo1,inmueble);

        assertTrue(reserva.dentroDePeriodo(periodo1));  // mismo periodo
        assertFalse(reserva.dentroDePeriodo(periodo3)); // fuera de periodo
        assertTrue(reserva.dentroDePeriodo(periodo2)); //  dentro de periodo
    }

    @Test
    void testPrecioReserva() {
        DateLapse periodo = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5)); // 4 días
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50);
        Reserva reserva = new Reserva(periodo,inmueble);
        assertEquals(4 * 50, reserva.precioReserva());
    }

    @Test
    void testEnCurso() {
        Inmueble inmueble1 = new Inmueble("casa1","calle123",50);
        Inmueble inmueble2 = new Inmueble("casa1","calle123",50);
        Inmueble inmueble3 = new Inmueble("casa1","calle123",50);
        DateLapse pasado = new DateLapse(LocalDate.now().minusDays(5), LocalDate.now().minusDays(2));
        DateLapse actual = new DateLapse(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        DateLapse futuro = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));

        assertFalse(new Reserva(pasado,inmueble1).enCurso());
        assertTrue(new Reserva(actual,inmueble2).enCurso());
        assertFalse(new Reserva(futuro,inmueble3).enCurso());
    }

    @Test
    void testPuedeCancelar() {
        Inmueble inmueble1 = new Inmueble("casa1","calle123",50);
        Inmueble inmueble2 = new Inmueble("casa1","calle123",50);
        DateLapse pasado = new DateLapse(LocalDate.now().minusDays(5), LocalDate.now().minusDays(2));
        DateLapse futuro = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));

        assertFalse(new Reserva(pasado,inmueble1).puedeCancelar());
        assertTrue(new Reserva(futuro,inmueble2).puedeCancelar());
    }

    @Test
    void testPuedeCrear() {
        Inmueble inmueble1 = new Inmueble("casa1","calle123",50);
        Inmueble inmueble2 = new Inmueble("casa1","calle123",50);
        DateLapse pasado = new DateLapse(LocalDate.now().minusDays(5), LocalDate.now().minusDays(2));
        DateLapse futuro = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));

        assertFalse(new Reserva(pasado,inmueble1).puedeCrear());
        assertTrue(new Reserva(futuro,inmueble2).puedeCrear());
    }

    @Test
    void testEquals() {
        Inmueble inmueble1 = new Inmueble("casa1","calle123",50);
        Inmueble inmueble2 = new Inmueble("casa1","calle123",50);
        Inmueble inmueble3 = new Inmueble("casa1","calle123",50);
        DateLapse d1 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        DateLapse d2 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        DateLapse d3 = new DateLapse(LocalDate.of(2025, 1, 6), LocalDate.of(2025, 1, 8));

        Reserva r1 = new Reserva(d1,inmueble1);
        Reserva r2 = new Reserva(d2,inmueble2);
        Reserva r3 = new Reserva(d3,inmueble3);

        assertTrue(r1.equals(r1));  // misma instancia
        assertTrue(r1.equals(r2));  // mismo contenido
        assertFalse(r1.equals(r3));  // diferente contenido
        assertFalse(r1.equals(null));   // null
        assertFalse(r1.equals("texto"));  // otro tipo
    }

}
