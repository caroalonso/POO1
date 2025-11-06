package ejercicio21;

import java.time.LocalDate;

public class Local extends Envio {

    private static final double PRECIOESTANDAR=1000;
    private static final double PRECIORADIPO=500;

    public Local (String direccionOrigen, String direccionDestino, double peso, LocalDate fechaDespacho, Entrega entrega) {
        super(direccionOrigen, direccionDestino, peso, fechaDespacho, entrega);
    }

    public double precioEstandar(){
     return PRECIOESTANDAR;
    }

    public double precioRapido(){
      return PRECIORADIPO;
    }

    @Override
    double costo() {
        return this.getEntrega().adicional(this);
    }
}
