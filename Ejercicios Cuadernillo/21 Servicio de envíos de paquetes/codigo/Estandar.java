package ejercicio21;

public class Estandar implements Entrega {

    public Estandar() {}

    @Override
    public double adicional(Envio envio) {
        return envio.precioEstandar();
    }


}
