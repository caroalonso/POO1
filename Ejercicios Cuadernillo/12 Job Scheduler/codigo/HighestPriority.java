package ejercicio12;

public class HighestPriority extends JobScheduler{

    public HighestPriority (String tipoEstrategia){
        super(tipoEstrategia);
    }

    @Override
    public Job estrategia() {
        return this.getJobs().stream()
                    .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                    .orElse(null);
    }
}
