package ejercicio12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifoTest {

    private Lifo lifo;

    private Job firstJob;
    private Job highestPriorityJob;
    private Job mostEffortJob;
    private Job lastJob;

    @BeforeEach
    void setUp(){
        lifo = new Lifo("LIFO");

        firstJob = new Job (1, 1, "Este es el primero");
        highestPriorityJob = new Job (1, 100, "Este es el de más prioridad");
        mostEffortJob = new Job (100, 1, "Este es el de más esfuerzo");
        lastJob = new Job (1, 1, "Este es el último");
    }

    @Test
    void testSchedule() {
        lifo.schedule(lastJob);
        assertTrue(lifo.getJobs().contains(lastJob));
    }

    private void scheduleJobsIn() {
        lifo.schedule(firstJob);
        lifo.schedule(highestPriorityJob);
        lifo.schedule(mostEffortJob);
        lifo.schedule(lastJob);
    }

    @Test
    void testUnschedule() {
        this.scheduleJobsIn();
        lifo.unschedule(lastJob);
        assertFalse(lifo.getJobs().contains(lastJob));
    }

    @Test
    void testNext(){
        this.scheduleJobsIn();
        assertEquals(lifo.next(),lastJob);
        assertEquals(lifo.getJobs().size(),3);
    }

}
