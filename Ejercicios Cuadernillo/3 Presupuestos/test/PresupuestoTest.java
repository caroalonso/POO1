package ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PresupuestoTest {

	private Presupuesto presupuesto;

	@BeforeEach
	public void setUp() {
		presupuesto = new Presupuesto("Alberto Rodriguez");
	}

	@Test
	public void testCalcularTotal() {
		assertEquals(0, presupuesto.calcularTotal()); //presupueso total sin items

		Item item = new Item();
		item.setDetalle("Leche");
		item.setCostoUnitario(100);
		item.setCantidad(1);
		
		presupuesto.agregarItem(item);
		assertEquals(100, presupuesto.calcularTotal()); //presupuesto total con 1 item

		item = new Item();
		item.setDetalle("Chocolate");
		item.setCostoUnitario(150);
		item.setCantidad(1);
		presupuesto.agregarItem(item);

		assertEquals(250, presupuesto.calcularTotal()); //presupuesto total con 2 items
	}

	@Test
	public void testInitialize() {
		assertEquals(0, presupuesto.calcularTotal());
	}

}
