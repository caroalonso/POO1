package ParcialViviendas;

public class ServicioLimpieza extends Servicio {
    private double tarifaMinima;

    public ServicioLimpieza(double precio, int cantidadHoras, double tarifaMinima) {
        super(precio, cantidadHoras);
        this.tarifaMinima = tarifaMinima;
    }

    public double montoServicio() {
        if (this.precioPorHoras() > 0)
            return this.precioPorHoras();
        return this.tarifaMinima;
    }

}

// TAMBIEN SE PODRIA USAR EL METODO TERNARIO:
// condicion ? valor_condicion_verdadera : valor_condicion_falsa

// public double montoServicio() {
//   return (this.precioPorHoras() > 0) ? this.precioPorHoras() : this.tarifaMinima;
// }

