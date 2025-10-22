package ejercicio11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CajaAhorroTest {

    private CajaAhorro caja;
    private CajaAhorro origen;
    private CajaAhorro destino;

    @BeforeEach
    void setUp() {
        caja = new CajaAhorro(0);
        origen = new CajaAhorro(0);
        destino = new CajaAhorro(0);
    }

    @Test
    void testDepositoCon2PorcientoDescuento() {
        assertTrue(caja.depositar(100));
        assertEquals(98, caja.getSaldo(), 0.001); // entra con 2% menos
    }

    @Test
    void testDepositoNegativoNoSeAcepta() {
        assertFalse(caja.depositar(-50));
        assertEquals(0, caja.getSaldo(), 0.001);
    }

    @Test
    void testExtraccionJustoEnElLimite() {
        // Necesito 102 para poder sacar 100
        caja = new CajaAhorro(102);
        assertTrue(caja.extraer(100));
        assertEquals(0, caja.getSaldo(), 0.001);
    }

    @Test
    void testExtraccionSuperaLimitePorUnPeso() {
        // Tengo 101 → no alcanza para extraer 100 (necesita 102)
        caja = new CajaAhorro(101);
        assertFalse(caja.extraer(100));
        assertEquals(101, caja.getSaldo(), 0.001); // no cambia
    }

    @Test
    void testTransferenciaExitosaJustoEnElLimite() {
        // Origen: tiene 102 → puede transferir 100 (se descuenta 102)
        origen = new CajaAhorro(102);

        assertTrue(origen.tranferirAcuenta(100, destino));
        // Origen: se descuenta 102
        assertEquals(0, origen.getSaldo(), 0.001);
        // Destino: recibe depósito con 2% menos → 98
        assertEquals(98, destino.getSaldo(), 0.001);
    }

    @Test
    void testTransferenciaNoPermitidaPorFondosInsuficientes() {
        // Origen: tiene 101 → no alcanza para transferir 100 (se necesitarían 102)
        origen = new CajaAhorro(101);

        assertFalse(origen.tranferirAcuenta(100, destino));
        assertEquals(101, origen.getSaldo(), 0.001); // no cambia
        assertEquals(0, destino.getSaldo(), 0.001);  // no recibe nada
    }
}
