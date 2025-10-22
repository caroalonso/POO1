package ParcialEnvioA;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Paquete> paquetes;
    private List<Camion> camiones;

    public Empresa(){
        this.paquetes=new ArrayList<>();
        this.camiones=new ArrayList<>();
    }

    public void agregarEncomienda(Paquete paquete){
        this.paquetes.add(paquete);
    }

    public void agregarCamion (Camion camion){
        this.camiones.add(camion);
    }
}
