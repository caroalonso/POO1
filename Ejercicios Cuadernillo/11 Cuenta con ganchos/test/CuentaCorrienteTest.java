package ejercicio11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    private CuentaCorriente cuenta;
    private CuentaCorriente origen;
    private CuentaCorriente destino;

    @BeforeEach
    void setUp(){
        cuenta = new CuentaCorriente(0);
        origen = new CuentaCorriente(0);
        destino = new CuentaCorriente(0);
    }

    @Test
    void testDepositoAumentaSaldo() {
        assertTrue(cuenta.depositar(100));
        assertEquals(100, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testExtraccionDentroDelSaldoDisponible() {
        cuenta.depositar(200);
        assertTrue(cuenta.extraer(200)); // al límite exacto
        assertEquals(0, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testExtraccionConDescubiertoJustoEnElLimite() {
        cuenta.depositar(100);
        cuenta.setDescubierto(10);

        assertTrue(cuenta.extraer(110)); // justo hasta el límite
        assertEquals(-10, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testExtraccionSuperaDescubiertoPorUnPeso() {
        cuenta.depositar(100);
        cuenta.setDescubierto(10);

        assertFalse(cuenta.extraer(111)); // se pasa por 1
        assertEquals(100, cuenta.getSaldo(), 0.001); // no debe cambiar
    }

    @Test
    void testTransferenciaExitosaJustoEnElLimite() {
        origen.depositar(100);
        origen.setDescubierto(10);

        assertTrue(origen.tranferirAcuenta(110, destino));
        assertEquals(-10, origen.getSaldo(), 0.001);
        assertEquals(110, destino.getSaldo(), 0.001);
    }

    @Test
    void testTransferenciaNoPermitidaPorSuperarElLimite() {
        origen.depositar(100);
        origen.setDescubierto(10);

        assertFalse(origen.tranferirAcuenta(111, destino)); // se pasa por 1
        assertEquals(100, origen.getSaldo(), 0.001); // origen no cambia
        assertEquals(0, destino.getSaldo(), 0.001);   // destino no recibe nada
    }
}


