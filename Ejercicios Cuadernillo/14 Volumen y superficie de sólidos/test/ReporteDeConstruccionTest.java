package ejercicio14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDeConstruccionTest {

    private ReporteDeConstruccion reporteDeConstruccion;
    private Cilindro cilindro;
    private Esfera esfera;
    private PrismasRectangulares prismasRectangulares;

    @BeforeEach
    void setUp() {
        reporteDeConstruccion= new ReporteDeConstruccion();
    }

    @Test
    void testAgregarPieza() {
        assertEquals(0,this.reporteDeConstruccion.cantElementosColeccion());

        esfera = new Esfera("Madera","Marron",2);
        reporteDeConstruccion.agregarPieza(esfera);
        assertEquals(1,this.reporteDeConstruccion.cantElementosColeccion());
    }

    @Test
    void testSinElementosSuperficieDeColor() {
        cilindro = new Cilindro("Hierro","Rojo",2,2);
        reporteDeConstruccion.agregarPieza(cilindro);
        assertEquals(0,reporteDeConstruccion.superficieDeColor("Negro"));
    }

    @Test
    void testConElementosSuperficieDeColor() {
        cilindro = new Cilindro("Hierro","Negro",2,2);
        reporteDeConstruccion.agregarPieza(cilindro);
        assertEquals(1,reporteDeConstruccion.cantElementosColeccion());
        assertEquals(50,reporteDeConstruccion.superficieDeColor("Negro"),0.3);
    }

    @Test
    void tesConElementoVolumenDeMaterial() {
        prismasRectangulares = new PrismasRectangulares("Madera","Amarillo",2,2,2);
        reporteDeConstruccion.agregarPieza(prismasRectangulares);
        assertEquals(1,reporteDeConstruccion.cantElementosColeccion());
        assertEquals(8,reporteDeConstruccion.volumenDeMaterial("Madera"));
    }

    @Test
    void tesSinElementoVolumenDeMaterial() {
        prismasRectangulares = new PrismasRectangulares("Hierro","Amarillo",2,2,2);
        reporteDeConstruccion.agregarPieza(prismasRectangulares);
        assertEquals(1,reporteDeConstruccion.cantElementosColeccion());
        assertEquals(0,reporteDeConstruccion.volumenDeMaterial("Madera"));
    }
}