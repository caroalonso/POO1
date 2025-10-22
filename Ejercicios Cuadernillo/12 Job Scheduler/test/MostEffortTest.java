package ejercicio12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostEffortTest {

    private MostEffort mostEffort;

    private Job firstJob;
    private Job highestPriorityJob;
    private Job mostEffortJob;
    private Job lastJob;

    @BeforeEach
    void setUp(){

        mostEffort = new MostEffort("MostEffort");

        firstJob = new Job (1, 1, "Este es el primero");
        highestPriorityJob = new Job (1, 100, "Este es el de más prioridad");
        mostEffortJob = new Job (100, 1, "Este es el de más esfuerzo");
        lastJob = new Job (1, 1, "Este es el último");
    }

    @Test
    void testSchedule() {
        mostEffort.schedule(mostEffortJob);
        assertTrue(mostEffort.getJobs().contains(mostEffortJob));
    }

    private void scheduleJobsIn() {
        mostEffort.schedule(firstJob);
        mostEffort.schedule(highestPriorityJob);
        mostEffort.schedule(mostEffortJob);
        mostEffort.schedule(lastJob);
    }

    @Test
    void testUnschedule() {
        this.scheduleJobsIn();
        mostEffort.unschedule(mostEffortJob);
        assertFalse(mostEffort.getJobs().contains(mostEffortJob));
    }

    @Test
    void testNext(){
        this.scheduleJobsIn();
        assertEquals(mostEffort.next(),mostEffortJob);
        assertEquals(mostEffort.getJobs().size(),3);
    }
}
