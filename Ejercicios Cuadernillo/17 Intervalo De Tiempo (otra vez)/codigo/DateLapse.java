package ejercicio17;

import java.time.LocalDate;

public class DateLapse extends AbstractTimeInterval {
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        super(from);
        this.to = to;
    }

    @Override
    public LocalDate getTo() {
        return this.to;
    }

}
