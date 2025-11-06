package ejercicio22;

import java.util.List;

public class PedidosViandas extends Pedido {

    private List<Vianda> viandas;
    private boolean celiaco;
    public static final int CUARENTA = 40;

    public PedidosViandas (String email, Entrega entrega, List<Vianda> viandas, boolean celiaco) {
        super(email, entrega);
        this.viandas = viandas;
        this.celiaco = celiaco;
    }

    private boolean tiempoEstimado(int tiempo) {
        return this.tiempoEstimadoEntrega() > tiempo;
    }

    public void agregarVianda(Vianda vianda) {
        if (this.tiempoEstimado(CUARENTA)) {
            if (!this.celiaco || vianda.getAptoCeliaco()) {  //celiaco = false, agrega cualquier vianda.
                this.viandas.add(vianda);                    //celiaco = true,agrega solo si getAptoCeliaco() = true.
            }
        }
    }

    public double costoPedido () {
        return this.viandas.stream()
                .mapToDouble(p -> p.getPrecio())
                .sum();
    }

}