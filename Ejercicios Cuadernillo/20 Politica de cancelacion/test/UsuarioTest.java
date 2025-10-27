package ejercicio20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    private Usuario usuario1;
    private Usuario usuario2;
    private Inmueble inmueble;
    private Reserva reserva;
    private DateLapse dateLapse1;
    private DateLapse dateLapse2;
    private DateLapse dateLapse3;
    private Flexible flexible;

    @BeforeEach
    void setUp() {
        usuario1 = new Usuario("Juan", "22.222.222");
        usuario2 = new Usuario("Ignacio", "33.333.333");

        dateLapse3 = new DateLapse(LocalDate.of(2024, 12, 29), LocalDate.of(2024, 12, 31));
        dateLapse1 = new DateLapse(LocalDate.of(2025, 1, 1).plusYears(5), LocalDate.of(2025, 1, 5).plusYears(5)); //4 dias
        dateLapse2 = new DateLapse(LocalDate.of(2025, 1, 6), LocalDate.of(2025, 1, 8));
        flexible = new Flexible();
        inmueble = new Inmueble("casa1", "calle123", 50, flexible);
        reserva = new Reserva(dateLapse1,inmueble);
    }

    @Test
    void testAgregarInmueble() {
        this.usuario1.agregarInmueble(inmueble);
        assertTrue(this.usuario1.getInmuebles().contains(inmueble));
    }

    @Test
    void testEliminarInmueble() {
        this.usuario1.agregarInmueble(inmueble);
        this.usuario1.eliminarInmueble(inmueble);
        assertFalse(this.usuario1.getInmuebles().contains(inmueble));
    }

    @Test
    void testAgregarReserva() {
        this.usuario1.agregarReserva(reserva);
        assertTrue(this.usuario1.getReservas().contains(reserva));
    }

    @Test
    void testCancelarReserva() {
        this.usuario1.agregarReserva(reserva);
        this.usuario1.cancelarReserva(reserva);
        assertFalse(this.usuario1.getReservas().contains(reserva));
    }

    @Test
    void testRetribucionPropietario() {
        this.usuario1.agregarInmueble(inmueble);
        inmueble.crearReserva(dateLapse1, usuario2);
        assertEquals(0, this.usuario1.retribucionPropietario(dateLapse2));
        assertEquals(150, this.usuario1.retribucionPropietario(dateLapse1)); // 4 dias
        assertEquals(0, this.usuario1.retribucionPropietario(dateLapse3));
    }
}
