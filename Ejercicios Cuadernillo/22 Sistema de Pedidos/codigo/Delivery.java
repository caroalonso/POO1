package ejercicio22;

import java.time.LocalDateTime;

public class Delivery extends Entrega {

    private String direccion;

    public Delivery(String direccion,LocalDateTime horafechaDelivery) {
        super(horafechaDelivery);
        this.direccion = direccion;
    }

    /// ??????????????????
    @Override
    public int calcularEntrega(LocalDateTime fechaHoraPedido) {
        return 0;
    }
}
