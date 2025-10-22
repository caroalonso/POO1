package ejercicio12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifoTest {

    private Fifo fifo;

    private Job firstJob;
    private Job highestPriorityJob;
    private Job mostEffortJob;
    private Job lastJob;

    @BeforeEach
    void setUp(){
        fifo = new Fifo("FIFO");

        firstJob = new Job (1, 1, "Este es el primero");
        highestPriorityJob = new Job (1, 100, "Este es el de más prioridad");
        mostEffortJob = new Job (100, 1, "Este es el de más esfuerzo");
        lastJob = new Job (1, 1, "Este es el último");
    }

    @Test
    void testSchedule() {
        fifo.schedule(firstJob);
        assertTrue(fifo.getJobs().contains(firstJob));
    }

    private void scheduleJobsIn() {
        fifo.schedule(firstJob);
        fifo.schedule(highestPriorityJob);
        fifo.schedule(mostEffortJob);
        fifo.schedule(lastJob);
    }

    @Test
    void testUnschedule() {
        this.scheduleJobsIn();
        fifo.unschedule(firstJob);
        assertFalse(fifo.getJobs().contains(firstJob));
    }

    @Test
    void next(){
        this.scheduleJobsIn();
        assertEquals(fifo.next(),firstJob);
        assertEquals(fifo.getJobs().size(),3);
    }

}
