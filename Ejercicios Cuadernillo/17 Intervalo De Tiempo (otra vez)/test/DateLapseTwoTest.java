package ejercicio17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class DateLapseTwoTest {
    private DateLapseTwo dateLapseTwo;
    private LocalDate from;
    private int sizeInDays;

    @BeforeEach
    void setUp() {
        from = LocalDate.of(2025, 8, 1);
        sizeInDays = 10;
    }

    @Test
    void testDataLapseGettersTwo() {
        dateLapseTwo = new DateLapseTwo(from, sizeInDays);
        assertEquals(from, dateLapseTwo.getFrom());
        assertEquals(from.plusDays(sizeInDays), dateLapseTwo.getTo());
    }

    @Test
    void testSizeInDays() {
        dateLapseTwo = new DateLapseTwo(from, 0);
        assertEquals(0, dateLapseTwo.sizeInDays());

        dateLapseTwo = new DateLapseTwo(from, sizeInDays);
        assertEquals(10, dateLapseTwo.sizeInDays());
    }

    @Test
    void testIncludesDate() {
        dateLapseTwo = new DateLapseTwo(from, sizeInDays);
        assertTrue(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 1)));
        assertTrue(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 11)));
        assertTrue(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 2)));
        assertFalse(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 12)));
        assertFalse(dateLapseTwo.includesDate(LocalDate.of(2025, 7, 31)));
    }
}
