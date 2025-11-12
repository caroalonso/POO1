package ejercicio24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    private Usuario usuario;

    private OrdenCompra ordenCompra;
    private OrdenServicio ordenServicio;

    private Producto panelSolar;
    private Producto compostera;
    private Producto calefonSolar;

    private Tecnico tecnico;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan Martínez", "Larrea 5800, Mar del Plata");

        panelSolar=new Producto("panelSolar","reciclable",35.000,false);
        compostera= new Producto("compostera","no reciclable",8000,true);
        calefonSolar= new Producto("calefonSolar","reciclable",50000,false);

        ordenCompra=new OrdenCompra(usuario,"Larrea 5800, Mar del Plata",1000);
        ordenCompra.agregarProducto(panelSolar);
        ordenCompra.agregarProducto(compostera);

        tecnico=new Tecnico("Lucía Iraola","instalaciones solares",4500);

        ordenServicio=new OrdenServicio(usuario,"Larrea 5800, Mar del Plata","instalación de calefón solar",5);
        ordenServicio.agregarProducto(calefonSolar);
        ordenServicio.agregarTecnico(tecnico);
    }

    @Test
    void testValorTotalDeOrdenes(){
        usuario.agregarOrden(ordenCompra);
        usuario.agregarOrden(ordenServicio);
        assertEquals(73285,usuario.calcularCosto());
    }

}
