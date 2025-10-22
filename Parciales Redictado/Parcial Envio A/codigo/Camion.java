package ParcialEnvioA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Camion {
    private double peso;
    private double volumen;
    private List<Paquete> encomiendas;

    public Camion(double peso, double volumen) {
        this.peso = peso;
        this.volumen = volumen;
        this.encomiendas=new ArrayList<>();
    }

    //recibe por parametro paquetes sin validar.
    public List<Paquete> cargarCamion (List<Paquete> paquetes){
        //cajas paquetes validos
        List<Paquete> cajas = paquetes.stream()
                .filter(p->p.validarPaquete())
                .sorted((f1, f2) -> f1.fechaDespacho().compareTo(f2.fechaDespacho()))
                .collect(Collectors.toList());

        double sumaPeso=0;
        double sumaVolumen=0;

        for( Paquete p: cajas){
            sumaPeso += p.pesoPaquete();
            sumaVolumen += p.volumenPaquete();
            if (sumaPeso > this.peso || sumaVolumen > this.volumen)
                break;
        }
        return this.encomiendas;
    }
}
