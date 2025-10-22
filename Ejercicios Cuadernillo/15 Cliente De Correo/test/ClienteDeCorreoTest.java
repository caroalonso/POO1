package ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDeCorreoTest {

    private ClienteDeCorreo clienteDeCorreo;
    private Carpeta carpeta;
    private Email email;
    private Email email2;
    private Archivo archivo;

    @BeforeEach
    void setUp(){
      clienteDeCorreo = new ClienteDeCorreo();
    }

    @Test
    void testAgregarCarpeta(){
        carpeta= new Carpeta("Carpeta1");
        assertFalse(clienteDeCorreo.getCarpetas().contains(carpeta));
        clienteDeCorreo.agregarCarpeta(carpeta);
        assertTrue(clienteDeCorreo.getCarpetas().contains(carpeta));
    }

    @Test
    void testRecibir(){
        email=new Email("titulo","cuerpo");
        assertFalse(clienteDeCorreo.getInbox().getEmails().contains(email));
        clienteDeCorreo.recibir(email);
        assertTrue(clienteDeCorreo.getInbox().getEmails().contains(email));
    }

    @Test
    void testBuscar(){
        email=new Email("titulo","cuerpo");
        clienteDeCorreo.recibir(email);
        String texto="cuerpo";
        assertEquals(email,clienteDeCorreo.buscar(texto));

        email2=new Email("segundo titulo","segundo cuerpo");
        carpeta = new Carpeta("Carpeta1");
        clienteDeCorreo.agregarCarpeta(carpeta);
        carpeta.agregarEmail(email2);
        String texto2="segundo cuerpo";
        assertEquals(email2,clienteDeCorreo.buscar(texto2));

        String texto3="no existe";
        assertNull(clienteDeCorreo.buscar(texto3));
    }

    @Test
    void testEspacioOcupado(){
        assertEquals(0,clienteDeCorreo.espacioOcupado());

        archivo=new Archivo("a");
        carpeta=new Carpeta("carpeta");
        email=new Email("c","d");
        email2=new Email("e","f");
        clienteDeCorreo.recibir(email);
        email2.agregarArchivo(archivo);
        carpeta.agregarEmail(email2);
        clienteDeCorreo.agregarCarpeta(carpeta);
        assertEquals(5,clienteDeCorreo.espacioOcupado());
    }












}
