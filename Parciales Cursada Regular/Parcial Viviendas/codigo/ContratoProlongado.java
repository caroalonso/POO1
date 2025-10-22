package ParcialViviendas;

import java.time.LocalDate;

public class ContratoProlongado extends Contrato {
    private final static double DESCUENTO = 0.10;
    private final static int VALOR = 5;
    private int cantidadDias;

    public ContratoProlongado(LocalDate fecha, int cantidadDias, Servicio servicio) {
        super(fecha, servicio);
        this.cantidadDias = cantidadDias;
    }

    private double valorServicioPorCantidadDeDias() {
        return this.cantidadDias * this.getValorServicio();
    }

    private boolean mayorAvalor(int valor){
        return this.cantidadDias > valor;
    }

    public double sumaValorContrato() {
        if (this.mayorAvalor(VALOR))
            return this.valorServicioPorCantidadDeDias() * (1 - DESCUENTO);
        return this.valorServicioPorCantidadDeDias();
    }

}

// TAMBIEN SE PODRIA USAR EL METODO TERNARIO:
// condicion ? valor_condicion_verdadera : valor_condicion_falsa

// public double sumaValorContrato(){
// return this.cantidadDias > VALOR ? this.valorServicioPorCantidadDeDias() * (1 - this.DESCUENTO) : this.valorServicioPorCantidadDeDias();
// }
