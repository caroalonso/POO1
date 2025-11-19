package ejercicio29Bag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndividualTest {

    private Cliente cliente;
    private Individual individual;
    private SesionJuegos sesionJuegos1;
    private SesionJuegos sesionJuegos2;

    @BeforeEach
    void setUp() {
        individual = new Individual(40);
        cliente = new Cliente("Pedro", individual);

        sesionJuegos1 = new SesionJuegos("1", 30);
        sesionJuegos2 = new SesionJuegos("2", 30);
    }

    @Test
    void ipSinPenalizacion(){
        assertEquals(0, cliente.getPlan().penalizacionPlan(cliente.cantidadDeIpsUtilizadas()));
    }

    @Test
    void ipConPenalizacion(){
        cliente.agregarActividad(sesionJuegos1);
        cliente.agregarActividad(sesionJuegos2);
        assertEquals(300, cliente.getPlan().penalizacionPlan(cliente.cantidadDeIpsUtilizadas()));
    }
}
