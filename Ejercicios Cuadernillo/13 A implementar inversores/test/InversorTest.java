package ejercicio13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class InversorTest {

    private Inversor inversor;
    private Accion accion;
    private PlazoFijo plazoFijo;

    @BeforeEach
    void setUp(){
        inversor = new Inversor();
    }

    @Test
    void testValorTotalActualDeInversionesSinInversionesTest(){
        assertEquals(0,inversor.valorTotalActualDeInversiones(), 0.001);
    }

    @Test
    void testValorTotalActualDeInversionesConUnaInversion(){
        accion = new Accion("nombre",1,10);
        inversor.agregarInversion(accion);
        assertEquals(10,inversor.valorTotalActualDeInversiones(), 0.001);
    }

    @Test
    void testValorTotalActualDeInversionesConDosInversiones(){
        accion = new Accion("nombre",1,10);
        inversor.agregarInversion(accion);
        plazoFijo = new PlazoFijo(LocalDate.now(),10,0.10);
        inversor.agregarInversion(plazoFijo);
        assertEquals(20,inversor.valorTotalActualDeInversiones(),0.001);
    }
}
