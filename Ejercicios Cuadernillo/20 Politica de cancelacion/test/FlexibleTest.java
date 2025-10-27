package ejercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FlexibleTest {

    private Flexible politica;
    private Inmueble inmueble;
    private Usuario usuario;
    private DateLapse periodo1;
    private DateLapse periodo2;

    @BeforeEach
    void setUp() {
        politica = new Flexible();
        inmueble = new Inmueble("Casa amarilla", "Calle123", 100, politica);
        usuario = new Usuario("Carlos", "23.675.435");
        periodo1 = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(5));
        periodo2 = new DateLapse(LocalDate.now(), LocalDate.now().plusDays(3));
    }

    @Test
    void testReembolsoCuandoPuedeCancelar() {
        inmueble.crearReserva(periodo1, usuario);
        Reserva reserva = usuario.getReservas().iterator().next();
        assertEquals(400, inmueble.cancelarReserva(reserva, usuario));
        inmueble.cancelarReserva(reserva, usuario);
        assertFalse(inmueble.getReservas().contains(reserva));
    }

    @Test
    void testReembolsoCuandoNoPuedeCancelar() {

        // Creo la reserva manualmente.
        Reserva reserva = new Reserva(periodo2,inmueble);
        // agrego la reserva al inmueble y al usuario
        inmueble.getReservas().add(reserva);
        usuario.agregarReserva(reserva);
        // Intentar cancelar pero como la reserva ya está en curso, no se puede cancelar
        assertEquals(0, inmueble.cancelarReserva(reserva, usuario));
    }

}
