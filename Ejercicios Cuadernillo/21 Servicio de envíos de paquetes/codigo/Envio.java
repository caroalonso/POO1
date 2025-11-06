package ejercicio21;

import java.time.LocalDate;
public abstract class Envio {

    private LocalDate fechaDespacho;
    private String direccionOrigen;
    private String direccionDestino;
    private double peso;
    private Entrega entrega;

    public Envio (String direccionOrigen,String direccionDestino,double peso,LocalDate fechaDespacho, Entrega entrega){
        this.fechaDespacho=fechaDespacho;
        this.direccionOrigen=direccionOrigen;
        this.direccionDestino=direccionDestino;
        this.peso=peso;
        this.entrega=entrega;
    }

    public boolean dentroDePeriodo(DateLapse dateLapse){
        return dateLapse.includesDate(this.fechaDespacho);
    }

    public double getPeso(){
      return this.peso;
    }

    public Entrega getEntrega(){
        return this.entrega;
    }
    abstract double costo();
    abstract double precioEstandar();
    abstract double precioRapido();

}
