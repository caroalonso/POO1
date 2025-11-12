package ejercicio24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenServicioTest {

    private Usuario usuario;
    private Producto calefonSolar;

    private OrdenServicio ordenMenorAdiezHoras;
    private OrdenServicio ordenIgualAdiezHoras;
    private OrdenServicio ordenMayorAdiezHoras;

    @BeforeEach
    void setUp() {

        usuario = new Usuario("Juan Martínez", "Larrea 5800, Mar del Plata");

        ordenMenorAdiezHoras=new OrdenServicio(usuario,"Larrea 5800, Mar del Plata","instalación de calefón solar",9);
        ordenIgualAdiezHoras=new OrdenServicio(usuario,"Larrea 5800, Mar del Plata","instalación de aire ccondicionado",10);
        ordenMayorAdiezHoras=new OrdenServicio(usuario,"Larrea 5800, Mar del Plata","instalación de luminaria",11);
    }

    @Test
    void testOrdenSinProductos() {
        assertEquals(0, ordenMayorAdiezHoras.costo());
    }

    @Test
    void testOrdenConProductos() {
        calefonSolar=new Producto("calefonSolar","reciclable",50000,false);
        ordenIgualAdiezHoras.agregarProducto(calefonSolar);;
        assertEquals(50000, ordenIgualAdiezHoras.costo());
    }

    @Test
    void testOrdenDeServicioConMenosDeDiezHoras(){
        assertFalse(ordenMenorAdiezHoras.descuento());
    }

    @Test
    void testOrdenDeServicioConDiezHoras(){
        assertTrue(ordenIgualAdiezHoras.descuento());
    }

    @Test
    void testOrdenDeServicioConMasDeDiezHoras(){
        assertTrue(ordenMayorAdiezHoras.descuento());
    }

}
