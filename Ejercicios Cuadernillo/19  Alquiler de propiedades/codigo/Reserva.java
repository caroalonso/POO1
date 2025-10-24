package ejercicio19;

import java.time.LocalDate;
import java.util.Objects;

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

    public double precioReserva() {
        return this.dateLapse.sizeInDays() * this.inmueble.getPrecioNoche();
    }

    public boolean enCurso() {
        return this.dateLapse.includesDate(LocalDate.now());
    }

    public boolean puedeCancelar() {
        return this.dateLapse.puedeCancelar();
    }

    public boolean puedeCrear() {
        return this.dateLapse.puedeCrear();
    }

    @Override
    public boolean equals(Object obj) {  // nuevo elemento a agregar o eliminar de coleccion
        if (this == obj)
            return true;  //  misma instancia
        if (!(obj instanceof Reserva))
            return false;   // no es mismo tipo
        Reserva otra = (Reserva) obj; // casteo el elemento para acceder a atributos internos
        return Objects.equals(this.dateLapse, otra.dateLapse);
    }

}
