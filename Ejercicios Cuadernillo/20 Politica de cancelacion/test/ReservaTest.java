package ejercicio20;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    @Test
    void testDentroDePeriodo() {
        DateLapse periodo1 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        DateLapse periodo2 = new DateLapse(LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 4));
        DateLapse periodo3 = new DateLapse(LocalDate.of(2025, 1, 6), LocalDate.of(2025, 1, 8));
        Flexible flexible= new Flexible();
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50,flexible);
        Reserva reserva = new Reserva(periodo1,inmueble);

        assertTrue(reserva.dentroDePeriodo(periodo1));  // mismo periodo
        assertFalse(reserva.dentroDePeriodo(periodo3)); // fuera de periodo
        assertTrue(reserva.dentroDePeriodo(periodo2)); //  dentro de periodo
    }

    @Test
    void testPrecioReserva() {
        DateLapse periodo = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5)); // 4 días
        Flexible flexible= new Flexible();
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50,flexible);
        Reserva reserva = new Reserva(periodo,inmueble);
        assertEquals(4 * 100, reserva.precioReserva(100.0));
    }

    @Test
    void testEnCurso() {
        DateLapse pasado = new DateLapse(LocalDate.now().minusDays(5), LocalDate.now().minusDays(2));
        DateLapse actual = new DateLapse(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        DateLapse futuro = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));
        Flexible flexible= new Flexible();
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50,flexible);
        assertFalse(new Reserva(pasado,inmueble).enCurso());
        assertTrue(new Reserva(actual,inmueble).enCurso());
        assertFalse(new Reserva(futuro,inmueble).enCurso());
    }

    @Test
    void testPuedeCancelar() {
        DateLapse pasado = new DateLapse(LocalDate.now().minusDays(5), LocalDate.now().minusDays(2));
        DateLapse futuro = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));
        Flexible flexible= new Flexible();
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50,flexible);

        assertFalse(new Reserva(pasado,inmueble).puedeCancelar());
        assertTrue(new Reserva(futuro,inmueble).puedeCancelar());
    }

    @Test
    void testPuedeCrear() {
        DateLapse pasado = new DateLapse(LocalDate.now().minusDays(5), LocalDate.now().minusDays(2));
        DateLapse futuro = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));
        Flexible flexible= new Flexible();
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50,flexible);

        assertFalse(new Reserva(pasado,inmueble).puedeCrear());
        assertTrue(new Reserva(futuro,inmueble).puedeCrear());
    }

    @Test
    void testEstaDentroDeLosUltimosXDiasAntesDelInicio() {
        Flexible flexible= new Flexible();
        Inmueble inmueble = new Inmueble("casa1","callefalsa123",50,flexible);

        // Fecha de inicio 5 días a futuro
        DateLapse futuro = new DateLapse(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));

        Reserva reservaFuturo = new Reserva(futuro,inmueble);

        // hoy está dentro de los últimos 6 días antes del inicio : true
        assertTrue(reservaFuturo.estaDentroDeLosUltimosXDiasAntesDelInicio(6));

        // hoy no está dentro de los últimos 3 días antes del inicio : false
        assertFalse(reservaFuturo.estaDentroDeLosUltimosXDiasAntesDelInicio(3));

        // fecha de inicio en el pasado.
        DateLapse pasado = new DateLapse(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        Reserva reservaPasado = new Reserva(pasado,inmueble);

        // hoy no puede estar dentro de los últimos X días antes del inicio : false
        assertFalse(reservaPasado.estaDentroDeLosUltimosXDiasAntesDelInicio(5));
    }

    @Test
    void testEquals() {
       Flexible flexible= new Flexible();
       Inmueble inmueble = new Inmueble("casa1","callefalsa123",50,flexible);

       DateLapse d1 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
       DateLapse d2 = new DateLapse(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
       DateLapse d3 = new DateLapse(LocalDate.of(2025, 1, 6), LocalDate.of(2025, 1, 8));

        Reserva r1 = new Reserva(d1,inmueble);
        Reserva r2 = new Reserva(d2,inmueble);
        Reserva r3 = new Reserva(d3,inmueble);

        assertTrue(r1.equals(r1));  // misma instancia
        assertTrue(r1.equals(r2));  // mismo contenido
        assertFalse(r1.equals(r3));  // diferente contenido
        assertFalse(r1.equals(null));   // null
        assertFalse(r1.equals("texto"));  // otro tipo
    }


}
