package ejercicio17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DateLapseAnsDateLapseTwoTest {
    private DateLapseTwo dateLapseTwo;
    private DateLapse dateLapse;
    private LocalDate from;
    private LocalDate to;
    private int sizeInDays;

    @BeforeEach
    void setUp(){
        from= LocalDate.of(2025,8,1);
        to=LocalDate.of(2025,8,10);
        sizeInDays = 10;
    }

    @Test
    void testDataLapseGetters() {
        dateLapse= new DateLapse(from,to);
        assertEquals(from,dateLapse.getFrom());
        assertEquals(to,dateLapse.getTo());

        dateLapseTwo = new DateLapseTwo(from, sizeInDays);
        assertEquals(from, dateLapseTwo.getFrom());
        assertEquals(from.plusDays(sizeInDays), dateLapseTwo.getTo());
    }

    @Test
    void testSizeInDays() {
        dateLapse= new DateLapse(LocalDate.now(),LocalDate.now());
        assertEquals(0,dateLapse.sizeInDays());
        dateLapse = new DateLapse(from,to);
        assertEquals(9,dateLapse.sizeInDays());

        dateLapseTwo = new DateLapseTwo(from, 0);
        assertEquals(0, dateLapseTwo.sizeInDays());
        dateLapseTwo = new DateLapseTwo(from, sizeInDays);
        assertEquals(10, dateLapseTwo.sizeInDays());
    }

    @Test
    void testIncludesDate() {
        dateLapse= new DateLapse(from,to);
        assertTrue(dateLapse.includesDate(LocalDate.of(2025,8,1)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2025,8,10)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2025,8,2)));
        assertTrue(dateLapse.includesDate(LocalDate.of(2025,8,9)));
        assertFalse(dateLapse.includesDate(LocalDate.of(2025,8,11)));
        assertFalse(dateLapse.includesDate(LocalDate.of(2025,7,31)));

        dateLapseTwo = new DateLapseTwo(from, sizeInDays);
        assertTrue(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 1)));
        assertTrue(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 11)));
        assertTrue(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 2)));
        assertTrue(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 9)));
        assertFalse(dateLapseTwo.includesDate(LocalDate.of(2025, 8, 12)));
        assertFalse(dateLapseTwo.includesDate(LocalDate.of(2025, 7, 31)));
    }
}

