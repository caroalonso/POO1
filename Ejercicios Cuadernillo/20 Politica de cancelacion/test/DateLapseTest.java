package ejercicio20;

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
        assertFalse(dateLapse.includesDate(LocalDate.of(2025, 8, 11)));
        assertFalse(dateLapse.includesDate(LocalDate.of(2025, 7, 31)));
    }
}