package ejercicio15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    private Email email;
    private Archivo archivo;

    @Test
    void testAgregarArchivo(){
        email=new Email("email","cuerpo");
        archivo=new Archivo("archivo");
        email.agregarArchivo(archivo);
        assertTrue(email.adjuntos().contains(archivo));

        archivo=new Archivo("archivo2");
        assertFalse(email.adjuntos().contains(archivo));
    }

    @Test
    void testContieneTexto(){
        email=new Email("email","cuerpo");
        assertFalse(email.contieneTexto("hola"));
        assertTrue(email.contieneTexto("email"));
    }

    @Test
    void testEspacioOcupado(){
        email= new Email("e","c");
        assertEquals(2,email.espacioOcupado());

        archivo=new Archivo("a");
        email.agregarArchivo(archivo);
        archivo=new Archivo("a");
        email.agregarArchivo(archivo);
        assertEquals(4,email.espacioOcupado());
    }

}
