package ejercicio17;

import java.time.LocalDate;

public class DateLapseTwo extends AbstractTimeInterval {
    private int sizeInDays;

    public DateLapseTwo(LocalDate from, int sizeInDays) {
        super(from);
        this.sizeInDays = sizeInDays;
    }

    @Override
    public LocalDate getTo() {
        return this.from.plusDays(this.sizeInDays);
    }
}

