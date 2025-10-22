package ejercicio16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

}
