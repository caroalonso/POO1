package ejercicio29Set;

import java.util.ArrayList;
import java.util.List;

public class SesionJuegos extends Actividad {
    private List<Item>items;
    public static final int TRECIENTOS=300;
    public static final int CERO=0;

    public SesionJuegos(String ip, int duracion){
        super(ip,duracion);
        this.items=new ArrayList<>();
    }

    public void agregarItem(Item item){
        this.items.add(item);
    }

    private double costoDeItems(){
        return this.items.stream()
                .mapToDouble(i->i.costo())
                .sum();
    }

    @Override
    double montoPorActividad() {
        return this.getDuracion() > TRECIENTOS ? this.costoDeItems() : CERO;
    }
}
