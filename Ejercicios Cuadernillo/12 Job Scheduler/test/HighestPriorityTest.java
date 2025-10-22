package ejercicio12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HighestPriorityTest {

    private HighestPriority highestPriority;

    private Job firstJob;
    private Job highestPriorityJob;
    private Job mostEffortJob;
    private Job lastJob;

    @BeforeEach
    void setUp(){

        highestPriority = new HighestPriority("HighestPriority");

        firstJob = new Job (1, 1, "Este es el primero");
        highestPriorityJob = new Job (1, 100, "Este es el de más prioridad");
        mostEffortJob = new Job (100, 1, "Este es el de más esfuerzo");
        lastJob = new Job (1, 1, "Este es el último");
    }

    @Test
    void testSchedule() {
        highestPriority.schedule(highestPriorityJob);
        assertTrue(highestPriority.getJobs().contains(highestPriorityJob));
    }

    private void scheduleJobsIn() {
        highestPriority.schedule(firstJob);
        highestPriority.schedule(highestPriorityJob);
        highestPriority.schedule(mostEffortJob);
        highestPriority.schedule(lastJob);
    }

    @Test
    void testUnschedule() {
        this.scheduleJobsIn();
        highestPriority.unschedule(highestPriorityJob);
        assertFalse(highestPriority.getJobs().contains(highestPriorityJob));
    }

   @Test
    void testNext(){
        this.scheduleJobsIn();
        assertEquals(highestPriority.next(),highestPriorityJob);
        assertEquals(highestPriority.getJobs().size(),3);
   }

}
