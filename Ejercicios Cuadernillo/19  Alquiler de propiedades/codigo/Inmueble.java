package ejercicio19;

import java.util.*;

public class Inmueble {
    private String nombre;
    private String direccion;
    private double precioNoche;
    private List<Reserva> reservas;

    public Inmueble(String nombre, String direccion, double precioNoche) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioNoche = precioNoche;
        this.reservas = new ArrayList<>();
    }

    public void crearReserva(DateLapse periodoDado, Usuario usuario) {
        if (this.consultarDisponibilidad(periodoDado)) {
                Reserva reserva = new Reserva(periodoDado,this);
                if(reserva.puedeCrear()) {
                    boolean agregada = this.reservas.add(reserva); // add. si se agrega return true
                    if (agregada)
                        usuario.agregarReserva(reserva);
            }
        }
    }

    public void cancelarReserva(Reserva reserva, Usuario usuario) {
        if (!reserva.enCurso() && reserva.puedeCancelar()) {
                this.reservas.remove(reserva);
                usuario.cancelarReserva(reserva);
        }
    }

    public boolean consultarDisponibilidad(DateLapse periodoDada) {
        return this.reservas.stream()
                .noneMatch(r -> r.dentroDePeriodo(periodoDada));
    }

    public double retribucionPropiertario(DateLapse periodoDado) {
        return this.reservas.stream()
                .filter(r -> r.dentroDePeriodo(periodoDado))
                .mapToDouble(r -> r.precioReserva())
                .sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; //misma instancia
        if (!(obj instanceof Inmueble))
            return false;  // false si son diferente tipo
        Inmueble otro = (Inmueble) obj; //casteo para acceder a atributos internos del objeto
        return  Objects.equals(this.nombre, otro.nombre) &&
                Objects.equals(this.direccion, otro.direccion) &&
                this.precioNoche == otro.precioNoche;
    }

    public double getPrecioNoche(){
        return this.precioNoche;
    }


    //----- metodos para implementacion de Test

    public List<Reserva> getReservas(){
        return this.reservas;
    }

}

