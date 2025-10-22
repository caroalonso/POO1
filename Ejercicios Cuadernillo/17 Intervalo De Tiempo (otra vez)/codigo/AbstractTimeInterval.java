package ejercicio17;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class AbstractTimeInterval implements TimeInterval{
    protected LocalDate from;

    public AbstractTimeInterval(LocalDate from) {
        this.from = from;
    }

    @Override
    public LocalDate getFrom() {
        return this.from;
    }

    @Override
    public int sizeInDays() {
        return (int) ChronoUnit.DAYS.between(this.getFrom(), this.getTo());
    }

    @Override
    public boolean includesDate(LocalDate other) {
        return (!other.isBefore(this.getFrom()) && !other.isAfter(this.getTo()));
    }

    @Override
    public abstract LocalDate getTo();
}

