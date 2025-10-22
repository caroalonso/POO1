package ejercicio15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarpetaTest {

    private Carpeta carpeta;
    private Email email;
    private Carpeta carpetaDestino;
    private Archivo archivo;

    @Test
    void testAgregarEmail(){
        email= new Email("titulo","cuerpo");
        carpeta=new Carpeta("carpeta");
        assertFalse(carpeta.getEmails().contains(email));
    }

    @Test
    void testMover(){
        carpeta=new Carpeta("carpeta");
        carpetaDestino=new Carpeta("carpeta destino");
        email= new Email("titulo","cuerpo");
        carpeta.mover(email,carpetaDestino);
        assertTrue(carpetaDestino.getEmails().contains(email));

        email= new Email("email2","cuerpo2");
        assertFalse(carpetaDestino.getEmails().contains(email));
    }

    @Test
    void testBuscar(){
        carpeta=new Carpeta("carpeta");
        email= new Email("titulo","cuerpo");
        carpeta.agregarEmail(email);
        assertEquals(email,carpeta.buscar("cuerpo"));

        assertNotEquals(email,carpeta.buscar("casa"));
    }

    @Test
    void testEspacioOcupado(){
        carpeta=new Carpeta("carpeta");
        assertEquals(0,carpeta.espacioOcupado());

        archivo=new Archivo("c");
        email= new Email("a","b");
        email.agregarArchivo(archivo);

        carpeta.agregarEmail(email);
        assertEquals(3,carpeta.espacioOcupado());
    }

}
