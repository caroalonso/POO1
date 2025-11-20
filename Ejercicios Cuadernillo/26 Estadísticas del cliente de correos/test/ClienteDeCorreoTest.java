package ejercicio26;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDeCorreoTest {

    @Test
    void testBuscarEnCliente() {
        ClienteDeCorreo cliente = new ClienteDeCorreo();
        Carpeta trabajo = new Carpeta("Trabajo");
        cliente.agregarCarpeta(trabajo);

        Email eInbox = new Email("Hola", "mundo");
        Email eTrabajo = new Email("Reunión", "mañana");

        cliente.recibir(eInbox);
        trabajo.agregarEmail(eTrabajo);

        assertEquals(eInbox, cliente.buscar("Hola"));
        assertEquals(eTrabajo, cliente.buscar("Reunión"));
    }

    @Test
    void testEspacioOcupadoCliente() {
        ClienteDeCorreo cliente = new ClienteDeCorreo();
        Carpeta c1 = new Carpeta("Carpeta A");
        cliente.agregarCarpeta(c1);

        Email e1 = new Email("Hola", "mundo");    // 9
        Email e2 = new Email("Java", "JUnit");    // 8

        cliente.recibir(e1);
        c1.agregarEmail(e2);

        assertEquals(17, cliente.espacioOcupado());
    }

    @Test
    void testCantidadTotalDeEmailsCliente() {
        ClienteDeCorreo cliente = new ClienteDeCorreo();
        Carpeta carp = new Carpeta("Trabajo");
        cliente.agregarCarpeta(carp);

        cliente.recibir(new Email("a","b"));        // 1 email en inbox
        cliente.recibir(new Email("c","d"));        // 2 en inbox
        carp.agregarEmail(new Email("e","f"));     // 1 en carp

        assertEquals(3, cliente.cantidadTotalDeEmailsCliente());
    }
}
