package ejercicio29Bag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupalTest {

    private Cliente cliente2;
    private Grupal grupal;
    private SesionJuegos sesionJuegos1;
    private SesionJuegos sesionJuegos2;
    private SesionJuegos sesionJuegos3;
    private SesionJuegos sesionJuegos4;


    @BeforeEach
    void setUp() {
        grupal= new Grupal(3);
        cliente2= new Cliente("Carlos",grupal);

        sesionJuegos1 = new SesionJuegos("1", 30);
        sesionJuegos2 = new SesionJuegos("2", 30);
        sesionJuegos3 = new SesionJuegos("3", 30);
        sesionJuegos4 = new SesionJuegos("4", 30);

    }

    @Test
    void ipSinPenalizacion(){
        assertEquals(0, cliente2.getPlan().penalizacionPlan(cliente2.cantidadDeIpsUtilizadas()));
    }

    @Test
    void ipSinPenalizaciones(){
        cliente2.agregarActividad(sesionJuegos1);
        cliente2.agregarActividad(sesionJuegos2);
        cliente2.agregarActividad(sesionJuegos3);
        assertEquals(0, cliente2.getPlan().penalizacionPlan(cliente2.cantidadDeIpsUtilizadas()));
    }

    @Test
    void ipConPenalizaciones(){
        cliente2.agregarActividad(sesionJuegos1);
        cliente2.agregarActividad(sesionJuegos2);
        cliente2.agregarActividad(sesionJuegos3);
        cliente2.agregarActividad(sesionJuegos4);
        assertEquals(500, cliente2.getPlan().penalizacionPlan(cliente2.cantidadDeIpsUtilizadas()));
    }
}
