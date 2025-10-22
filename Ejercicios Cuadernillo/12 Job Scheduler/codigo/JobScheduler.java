package ejercicio12;

import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler {

    private List <Job> jobs;
    private String strategy;

    public JobScheduler (String strategy) {
        this.jobs = new ArrayList<>();
        this.strategy = strategy;
    }

    public void schedule(Job job) {
        this.jobs.add(job);
    }

    public void unschedule(Job job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public List <Job> getJobs(){
        return jobs;
    }

    public Job next() {
        Job nextJob = this.estrategia();
        this.unschedule(nextJob);
        return nextJob;
    }
    abstract Job estrategia ();
}
