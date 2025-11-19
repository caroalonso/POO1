package ejercicio29Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    private Cliente cliente;
    private Cliente cliente2;
    private Individual individual;
    private Grupal grupal;
    private SesionJuegos sesionJuegos1;
    private SesionJuegos sesionJuegos2;
    private SesionJuegos sesionJuegos3;
    private SesionJuegos sesionJuegos4;

    @BeforeEach
    void setUp() {
        individual = new Individual(40);
        cliente = new Cliente("Pedro", individual);

        sesionJuegos1 = new SesionJuegos("1", 30);
        sesionJuegos2 = new SesionJuegos("2", 30);
        sesionJuegos3 = new SesionJuegos("3", 30);
        sesionJuegos4 = new SesionJuegos("4", 30);

        grupal= new Grupal(3);
        cliente2= new Cliente("Carlos",grupal);

    }

    // periodo < a 10 años Plan Individual Sin Penalizacion = 0
    @Test
    void testMenosA10PlanIndividualSinPenalizacion() {
        assertEquals(0, cliente.penalizacion());
    }
    // periodo < 10 años Plan Individual Con Penalizacion = 300
    @Test
    void testMenosA10PlanIndividualConPenalizacion() {
        cliente.agregarActividad(sesionJuegos1);
        cliente.agregarActividad(sesionJuegos2);
        assertEquals(300, cliente.penalizacion());
    }
    // periodo < 10 años plan Grupal sin penalizacion = 0
    @Test
    void testMasA10PlanGrupalSinPenalizacion() {
        assertEquals(0, cliente2.penalizacion());
    }
    // periodo < 10 años plan Grupa con penalizacion = 500
    @Test
    void testMenosA10PlanGrupalConPenalizacion() {
        cliente2.agregarActividad(sesionJuegos1);
        cliente2.agregarActividad(sesionJuegos2);
        cliente2.agregarActividad(sesionJuegos3);
        cliente2.agregarActividad(sesionJuegos4);
        assertEquals(500, cliente2.penalizacion());
    }



    // periodo = 10 años Plan Individual Sin Penalizacion = 0
    @Test
    void testIgualA10PlanIndividualSinPenalizacion() {
        cliente.setFechaAlta(cliente.getFecha().minusYears(10));
        assertEquals(0, cliente.penalizacion());
    }
    // periodo = 10 años plan Individual con penalizacion = 300
    @Test
    void testIgualA10AniosPlanIndividualConPenalizacion() {
        cliente.agregarActividad(sesionJuegos1);
        cliente.agregarActividad(sesionJuegos2);
        assertEquals(300, cliente.penalizacion());
    }
    // periodo = 10 años Plan GrupaL Sin Penalizacion = 0
    @Test
    void testIgualA10AniosPlanGrupalSinPenalizacion() {
        cliente.setFechaAlta(cliente2.getFecha().minusYears(10));
        assertEquals(0, cliente2.penalizacion());
    }
    // periodo = 10 años Plan Grupal Con Penalizacion = 500
    @Test
    void testIgualA10AniosPlanGrupalConPenalizacion() {
        cliente2.agregarActividad(sesionJuegos1);
        cliente2.agregarActividad(sesionJuegos2);
        cliente2.agregarActividad(sesionJuegos3);
        cliente2.agregarActividad(sesionJuegos4);
        assertEquals(500, cliente2.penalizacion());
    }



    // periodo > 10 años Plan Individual sin penalizacion = 0
    @Test
    void testClienteMenorA10AniosPlanIndividualPenalizacionCero() {
        cliente.setFechaAlta(cliente.getFecha().minusYears(11));
        assertEquals(0, cliente.penalizacion());
    }

    // periodo > 10 años Plan Grupa sin penalizacion = 0
    @Test
    void testClienteMenorA10AniosPlanGrupalPenalizacionCero() {
        cliente.setFechaAlta(cliente2.getFecha().minusYears(11));
        assertEquals(0, cliente2.penalizacion());
    }

}
