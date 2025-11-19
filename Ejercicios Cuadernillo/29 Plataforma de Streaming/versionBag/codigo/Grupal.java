package ejercicio29Bag;

public class Grupal extends Plan {
    public static final int OCHOCIENTOS =800;
    public static final int QUINIENTOS=500;

    public Grupal(int ips){
        super(ips);
    }

    @Override
    double precioBasePlan() {
        return OCHOCIENTOS * this.getIp();
    }

    @Override
    int adicional() {
        return QUINIENTOS;
    }
}
