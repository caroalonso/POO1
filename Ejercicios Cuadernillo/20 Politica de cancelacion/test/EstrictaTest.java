package ejercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EstrictaTest {

    private Estricta politica;
    private Inmueble inmueble;
    private Usuario usuario;
    private DateLapse periodo1;

    @BeforeEach
    void setUp() {

        politica = new Estricta();
        inmueble = new Inmueble("Casa amarilla", "Calle123", 100, politica);
        usuario = new Usuario("Carlos", "23.675.435");
        periodo1 = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(4));
    }

    @Test
    void testReembolso() {
        inmueble.crearReserva(periodo1, usuario);
        Reserva reserva = usuario.getReservas().iterator().next();
        assertEquals(0, inmueble.cancelarReserva(reserva, usuario));
        inmueble.cancelarReserva(reserva, usuario);
        assertFalse(inmueble.getReservas().contains(reserva));
    }
}
