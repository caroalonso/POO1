package ejercicio20;

import java.time.LocalDate;

public class Reserva {

    private DateLapse dateLapse;
    private Inmueble inmueble;

    public Reserva(DateLapse dateLapse,Inmueble inmueble) {
        this.dateLapse = dateLapse;
        this.inmueble=inmueble;
    }

    public boolean dentroDePeriodo(DateLapse periodoDado) {
        return this.dateLapse.overlaps(periodoDado);
    }

    public double precioReserva(double precioNoche) {
        return this.dateLapse.sizeInDays() * precioNoche;
    }

    public boolean enCurso() {
        return this.dateLapse.includesDate(LocalDate.now());
    }


    public boolean puedeCrear() {
        return this.dateLapse.puedeCrear();
    }

    public boolean puedeCancelar() {
        return this.dateLapse.puedeCancelar();
    }

    //NUEVO
    public boolean estaDentroDeLosUltimosXDiasAntesDelInicio(int dias) {
        return this.dateLapse.estaDentroDeLosUltimosXDiasAntesDelInicio(dias);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Reserva))
            return false;
        Reserva otra = (Reserva) obj;
        return this.dateLapse.getFrom().equals(otra.dateLapse.getFrom()) &&
                this.dateLapse.getTo().equals(otra.dateLapse.getTo());
    }

}
