package ejercicio19;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DateLapse {

    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    public Long sizeInDays() {
        return ChronoUnit.DAYS.between(this.getFrom(), this.getTo());
    }

    public boolean includesDate(LocalDate other) {
        // si la fecha No es esta Antes de fechaInicio y tampoco Despues de fechaFin
        // entonces la fecha se encuentra dentro del rango.
        return (!other.isBefore(this.getFrom()) && !other.isAfter(this.getTo()));

    }

    // this.getTo().isAfter(another.getFrom()): el final de este intervalo es igual o después del inicio del otro.
    // this.getFrom().isBefore(another.getTo()): el inicio de este intervalo es igual o antes del final del otro.
    // Si ambas cumplen hay solapamiento parcial o total.
    public boolean overlaps(DateLapse anotherDateLapse) {
        return !this.getTo().isBefore(anotherDateLapse.getFrom())
                && !this.getFrom().isAfter(anotherDateLapse.getTo());
    }


    // se puede cancelar si hoy es antes del inicio de la reserva
    public boolean puedeCancelar() {
        return LocalDate.now().isBefore(this.getFrom());
    }

    // se puede crear si la fecha de inicio es después de hoy
    public boolean puedeCrear() {
        return this.getFrom().isAfter(LocalDate.now());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DateLapse))
            return false;
        DateLapse other = (DateLapse) obj;
        return Objects.equals(this.getFrom(), other.getFrom()) && Objects.equals(this.getTo(), other.getTo());
    }

}
