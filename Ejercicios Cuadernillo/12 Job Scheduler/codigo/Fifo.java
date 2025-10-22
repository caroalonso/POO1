package ejercicio12;

public class Fifo extends JobScheduler {

    public Fifo (String tipoEstrategia){
        super(tipoEstrategia);
    }

    @Override
    public Job estrategia() {
        return this.getJobs().get(0);
    }
}
