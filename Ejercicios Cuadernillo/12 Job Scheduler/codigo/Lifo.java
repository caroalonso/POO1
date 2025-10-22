package ejercicio12;

public class Lifo extends JobScheduler{

    public Lifo (String tipoEstrategia){
        super(tipoEstrategia);
    }
    @Override
    public Job estrategia() {
        return this.getJobs().get(this.getJobs().size()-1);
    }
}
