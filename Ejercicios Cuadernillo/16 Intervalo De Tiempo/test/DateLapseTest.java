package ejercicio16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DateLapseTest {
    private DateLapse dataLapse;
    private LocalDate from;
    private LocalDate to;

    @BeforeEach
    void setUp(){
        from= LocalDate.of(2025,8,1);
        to=LocalDate.of(2025,8,10);
    }

    @Test
    void testDataLapse() {
        dataLapse= new DateLapse(from,to);
        assertEquals(from,dataLapse.getFrom());
        assertEquals(to,dataLapse.getTo());
    }

    @Test
    void testGetFrom() {
        dataLapse= new DateLapse(from,to);
        assertEquals(from,dataLapse.getFrom());
        assertNotEquals(to,dataLapse.getFrom());
    }

    @Test
    void testGetTo() {
        dataLapse= new DateLapse(from,to);
        assertEquals(to,dataLapse.getTo());
        assertNotEquals(from,dataLapse.getTo());
    }

    @Test
    void testSizeInDays() {
        dataLapse= new DateLapse(LocalDate.now(),LocalDate.now());
        assertEquals(0,dataLapse.sizeInDays());
        dataLapse = new DateLapse(from,to);
        assertEquals(9,dataLapse.sizeInDays());
    }

    @Test
    void testIncludesDate() {
        dataLapse= new DateLapse(from,to);
        assertTrue(dataLapse.includesDate(LocalDate.of(2025,8,1)));
        assertTrue(dataLapse.includesDate(LocalDate.of(2025,8,10)));
        assertTrue(dataLapse.includesDate(LocalDate.of(2025,8,2)));
        assertFalse(dataLapse.includesDate(LocalDate.of(2025,8,11)));
        assertFalse(dataLapse.includesDate(LocalDate.of(2025,7,31)));;
    }
}