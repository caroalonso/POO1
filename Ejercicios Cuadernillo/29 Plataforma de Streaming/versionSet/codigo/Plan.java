package ejercicio29Set;

public abstract class Plan {
    private int ip;
    public static final int CERO=0;

    public Plan (int ip){
        this.ip=ip;
    }

    public int penalizacionPlan(int ips){
        if(ips <= this.ip)
            return CERO;
        return this.adicional();
    }

    public int getIp(){
        return this.ip;
    }

    abstract double precioBasePlan();
    abstract int adicional();
}
