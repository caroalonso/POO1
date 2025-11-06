package ejercicio21;

public class Corporativo extends Cliente{

    public Corporativo (String nombre, String direccion, int cuit) {
        super(nombre, direccion, cuit);
    }

    public double montoApagarDentroDeUnPeriodo (DateLapse dateLapse){
        return super.montoApagarDentroDeUnPeriodo(dateLapse);
    }
}
