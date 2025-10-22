package ParcialImpuestosBcorregir;

import java.util.ArrayList;
import java.util.List;

public class Contribuyente {
    private String nombre;
    private String dni;
    private String email;
    private String localidad;
    private List<Bien> bienes;

    public Contribuyente(String nombre, String dni, String email, String localidad) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.localidad = localidad;
        this.bienes = new ArrayList<>();
    }

    public void agregarBien(Bien bien) {
        this.bienes.add(bien);
    }

    public boolean localidad(String nombreLocalidad) {
        return this.localidad.equals(nombreLocalidad);
    }

    public double calcularImpuestos() {
        return this.bienes.stream()
                .mapToDouble(b -> b.calcularImpuesto())
                .sum();
    }

}
