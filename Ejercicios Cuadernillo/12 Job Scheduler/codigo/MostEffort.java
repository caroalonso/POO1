package ejercicio12;

public class MostEffort extends JobScheduler{

    public MostEffort (String tipoEstrategia){
        super(tipoEstrategia);
    }

    @Override
    public Job estrategia() {
        return this.getJobs().stream()
                    .max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
                    .orElse(null);
    }
}
