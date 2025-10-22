package ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String domicilio;
    private List<ConsumoEnergetico> consumosDeEnergia;

    public Usuario(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.consumosDeEnergia = new ArrayList<>();
    }

    public void agregarConsumoEnergia(ConsumoEnergetico consumo) {
        this.consumosDeEnergia.add(consumo);
    }

    private ConsumoEnergetico ultimoConsumoDeUsuario() {
        //retorna el Consumo con fecha mas reciente.
        return this.consumosDeEnergia.stream()
                .max((f1, f2) -> f1.fecha().compareTo(f2.fecha()))
                .orElse(null);
    }

    public Factura emitirFactura(CuadroTarifario cuadro) {
        ConsumoEnergetico consumo = this.ultimoConsumoDeUsuario();
        return new Factura(this, consumo.bonificacion(cuadro), consumo.montoTotal(cuadro));
    }

}
