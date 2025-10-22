package ParcialImpuestosBcorregir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {
    private List<Contribuyente> contribuyentes;

    public Agencia() {
        this.contribuyentes = new ArrayList<>();
    }

    public Contribuyente altaContribuyente(String nombre, String dni, String email, String localidad) {
        Contribuyente contribuyente1 = new Contribuyente(nombre, dni, email, localidad);
        this.contribuyentes.add(contribuyente1);
        return contribuyente1;
    }

    public Inmueble altaInmueble(int partida, double valorLote, double valorEdificacion, Contribuyente contribuyente) {
        Inmueble inmueble = new Inmueble(partida, valorLote, valorEdificacion);
        contribuyente.agregarBien(inmueble);
        return inmueble;
    }


    public Automotor altaAutomotor(String patente, String marca, String modelo, double valor,LocalDate fechaFabricacion, Contribuyente contribuyente) {
        Automotor automotor = new Automotor(patente, marca, modelo, valor, fechaFabricacion);
        contribuyente.agregarBien(automotor);
        return automotor;
    }

    public Embarcacion altaEmbarcacion(String patente, String nombre, double valor,LocalDate fechaFabricacion, Contribuyente contribuyente) {
        Embarcacion embarcacion = new Embarcacion(patente,nombre,valor,fechaFabricacion);
        contribuyente.agregarBien(embarcacion);
        return embarcacion;
    }

    public List<Contribuyente> contribuyentesConMaxImpuestos(int num , String nombreLocalidad){
        return this.contribuyentes.stream()
                .filter(c->c.localidad(nombreLocalidad))
                .sorted((c1,c2)->Double.compare(c2.calcularImpuestos(),c1.calcularImpuestos()))
                .limit(num)
                .collect(Collectors.toList());
    }


}
