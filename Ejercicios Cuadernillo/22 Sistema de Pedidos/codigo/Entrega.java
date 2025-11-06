package ejercicio22;

import java.time.LocalDateTime;

public abstract class Entrega {

    private LocalDateTime fechaHora;

    public Entrega (LocalDateTime fechaHora){
        this.fechaHora=fechaHora;
    }

    public LocalDateTime getFechaHora(){
        return this.fechaHora;
    }

    abstract int calcularEntrega(LocalDateTime fechaHoraPedido);
}
