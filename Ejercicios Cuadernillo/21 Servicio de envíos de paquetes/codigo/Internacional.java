package ejercicio21;

import java.time.LocalDate;

public class Internacional extends Envio {

    private static final double CINCO_MIL=5000;
    private static final double DIEZ=10;
    private static final double DOCE=12;
    private static final double PRECIOESTANDAR=0;
    private static final double PRECIORADIPO=800;
    private static final double UNKILO= 1000;

    public Internacional (String direccionOrigen, String direccionDestino, double peso, LocalDate fechaDespacho, Entrega entrega) {
        super(direccionOrigen, direccionDestino, peso, fechaDespacho, entrega);
    }

    public double precioEstandar(){
        return PRECIOESTANDAR;
    }

    public double precioRapido(){
        return PRECIORADIPO;
    }

    public double precioSegunPeso(){
        return this.getPeso() <= UNKILO ? DIEZ : DOCE;
    }

    @Override
    public double costo() {
        return CINCO_MIL + (this.getPeso() * precioSegunPeso()) + this.getEntrega().adicional(this);
    }
}
