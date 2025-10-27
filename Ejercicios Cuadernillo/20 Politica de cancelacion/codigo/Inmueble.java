package ejercicio20;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inmueble {

    private String nombre;
    private String direccion;
    private double precioNoche;
    private List<Reserva> reservas;
    private PoliticaCancelacion politicaCancelacion;

    public Inmueble(String nombre, String direccion, double precioNoche, PoliticaCancelacion politicaCancelacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioNoche = precioNoche;
        this.reservas = new ArrayList<>();
        this.politicaCancelacion = politicaCancelacion;
    }

    public void setPoliticaCancelacion(PoliticaCancelacion politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }

    public void crearReserva(DateLapse periodoDado, Usuario usuario) {
        if (this.consultarDisponibilidad(periodoDado)) {
            Reserva reserva = new Reserva(periodoDado,this);
            if (reserva.puedeCrear()) {
                boolean agregada = this.reservas.add(reserva); // add. si se agrega return true
                if (agregada)
                    usuario.agregarReserva(reserva);
            }
        }
    }

    public double cancelarReserva(Reserva reserva, Usuario usuario) {
        if (!reserva.enCurso() && reserva.puedeCancelar()) {
            double politica = this.politicaCancelacion.reembolso(reserva, precioNoche);
            this.reservas.remove(reserva);
            usuario.cancelarReserva(reserva);
            return politica;
        }
        return 0;
    }

    public boolean consultarDisponibilidad(DateLapse periodoDada) {
        return this.reservas.stream()
                .noneMatch(r -> r.dentroDePeriodo(periodoDada));
    }

    public double retribucionPropiertario(DateLapse periodoDado) {
        return this.reservas.stream()
                .filter(r -> r.dentroDePeriodo(periodoDado))
                .mapToDouble(r -> r.precioReserva(this.precioNoche))
                .sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; //misma instancia
        if (!(obj instanceof Inmueble))
            return false;  // false si son diferente tipo
        Inmueble otro = (Inmueble) obj; //casteo para acceder a atributos internos del objeto
        return Objects.equals(this.nombre, otro.nombre) &&
                Objects.equals(this.direccion, otro.direccion) &&
                this.precioNoche == otro.precioNoche;
    }

    //----- metodos para implementacion de Test

    public List<Reserva> getReservas() {
        return this.reservas;
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return this.politicaCancelacion;
    }


}

