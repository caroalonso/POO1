package ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private String dni;
    private List<Inmueble> inmuebles;
    private List<Reserva> reservas;
    private static final double SETENTA_Y_CINCO_POR_CIENTO = 0.75;

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.inmuebles = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarInmueble(Inmueble inmueble) {
        this.inmuebles.add(inmueble);
    }

    public void eliminarInmueble(Inmueble inmueble) {
        this.inmuebles.remove(inmueble);
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    public double retribucionPropietario(DateLapse periodoDado) {
        double resultado = this.inmuebles.stream()
                .mapToDouble(i -> i.retribucionPropiertario(periodoDado))
                .sum();
        return resultado * SETENTA_Y_CINCO_POR_CIENTO;
    }

    //----- metodos para implementacion de Test

    public List<Inmueble> getInmuebles() {
        return this.inmuebles;
    }

    public List<Reserva> getReservas() {
        return this.reservas;
    }

}

