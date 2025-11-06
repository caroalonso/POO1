package ejercicio22;

import java.time.LocalDateTime;
public abstract class Pedido {

    private String email;
    private Entrega entrega;
    private LocalDateTime fechaHoraPedido;

    public Pedido(String email, Entrega entrega) {
        this.email = email;
        this.entrega = entrega;
        this.fechaHoraPedido = LocalDateTime.now();
    }

    public int tiempoEstimadoEntrega(){
        return this.entrega.calcularEntrega(fechaHoraPedido);
    }
}
