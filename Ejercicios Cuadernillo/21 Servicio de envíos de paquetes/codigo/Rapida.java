package ejercicio21;

public class Rapida implements Entrega {

    public Rapida() {}

    @Override
    public double adicional(Envio envio) {

        return envio.precioRapido();
    }
}
