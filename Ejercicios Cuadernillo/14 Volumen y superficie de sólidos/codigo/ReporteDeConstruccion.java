package ejercicio14;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class ReporteDeConstruccion {
    private List<Pieza> piezas;

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<>();
    }

    public void agregarPieza(Pieza pieza) {
        this.piezas.add(pieza);
    }

    public int cantElementosColeccion() {
        return this.piezas.size();
    }

    // Por parametro se pasan directamente las funciones en vez de los parametros para poder
    // reutilizar codigo.

    // import Predicate: Representa una función que recibe un objeto Pieza y devuelve boolean.
    // import ToDoubleFunction : Representa una función que recibe un objeto Pieza y devuelve un double.
    private double retornaTotal(Predicate<Pieza> filtro,ToDoubleFunction<Pieza> operacion) {
        return this.piezas.stream()
                .filter(filtro)
                .mapToDouble(operacion)
                .sum();
    }

    public double superficieDeColor(String unNombreDeColor) {
        return this.retornaTotal(p -> p.esColor(unNombreDeColor), p -> p.superficie());
    }

    public double volumenDeMaterial(String nombreDeMaterial) {
        return this.retornaTotal(p -> p.esMaterial(nombreDeMaterial), p -> p.volumen());
    }
}
