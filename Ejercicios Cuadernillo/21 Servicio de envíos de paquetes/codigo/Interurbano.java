package ejercicio21;

import java.time.LocalDate;

public class Interurbano extends Envio {

    public static final double VEINTE=20;
    private static final double VEINTICINCO=25;
    private static final double TREINTA=30;
    private static final double CIEN =100;
    private static final double QUINIENTOS=500;
    private double distanciaKM;
    private static final double PRECIOESTANDAR=0;
    private static final double PRECIORADIPO=0;

    public Interurbano(String direccionOrigen, String direccionDestino, double peso, LocalDate fechaDespacho, double distanciaKM) {
        super(direccionOrigen, direccionDestino, peso, fechaDespacho, new Estandar());
        this.distanciaKM=distanciaKM;
    }

    private double distancia (){
     if (this.distanciaKM >= CIEN && this.distanciaKM <= QUINIENTOS)
         return VEINTICINCO;
     if (this.distanciaKM > QUINIENTOS)
         return TREINTA;
     return VEINTE;
    }

    @Override
    double costo() {
        return this.distancia() * this.getPeso();
    }

    public double precioEstandar(){
        return PRECIOESTANDAR;
    }

    public double precioRapido(){
        return PRECIORADIPO;
    }

}
