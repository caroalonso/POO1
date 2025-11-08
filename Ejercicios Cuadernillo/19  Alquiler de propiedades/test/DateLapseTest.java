package ejercicio19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateLapseTest {
    private DateLapse dateLapse;
    private LocalDate from;
    private LocalDate to;

    @BeforeEach
    void setUp() {
        from = LocalDate.of(2025, 8, 1);
        to = LocalDate.of(2025, 8, 10);
    }

    @Test
    void testDataLapseGetters() {
        dateLapse = new DateLapse(from, to);
        assertEquals(from, dateLapse.getFrom());
        assertEquals(to, dateLapse.getTo());
    }

    @Test
    void testSizeInDays() {
        dateLapse = new DateLapse(LocalDate.now(), LocalDate.now());
        assertEquals(0, dateLapse.sizeInDays());
        dateLapse = new DateLapse(from, to);
        assertEquals(9, dateLapse.sizeInDays());
    }

    @Test
    void testIncludesDate() {
        dateLapse = new DateLapse(from, to);
        assertTrue(dateLapse.includesDate(LocalDate.of(2025, 8, 1)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2025, 8, 10)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2025, 8, 2)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2025, 8, 9)));
        assertFalse(dateLapse.includesDate(LocalDate.of(2025, 8, 11)));
        assertFalse(dateLapse.includesDate(LocalDate.of(2025, 7, 31)));
    }

    @Test
    void testOverlaps (){
        LocalDate base = LocalDate.of(2025, 1, 1);

        // Intervalo principal (this)
        DateLapse intervaloPrincipal = new DateLapse(base, base.plusDays(9)); // [1 ene , 10 ene]

        // 1) La fecha de inicio y fin de other es anterior a la fecha inicio de periodo principal.
        DateLapse otroAntes = new DateLapse(base.minusDays(10), base.minusDays(1)); // [22 dic , 31 dic]
        assertFalse(intervaloPrincipal.overlaps(otroAntes));

        // 2) La fecha inicio y fin de other es posterior a la fecha final de periodo principal.
        DateLapse otroDespues = new DateLapse(base.plusDays(10), base.plusDays(19)); // [11 ene , 20 ene]
        assertFalse(intervaloPrincipal.overlaps(otroDespues));

        // 3) La fecha inicio y fecha fin de other es igual a la fecha inicio y fecha fin de periodo .
        DateLapse otroIgual = new DateLapse(base, base.plusDays(9)); // [1 ene , 10 ene]
        assertTrue(intervaloPrincipal.overlaps(otroIgual));

        // 4) La fecha final de other es la fecha comienzo de periodo(limite izquiero)
        DateLapse otroTocaIzquierda = new DateLapse(base.minusDays(5), base); // [27 dic , 1 ene]
        assertTrue(intervaloPrincipal.overlaps(otroTocaIzquierda));

        // 5) La fecha comienzo de other es la fecha fin de periido (limite derecho)
        DateLapse otroTocaDerecha = new DateLapse(base.plusDays(9), base.plusDays(14)); // [10 ene , 15 ene]
        assertTrue(intervaloPrincipal.overlaps(otroTocaDerecha));

        // 6) La fecha inicio de other es anterior a la fecha inicio de periodo y la fecha final de
        // other es anterior a la fecha fin de periodo.
        DateLapse otroParcialIzquierda = new DateLapse(base.minusDays(5), base.plusDays(4)); // [27 dic , 5 ene]
        assertTrue(intervaloPrincipal.overlaps(otroParcialIzquierda));

        // 7) La fecha fin de other esta despues de la fecha fin de periodo y la fecha inicio de other
        // esta despues de la fecha inicio de periodo.
        DateLapse otroParcialDerecha = new DateLapse(base.plusDays(4), base.plusDays(14)); // [5 ene , 15 ene]
        assertTrue(intervaloPrincipal.overlaps(otroParcialDerecha));

        // 8) La fecha fin de other esta despues de la fecha fin de periodo y la fecha inicio de
        // other esta despues de la fecha inicio de periodo.
        DateLapse otroContenido = new DateLapse(base.plusDays(2), base.plusDays(6)); // [3 ene , 7 ene]
        assertTrue(intervaloPrincipal.overlaps(otroContenido));


    }
}

