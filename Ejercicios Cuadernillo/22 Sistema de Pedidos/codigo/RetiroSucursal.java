package ejercicio22;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RetiroSucursal extends Entrega {

    private String dni;

    public RetiroSucursal(String dni, LocalDateTime fechaHoraRetiro) {
        super(fechaHoraRetiro);
        this.dni = dni;
    }

    @Override
    public int calcularEntrega(LocalDateTime fechaHoraPedido) {
        return (int) ChronoUnit.MINUTES.between(fechaHoraPedido,this.getFechaHora());
    }


}
