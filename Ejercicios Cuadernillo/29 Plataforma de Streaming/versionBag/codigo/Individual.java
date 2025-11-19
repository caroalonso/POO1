package ejercicio29Bag;

public class Individual extends Plan {
    private int minutosContratados;
    public static final int VEINTE =20;
    public static final int TRESCIENTOS=300;

    public Individual(int minutosContratados){
        super(1);
        this.minutosContratados=minutosContratados;
    }

    @Override
    double precioBasePlan() {
        return this.getIp() * VEINTE;
    }

    @Override
    int adicional() {
        return TRESCIENTOS;
    }
}
