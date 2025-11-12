package ejercicio24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenCompraTest {

    private Usuario usuario;
    private OrdenCompra ordenCompra;
    private Producto panelSolar;
    private Producto compostera;

    private Producto p1;
    private Producto p2;
    private Producto p3;
    private Producto p4;
    private Producto p5;
    private Producto p6;

    @BeforeEach
    void setUp() {

        usuario = new Usuario("Juan Martínez", "Larrea 5800, Mar del Plata");
        panelSolar = new Producto("panelSolar", "reciclable", 35.000, false);
        compostera = new Producto("compostera", "no reciclable", 8000, true);
        ordenCompra = new OrdenCompra(usuario, "Larrea 5800, Mar del Plata", 1000);

        p1 = new Producto("p1", "r1", 100, false);
        p2 = new Producto("p2", "r2", 100, false);
        p3 = new Producto("p3", "r3", 100, false);
        p4 = new Producto("p4", "r4", 100, false);
        p5 = new Producto("p5", "r5", 100, false);
        p6 = new Producto("p6", "r6", 100, false);

    }

    @Test
    void testOrdenSinProductos() {
        assertEquals(0, ordenCompra.costo());
    }

    @Test
    void testOrdenConProductos() {
        ordenCompra.agregarProducto(panelSolar);
        ordenCompra.agregarProducto(compostera);
        assertEquals(8035, ordenCompra.costo());
    }

    @Test
    void testOrdenConMenosDeCincoProductos() {
        ordenCompra.agregarProducto(p1);
        ordenCompra.agregarProducto(p2);
        ordenCompra.agregarProducto(p3);
        ordenCompra.agregarProducto(p4);
        assertFalse(ordenCompra.descuento());
    }

    @Test
    void testOrdenConMenosCincoProductos() {
        ordenCompra.agregarProducto(p1);
        ordenCompra.agregarProducto(p2);
        ordenCompra.agregarProducto(p3);
        ordenCompra.agregarProducto(p4);
        ordenCompra.agregarProducto(p5);
        assertTrue(ordenCompra.descuento());
    }

    @Test
    void testOrdenConMasDeCincoProductos() {
        ordenCompra.agregarProducto(p1);
        ordenCompra.agregarProducto(p2);
        ordenCompra.agregarProducto(p3);
        ordenCompra.agregarProducto(p4);
        ordenCompra.agregarProducto(p5);
        ordenCompra.agregarProducto(p6);
        assertTrue(ordenCompra.descuento());
    }
}
