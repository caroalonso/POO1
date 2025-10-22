package ejercicio13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccionTest {

    private Accion accion;

    @Test
    void testValorActualConDatosValidos() {
        accion = new Accion("nombre",2,10);
        assertEquals(20,accion.valorActualInversion(),0.001);
    }

    @Test
    void testValorActualConDatosValidosDecimal() {
        accion = new Accion("nombre",2,100.25);
        assertEquals(200.50,accion.valorActualInversion(),0.001);
    }

}
