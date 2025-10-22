package ParcialGimnasio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Socio {
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private List<ServicioGym> servicios;

    public Socio(String nombreCompleto, LocalDate fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = LocalDate.now();
        this.servicios = new ArrayList<>();
    }

    public boolean igualOmayor(int valor) {
        return this.servicios.size() >= valor;
    }

    public double montoApagarPorFecha(LocalDate fecha) {
        return this.servicios.stream()
                .filter(s -> s.esIgual(fecha))
                .mapToDouble(s -> s.costoDeServicio())
                .sum();
    }

    public void agregarServicio(ServicioGym servicio) {
        this.servicios.add(servicio);
    }

}
