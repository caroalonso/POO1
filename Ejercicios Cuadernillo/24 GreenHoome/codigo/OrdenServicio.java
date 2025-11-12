package ejercicio24;

import java.util.ArrayList;
import java.util.List;

public class OrdenServicio extends Orden{
    private String descripcion;
    private int horas;
    private List<Tecnico> tecnicos;
    private static final int DIEZ = 10;

    public OrdenServicio (Usuario usuario, String direccion,String descripcion, int horas){
        super(usuario,direccion);
        this.descripcion=descripcion;
        this.horas=horas;
        this.tecnicos=new ArrayList<>();
    }

    public void agregarTecnico(Tecnico tecnico){
        this.tecnicos.add(tecnico);
    }

    public double costoTecnicos(){
        return this.tecnicos.stream()
                .mapToDouble(t->t.getValorHora() * this.horas)
                .sum();
    }

    @Override
    double costo() {
        return this.costoTecnicos() + this.costoProductos();
    }

    @Override
    boolean descuento() {
        return this.horas >= DIEZ;
    }
}
