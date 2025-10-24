package ejercicio19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class InmuebleTest {
    private Usuario usuario1;
    private Usuario usuario2;
    private DateLapse dateLapse1;
    private DateLapse dateLapse2;
    private DateLapse dateLapse3;
    private DateLapse dateLapse4;
    private Inmueble inmueble1;
    private Inmueble inmueble2;
    private Inmueble inmueble3;
    private Reserva reserva1;
    private Reserva reserva2;
    private Reserva reserva3;

    @BeforeEach
    void setUp() {
        usuario1 = new Usuario("carlos", "23.455.789");
        usuario2 = new Usuario("pedro", "35.098.564");

        dateLapse1 = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(3)); // futuro
        dateLapse2 = new DateLapse(LocalDate.now(), LocalDate.now().plusDays(7)); // no solapa
        dateLapse3 = new DateLapse(LocalDate.now().minusDays(6), LocalDate.now().minusDays(3)); // pasado
        dateLapse4 = new DateLapse(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15));

        inmueble1 = new Inmueble("casa1", "calle123", 50);
        inmueble2 = new Inmueble("casa1","calle123",50);
        inmueble3 = new Inmueble("casa3","calle12345",50);

        reserva1 = new Reserva(dateLapse1,inmueble1);
        reserva2 = new Reserva(dateLapse3,inmueble2);
        reserva3 = new Reserva(dateLapse3,inmueble3);
    }

    @Test
    void testCrearReserva() {
        //periodo valido
        usuario1.agregarInmueble(inmueble1);
        inmueble1.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble1.getReservas().size());
        assertEquals(1, usuario2.getReservas().size());

        //periodo invalido
        inmueble1.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble1.getReservas().size());
        assertEquals(1, usuario2.getReservas().size());
    }

    @Test
    void testCancelarReserva() {
        usuario1.agregarInmueble(inmueble1);

        inmueble1.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble1.getReservas().size());
        inmueble1.cancelarReserva(reserva1, usuario2);
        // se cancela correctamente , la reserva no esta en curso y fecha de inicio de reserva es anterior al dia de hoy.
        assertEquals(0, inmueble1.getReservas().size());

        // no se crea por que la fecha de inicio de reserva ya paso.
        inmueble1.crearReserva(dateLapse3, usuario2);
        inmueble1.cancelarReserva(reserva2, usuario2);
        assertEquals(0, inmueble1.getReservas().size());

        // no se crea por que la fecha de reserva esta en curso
        inmueble1.crearReserva(dateLapse2, usuario2);
        inmueble1.cancelarReserva(reserva3, usuario2);
        assertEquals(0, inmueble1.getReservas().size());
    }

    @Test
    void testConsultarDisponibilidad() {
        usuario1.agregarInmueble(inmueble1);
        inmueble1.crearReserva(dateLapse1, usuario2);
        assertEquals(1, inmueble1.getReservas().size());

        assertFalse(inmueble1.consultarDisponibilidad(dateLapse1));
        assertTrue(inmueble1.consultarDisponibilidad(dateLapse4));
    }

    @Test
    void testRetribucionPropietario() {
        usuario1.agregarInmueble(inmueble1);
        DateLapse fecha1 = new DateLapse(LocalDate.of(2025, 1, 1).plusYears(5), LocalDate.of(2025, 1, 5).plusYears(5)); //4 dias
        DateLapse fecha2 = new DateLapse(LocalDate.of(2025, 1, 6).plusYears(5), LocalDate.of(2025, 1, 8).plusYears(5)); // 2 dias
        DateLapse fechaDada = new DateLapse(LocalDate.of(2025, 1, 1).plusYears(5), LocalDate.of(2025, 1, 8).plusYears(5));

        inmueble1.crearReserva(fecha1, usuario2);
        inmueble1.crearReserva(fecha2, usuario2);
        assertEquals(200, inmueble1.retribucionPropiertario(fecha1));
        assertEquals(300, inmueble1.retribucionPropiertario(fechaDada));
        assertEquals(0, inmueble1.retribucionPropiertario(dateLapse3));
    }

    @Test
    void testEquals() {

        // mismo contenido
        assertEquals(inmueble1, inmueble2);
        // diferente contenido
        assertNotEquals(inmueble2,inmueble3);
        // misma referencia
        assertEquals(inmueble1, inmueble1);
        // comparar con null
        assertNotEquals(inmueble1, null);
        // comparar con otro tipo
        assertNotEquals(inmueble1, "texto");
    }

}





