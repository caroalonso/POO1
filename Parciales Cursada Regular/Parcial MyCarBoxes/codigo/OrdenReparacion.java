package ParcialMyCarBoxesCorregir;

import java.util.ArrayList;
import java.util.List;

public class OrdenReparacion extends  Orden {
    private String descricion;
    private List<Empleado> empleados;
    private int cantidadHoras;

    public OrdenReparacion(String patente ,String descricion,int cantidadHoras) {
        super(patente);
        this.descricion = descricion;
        this.empleados = new ArrayList<>();
        this.cantidadHoras = cantidadHoras;
    }

    public Empleado altaEmpleado(String nombre, double costo) {
        Empleado empleado = new Empleado(nombre, costo);
        this.empleados.add(empleado);
        return empleado;
    }

    private double valorDeCobroEmpleados(){
        return this.empleados.stream()
                .mapToDouble(e->e.costoPorHora() * this.cantidadHoras)
                .sum();
    }

    @Override
    public double costo(){
        return this.totalRepuestos() + this.valorDeCobroEmpleados();
    }
}
