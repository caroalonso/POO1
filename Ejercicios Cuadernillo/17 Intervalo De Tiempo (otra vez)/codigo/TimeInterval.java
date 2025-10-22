package ejercicio17;

import java.time.LocalDate;

public interface TimeInterval {
    LocalDate getFrom();
    LocalDate getTo();
    int sizeInDays();
    boolean includesDate(LocalDate other);
}
