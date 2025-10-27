package ejercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InmuebleTest {
    private Usuario usuario1;
    private Usuario usuario2;
    private DateLapse dateLapse1;
    private DateLapse dateLapse2;
    private DateLapse dateLapse3;
    private DateLapse dateLapse4;
    private Inmueble inmueble;
    private Reserva reserva1;
    private Reserva reserva2;
    private Reserva reserva3;
    private Moderada moderada;
    private Flexible flexible;

    @BeforeEach
    void setUp() {
        usuario1 = new Usuario("carlos", "23.455.789");
        usuario2 = new Usuario("pedro", "35.098.564");

        dateLapse1 = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3)); // futuro
        dateLapse2 = new DateLapse(LocalDate.now(), LocalDate.now().plusDays(7)); // no solapa
        dateLapse3 = new DateLapse(LocalDate.now().minusDays(6), LocalDate.now().minusDays(3)); // pasado
        dateLapse4 = new DateLapse(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));

        moderada = new Moderada();
        flexible = new Flexible();
        inmueble = new Inmueble("casa1", "calle123", 50, moderada);

        reserva1 = new Reserva(dateLapse1,inmueble);
        reserva2 = new Reserva(dateLapse3,inmueble);
        reserva3 = new Reserva(dateLapse3,inmueble);
    }

    @Test
    void testCrearReserva() {
        //periodo valido
        usuario1.agregarInmueble(inmueble);
        inmueble.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble.getReservas().size());
        assertEquals(1, usuario2.getReservas().size());

        //periodo invalido
        inmueble.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble.getReservas().size());
        assertEquals(1, usuario2.getReservas().size());
    }

    @Test
    void testPoliticaCancelacion() {
        assertEquals(moderada, inmueble.getPoliticaCancelacion());
        inmueble.setPoliticaCancelacion(flexible);
        assertEquals(flexible, inmueble.getPoliticaCancelacion());
    }

    @Test
    void testCancelarReserva() {
        usuario1.agregarInmueble(inmueble);

        inmueble.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble.getReservas().size());
        inmueble.cancelarReserva(reserva1, usuario2);
        // se cancela correctamente , la reserva no esta en curso y fecha de inicio de reserva es anterior al dia de hoy.
        assertEquals(0, inmueble.getReservas().size());

        // no se crea por que la fecha de inicio de reserva ya paso.
        inmueble.crearReserva(dateLapse3, usuario2);
        inmueble.cancelarReserva(reserva2, usuario2);
        assertEquals(0, inmueble.getReservas().size());

        // no se crea por que la fecha de reserva esta en curso
        inmueble.crearReserva(dateLapse2, usuario2);
        inmueble.cancelarReserva(reserva3, usuario2);
        assertEquals(0, inmueble.getReservas().size());
    }

    @Test
    void testConsultarDisponibilidad() {
        usuario1.agregarInmueble(inmueble);
        inmueble.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble.getReservas().size());

        assertFalse(inmueble.consultarDisponibilidad(dateLapse1));
        assertTrue(inmueble.consultarDisponibilidad(dateLapse4));
    }

    @Test
    void testRetribucionPropietario() {
        usuario1.agregarInmueble(inmueble);
        DateLapse fecha1 = new DateLapse(LocalDate.of(2025, 1, 1).plusYears(5), LocalDate.of(2025, 1, 5).plusYears(5)); //4 dias
        DateLapse fecha2 = new DateLapse(LocalDate.of(2025, 1, 6).plusYears(5), LocalDate.of(2025, 1, 8).plusYears(5)); // 2 dias
        DateLapse fechaDada = new DateLapse(LocalDate.of(2025, 1, 1).plusYears(5), LocalDate.of(2025, 1, 8).plusYears(5));

        inmueble.crearReserva(fecha1, usuario2);
        inmueble.crearReserva(fecha2, usuario2);
        assertEquals(200, inmueble.retribucionPropiertario(fecha1));
        assertEquals(300, inmueble.retribucionPropiertario(fechaDada));
        assertEquals(0, inmueble.retribucionPropiertario(dateLapse3));
    }

    @Test
    void testEquals() {
        Inmueble casa1 = new Inmueble("Casa1", "Calle123", 50, moderada);
        Inmueble casa2 = new Inmueble("Casa1", "Calle123", 50, moderada);
        Inmueble casa3 = new Inmueble("Casa2", "Calle456", 600, flexible);

        // mismo contenido
        assertEquals(casa1, casa2);
        // diferente contenido
        assertNotEquals(casa2, casa3);
        // misma referencia
        assertEquals(casa1, casa1);
        // comparar con null
        assertNotEquals(casa1, null);
        // comparar con otro tipo
        assertNotEquals(casa1, "texto");
    }

}


