package ParcialViviendas;

import java.time.LocalDate;

public class ContratoUnico extends Contrato {
    private final static double MONTO_ADICIONAL = 0.15;

    public ContratoUnico(LocalDate fecha, Servicio servicio) {
        super(fecha, servicio);
    }

    public double sumaValorContrato() {
        if (this.esFinDeSemana())
            return this.getValorServicio() * (1 + MONTO_ADICIONAL);
        return this.getValorServicio();
    }

}

// TAMBIEN SE PODRIA USAR EL METODO TERNARIO:
// condicion ? valor_condicion_verdadera : valor_condicion_falsa

// public double sumaValorContrato() {
//    return this.esFinDeSemana() ? this.getValorServicio() * (1 + this.MONTO_ADICIONAL) : this.getValorServicio();
// }