package ejercicio29Set;

import ejercicio25.Bag;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cliente {
    private String nombre;
    private LocalDate fechaAlta;
    private Plan plan;
    private List<Actividad> actividades;
    private final static int DIEZ = 10;
    private final static int CERO = 0;

    public Cliente(String nombre, Plan plan) {
        this.nombre = nombre;
        this.fechaAlta = LocalDate.now();
        this.plan = plan;
        this.actividades = new ArrayList<>();
    }

    public void cambioDePlan(Plan plan) {
        this.plan = plan;
    }

    public void agregarActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }

    private boolean mayorA(int valor) {
        return Period.between(this.fechaAlta, LocalDate.now()).getYears() > valor;
    }

    public int cantidadDeIpsUtilizadas() {
        Set<String> cantidadIps = this.actividades.stream()
                .map(a -> a.getIpUsada())
                .collect(Collectors.toSet());
        return cantidadIps.size();
    }

    //OTRO METODO QUE PODRIA USAR SIN USAR SET NI BAG
    // private int cantidadDeIpsUtilizadas() {
    //    return (int) this.actividades.stream()
    //            .map(a -> a.getIpUsada())
    //            .distinct() // elimina repetidos
    //            .count();   // total sin repetidos
    //}

    public double penalizacion() {
        if (mayorA(DIEZ))
            return CERO;
        return this.plan.penalizacionPlan(this.cantidadDeIpsUtilizadas());
    }

    public double montoAcobrarCliente(DateLapse dateLapse) {
        return this.actividades.stream()
                .filter(a -> dateLapse.includesDate(a.getFecha()))
                .mapToDouble(a->a.montoPorActividad() + this.plan.precioBasePlan() + this.penalizacion())
                .sum();
    }

    //------------------ metodo para test--------------------------

    public void setFechaAlta(LocalDate fecha){
        this.fechaAlta=fecha;
    }

    public LocalDate getFecha(){
        return this.fechaAlta;
    }

    public Plan getPlan(){return this.plan;}
}